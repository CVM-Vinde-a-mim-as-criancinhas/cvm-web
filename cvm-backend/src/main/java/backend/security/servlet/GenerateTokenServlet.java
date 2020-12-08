package backend.security.servlet;

import backend.data.UserPrincipal;
import backend.data.UsuarioDTO;
import backend.repository.LoginRepository;
import backend.security.dto.TokenValueDTO;
import backend.security.utils.HttpTokenUtils;
import backend.util.Constants;
import backend.util.HttpRequestUtils;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.security.auth.login.LoginException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.io.StringReader;
import java.util.GregorianCalendar;

@WebServlet(name = "GenerateTokenServlet", urlPatterns = {"/login"})
public class GenerateTokenServlet extends HttpServlet {

    private static final long serialVersionUID = 8238147670692818380L;

    boolean isTokenIntegracaoUrl;

    @Inject
    private LoginRepository loginRepository;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserPrincipal userPrincipal = null;
        String matricula;
        String password;
        String nivelPermissao;

        String msgError = "Matricula/senha inválido.";
        String msgErrorEstrutura = "Estrutura fora do padrão esperado.";

        String json = new HttpRequestUtils().getJsonFromRequest(request);

        //parse da request
        JsonObject jsonObject = null;
        JsonReader reader = Json.createReader(new StringReader(json));
        try {
            //tenta ler o payload como json
            jsonObject = reader.readObject();
            reader.close();
        } catch (Exception silent) {
            msgError = msgErrorEstrutura;
        }

        if (jsonObject != null) {
            try {
                try {
                    matricula = jsonObject.getString("matricula");
                    password = jsonObject.getString("senha");
                    nivelPermissao = jsonObject.getString("nivelPermissao");
                } catch (Exception silent) {
                    throw new LoginException(msgErrorEstrutura);
                }

                // faz a validação do usuário no banco
                UsuarioDTO u = loginRepository.executaLogin(matricula, password, nivelPermissao);

                if (u != null) {
                    userPrincipal = new UserPrincipal();
                    userPrincipal.setCodigoTurma(u.getTurma());
                    userPrincipal.setId(u.getId());
                    userPrincipal.setMatricula(u.getMatricula());
                    userPrincipal.setNivelPermisao(nivelPermissao);
                    userPrincipal.setSenha(u.getSenha());
                }

            } catch (Exception silent) {
                msgError = silent.getMessage();
            }
        }

        if (userPrincipal != null) {
            //conteudo da resposta para json
            response.setContentType("application/json;charset=utf-8");

            //expiracao do token
            GregorianCalendar expiracao = new GregorianCalendar();
            expiracao.add(Constants.TIPO_DURACAO_LOGIN, Constants.TEMPO_DURACAO_LOGIN);

            //gera o token e o dto de resposta
            TokenValueDTO tokenDTO = HttpTokenUtils.generateTokenDTO(userPrincipal, expiracao.getTime());
            String token = HttpTokenUtils.generateToken(userPrincipal, expiracao.getTime());

            //adiciona o token no header
            response.addHeader(Constants.AUTH_HEADER, token);

            //adiciona o dto no body
            ObjectMapper mapper = new ObjectMapper();
            if (!this.isTokenIntegracaoUrl) { // login sistema
                mapper.writeValue(response.getOutputStream(), tokenDTO);

            } else {
                this.loginError(response, msgError);
            }

        } else {
            this.loginError(response, msgError);
        }
    }


    private void loginError(HttpServletResponse response, String msgError) throws IOException {
        response.setContentType("application/json;charset=utf-8");
        response.setStatus(Response.Status.UNAUTHORIZED.getStatusCode());
        response.addHeader("x-message", msgError);
        JsonObject data = Json.createObjectBuilder().add("erro", msgError).build();
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(response.getOutputStream(), data);
    }
}

package backend.repository;

import backend.data.*;
import backend.seletor.*;
import backend.repository.base.*;
import javax.security.auth.login.LoginException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class LoginRepository extends BaseRepository<Usuario> {

    public LoginRepository() {
        this.init();
    }

    public UsuarioDTO executaLogin(String registro, String senha) throws LoginException, NoSuchFieldException, IllegalAccessException {
        UsuarioSeletor seletor = new UsuarioSeletor();

        if (registro != null && !registro.isEmpty()) {
            seletor.setNome(registro);
        } else {
            throw new LoginException("Registro vazio ou nulo.");
        }

        if (senha != null && !senha.isEmpty()) {
            seletor.setSenha(senha);
        } else {
            throw new LoginException("Senha vazia ou nula.");
        }

        try {
            return this.doLoginSSO(seletor);
        } catch (Exception silent) {
            throw new LoginException("Registro/senha inválido.");
        }
    }


    public UsuarioDTO doLoginSSO(UsuarioSeletor seletor) {
        try {
            String query = "SELECT nm_nome, id_usuario, nm_senha  FROM tab_usuario WHERE nm_nome = " + seletor.getNome() + " and nm_senha = " + seletor.getSenha();

            PreparedStatement ps = null;
            ps = this.connection.prepareStatement(query);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                UsuarioDTO u = new UsuarioDTO();
                u.setId(rs.getInt("id_usuario"));
                u.setNome(rs.getString("nm_nome"));
                u.setSenha(rs.getString("nm_senha"));

                return u;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}


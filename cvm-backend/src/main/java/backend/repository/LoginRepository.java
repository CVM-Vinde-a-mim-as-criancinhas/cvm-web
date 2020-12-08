package backend.repository;

import backend.data.Usuario;
import backend.data.UsuarioDTO;
import backend.repository.base.BaseRepository;
import backend.seletor.UsuarioSeletor;

import javax.security.auth.login.LoginException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginRepository extends BaseRepository<Usuario> {

    public LoginRepository() {
        this.init();
    }

    public UsuarioDTO executaLogin(String matricula, String senha, String nivelPermissao) throws LoginException, NoSuchFieldException, IllegalAccessException {
        UsuarioSeletor seletor = new UsuarioSeletor();

        if (matricula != null && !matricula.isEmpty()) {
            seletor.setNome(matricula);
        } else {
            throw new LoginException("Matricula vazia ou nula.");
        }

        if (senha != null && !senha.isEmpty()) {
            seletor.setSenha(senha);
        } else {
            throw new LoginException("Senha vazia ou nula.");
        }

        if (nivelPermissao != null && !nivelPermissao.isEmpty()) {
            seletor.setNivelPermissao(nivelPermissao);
        } else {
            throw new LoginException("Nivel permissao vazia ou nula.");
        }

        try {
            return this.doLoginSSO(seletor);
        } catch (Exception silent) {
            throw new LoginException("Matricula/senha inválido.");
        }
    }


    public UsuarioDTO doLoginSSO(UsuarioSeletor seletor) {
        try {
            String query = "";
            if (seletor.getNivelPermissao().equals("1")) {
                query = "SELECT tu.id_usuario as id, tu.nm_matricula, tu.nm_senha, '' as codigoTurma FROM tab_usuario as tu";
            } else if (seletor.getNivelPermissao().equals("2")) {
                query = "SELECT tp.id_professor as id, tp.nm_matricula, tp.nm_senha, tt.codigoTurma FROM tab_professor as tp JOIN tab_turma as tt ON tt.id_turma = tp.cd_turma";
            } else if (seletor.getNivelPermissao().equals("3")) {
                query = "SELECT ta.id_aluno as id, ta.nm_matricula, ta.nm_senha, tt.codigoTurma FROM tab_aluno as ta JOIN tab_turma as tt ON tt.id_turma = ta.cd_turma";
            }

            query += " WHERE nm_matricula = "+ seletor.getNome()+ " and nm_senha = "+ seletor.getSenha();

            PreparedStatement ps = null;
            ps = this.connection.prepareStatement(query);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                UsuarioDTO u = new UsuarioDTO();
                u.setId(rs.getInt("id"));
                u.setMatricula(rs.getString("nm_matricula"));
                u.setSenha(rs.getString("nm_senha"));
                u.setTurma(rs.getString("codigoTurma"));

                return u;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}

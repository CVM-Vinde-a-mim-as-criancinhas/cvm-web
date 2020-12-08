package backend.data;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.security.auth.Subject;
import java.security.Principal;

public class UserPrincipal implements Principal {

    private Integer id;
    private String matricula;
    private String senha;
    private String nivelPermisao;
    private String codigoTurma;
    private String nome;

    @JsonIgnore
    @Override
    public String getName() {
        return this.getMatricula();
    }

    @JsonIgnore
    @Override
    public boolean implies(Subject subject) {
        return false;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNivelPermisao() {
        return nivelPermisao;
    }

    public void setNivelPermisao(String nivelPermisao) {
        this.nivelPermisao = nivelPermisao;
    }

    public String getCodigoTurma() {
        return codigoTurma;
    }

    public void setCodigoTurma(String codigoTurma) {
        this.codigoTurma = codigoTurma;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}

package backend.seletor;

public class UsuarioSeletor {
    private Integer id;
    private String nome;
    private String nivelPermissao;
    private String email;
    private String senha;
    private Boolean ativo;
    private Integer idPerfil;
    private Boolean suporte;

    public boolean possuiFiltro() {
        if (this.id != null && this.id > 0)
            return true;
        if (this.nome != null && !this.nome.isEmpty())
            return true;
        if (this.nivelPermissao != null && !this.nivelPermissao.isEmpty())
            return true;
        if (this.email != null && !this.email.isEmpty())
            return true;
        if (this.senha != null && !this.senha.isEmpty())
            return true;
        if (this.ativo != null)
            return true;
        if (this.idPerfil != null && this.idPerfil > 0)
            return true;
        if (this.suporte != null)
            return true;

        return false;
    }

    @Override
    public String toString() {
        return "UsuarioSeletor{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", nivelPermissao='" + nivelPermissao + '\'' +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                ", ativo=" + ativo +
                ", idPerfil=" + idPerfil +
                ", suporte=" + suporte +
                '}';
    }

    public Integer getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(Integer idPerfil) {
        this.idPerfil = idPerfil;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public Boolean isAtivo() {
        return ativo;
    }

    public Boolean getSuporte() {
        return suporte;
    }

    public void isSuporte(Boolean suporte) {
        this.suporte = suporte;
    }

    public String getNivelPermissao() {
        return nivelPermissao;
    }

    public void setNivelPermissao(String nivelPermissao) {
        this.nivelPermissao = nivelPermissao;
    }
}

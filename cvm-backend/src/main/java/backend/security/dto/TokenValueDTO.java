package backend.security.dto;

import backend.data.UserPrincipal;

import java.util.Date;

public class TokenValueDTO {

    private UserPrincipal sub;
    private Date exp;    //data de expiracao
    private Date gen;    //data de geracao

    @Override
    public String toString() {
        return "TokenValueDTO [sub=" + sub + ", exp=" + exp + ", gen=" + gen
                + "]";
    }

    public UserPrincipal getSub() {
        return sub;
    }

    public void setSub(UserPrincipal sub) {
        this.sub = sub;
    }

    public Date getExp() {
        return exp;
    }

    public void setExp(Date exp) {
        this.exp = exp;
    }

    public Date getGen() {
        return gen;
    }

    public void setGen(Date gen) {
        this.gen = gen;
    }

}

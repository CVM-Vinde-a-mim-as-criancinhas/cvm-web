package backend.security;

import backend.data.UserPrincipal;
import backend.security.dto.TokenValueDTO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.security.Principal;

public class TokenRequestWrapper extends HttpServletRequestWrapper {

    private UserPrincipal principal;

    public TokenRequestWrapper(HttpServletRequest request, TokenValueDTO dto) {
        super(request);
        this.principal = dto.getSub();
    }

    public Principal getUserPrincipal() {
        return this.principal;
    }

    public String getRemoteUser() {
        return this.principal != null ? this.principal.getName() : null;
    }

}

package backend.security;

import backend.security.dto.TokenValueDTO;
import backend.security.exception.TokenException;
import backend.security.utils.HttpTokenUtils;
import backend.util.Constants;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Response.Status;
import java.io.IOException;

@WebFilter(filterName = "ValidateTokenFilter")
public class ValidateTokenFilter implements Filter {

//	Logger logger = LoggerFactory.getLogger(ValidateTokenFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        //bypass do swagger
        if (request.getRequestURI().equalsIgnoreCase("/saad/rest/swagger.json")) {
            chain.doFilter(request, response);
        } else {
            String token = request.getHeader(Constants.AUTH_HEADER);
            if (token == null || token.length() < 1) {
                token = request.getParameter(Constants.AUTH_HEADER);
            }

            //verifica se é uma conexao websocket, se sim pega do parametro
            if (token == null) {
                token = request.getParameter("token");
            }

            try {
                //valida o token da request
                TokenValueDTO dto = HttpTokenUtils.getFromToken(token);

                //valido, encaminha a request
                TokenRequestWrapper wrapper = new TokenRequestWrapper(request, dto);
                chain.doFilter(wrapper, response);

            } catch (TokenException e) {
                response.addHeader("x-message", e.getMessage());
                response.setStatus(Status.UNAUTHORIZED.getStatusCode());
            } catch (IllegalArgumentException e) {
                response.addHeader("x-message", "Token de autorização não encontrado");
                response.setStatus(Status.UNAUTHORIZED.getStatusCode());
            }
        }
    }

    @Override
    public void destroy() {
    }

}

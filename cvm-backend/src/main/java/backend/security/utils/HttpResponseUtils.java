package backend.security.utils;

import javax.servlet.http.HttpServletResponse;

public class HttpResponseUtils {

    public static void addCorsHeaders(HttpServletResponse response) {
//		response.addHeader("Access-Control-Allow-Origin","*.contaminima.com.br");
        response.addHeader("Access-Control-Allow-Origin", "*");
        response.addHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS, PUT, DELETE");
        response.addHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept, x-authorization, Charset");
        response.addHeader("Access-Control-Allow-Credentials", "true");
        response.addHeader("Access-Control-Expose-Headers", "X-Pagination-Total-Entries, X-Order-Field, X-Order-Type, x-authorization, x-message, x-folha-fechada");

//        response.setHeader("Access-Control-Allow-Headers", "Access-Control-Allow-Headers, Origin,Accept, X-Requested-With, Content-Type, Access-Control-Request-Method, Access-Control-Request-Headers");
    }

}

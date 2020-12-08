package backend.util;

import javax.inject.Singleton;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.text.SimpleDateFormat;
import java.util.Date;


@Singleton
public class HttpRequestUtils {

    private SimpleDateFormat sdf;

    public HttpRequestUtils() {
        this.sdf = new SimpleDateFormat("dd/MM/yyyy");
    }

    public String getJsonFromRequest(HttpServletRequest request) {
        StringBuilder jb = new StringBuilder();
        String line = null;
        try {
            BufferedReader reader = request.getReader();
            while ((line = reader.readLine()) != null) {
                jb.append(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jb.toString();
    }

    public String getStringCookie(HttpServletRequest request, String cookieName) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(cookieName)) {
                    return cookie.getValue();
                }
            }
        }
        return null;
    }

    public String getStringParameter(HttpServletRequest request, String parameter) {
        return request.getParameter(parameter);
    }

    public Integer getIntegerParameter(HttpServletRequest request, String parameter) {
        String par = request.getParameter(parameter);
        if (par != null && par.trim().length() > 0) {
            try {
                return Integer.parseInt(par);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return null;
    }

    public Date getDateParameter(HttpServletRequest request, String parameter) {
        String par = request.getParameter(parameter);
        if (par != null && par.trim().length() > 0) {
            try {
                if (par.contains("/")) {
                    //formato dd/mm/aaaa
                    Date data = this.sdf.parse(par);
                    DateUtils.getInstance().resetHours(data);
                    return data;
                } else {
                    //timestamp
                    return new Date(Long.parseLong(par));
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return null;
    }

}

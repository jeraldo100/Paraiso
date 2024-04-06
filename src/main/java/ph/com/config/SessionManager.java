package ph.com.config;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class SessionManager {

    public static final String SESSION_COOKIE_NAME = "PARAISOSESSION";
    public static final int SESSION_COOKIE_MAX_AGE_SECONDS = 86400; 


    public static void createSessionCookie(HttpServletResponse response, String sessionId) {
        Cookie cookie = new Cookie(SESSION_COOKIE_NAME, sessionId);
        cookie.setMaxAge(SESSION_COOKIE_MAX_AGE_SECONDS);
        cookie.setPath("/"); 
        response.addCookie(cookie);
    }

    public static String getSessionId(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (SESSION_COOKIE_NAME.equals(cookie.getName())) {
                    return cookie.getValue();
                }
            }
        }
        return null;
    }
    
    public static void deleteSessionCookie(HttpServletResponse response) {
        Cookie cookie = new Cookie(SESSION_COOKIE_NAME, null);
        cookie.setMaxAge(0); 
        cookie.setPath("/"); 
        response.addCookie(cookie);
    }


}
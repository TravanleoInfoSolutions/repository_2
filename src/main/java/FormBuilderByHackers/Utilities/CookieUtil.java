package FormBuilderByHackers.Utilities;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieUtil {
    @Value("${SERVER.URL}")
    private String SERVER_URL;

    @Autowired
    HttpServletRequest request;

    @Autowired
    HttpServletResponse response;

    public void addCookie(String data, String cookieName) {
        String encodedData = new String(Base64.encodeBase64(data.getBytes()));
        Cookie uiColorCookie = new Cookie(cookieName, encodedData);
        uiColorCookie.setMaxAge(10000);
        uiColorCookie.setDomain(SERVER_URL);
        uiColorCookie.setPath("/");
        uiColorCookie.setSecure(request.isSecure());
        uiColorCookie.setHttpOnly(true);
//		response.setHeader("Set-Cookie", uiColorCookie + "; HttpOnly; SameSite=None");
//		response.setHeader(cookieName, "");
        response.addCookie(uiColorCookie);
    }

    public void removeCookie(String cookieName) {
        Cookie uiColorCookie = new Cookie(cookieName, null);
        uiColorCookie.setMaxAge(0);
        uiColorCookie.setDomain(SERVER_URL);
        uiColorCookie.setPath("/");
        uiColorCookie.setHttpOnly(true);
        response.addCookie(uiColorCookie);
    }



}
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

    public void addCookie(String data, String cookieName,HttpServletRequest request, HttpServletResponse response) {
        String encodedData = new String(Base64.encodeBase64(data.getBytes()));
        Cookie uiColorCookie = new Cookie(cookieName, encodedData);
        response.addCookie(uiColorCookie);
    }

    public void removeCookie(String cookieName,HttpServletResponse response) {
        Cookie uiColorCookie = new Cookie(cookieName, null);
        uiColorCookie.setMaxAge(0);
        response.addCookie(uiColorCookie);
    }



}

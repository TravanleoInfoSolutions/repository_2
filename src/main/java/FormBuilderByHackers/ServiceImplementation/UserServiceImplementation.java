package FormBuilderByHackers.ServiceImplementation;

import FormBuilderByHackers.DataAccessObject.UserDetailsRepository;
import FormBuilderByHackers.Model.UserDetails;
import FormBuilderByHackers.Service.UserService;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Service
public class UserServiceImplementation implements UserService {
    @Autowired
    HttpServletRequest request;
    @Autowired
    private UserDetailsRepository userDetailsRepository;

    public UserDetails getCurrentUserDetails(){
        Cookie cookie = WebUtils.getCookie(request, "authorization");
        UserDetails userDetails = userDetailsRepository.findByEmailId("sree6@travanleo.com");
//        System.err.println("oneee");
//        if (cookie != null) {
//            System.err.println("twoo");
//            byte[] decoded = Base64.decodeBase64(cookie.getValue());
//            String emailId = new String(decoded);
//            userDetails = userDetailsRepository.findByEmailId(emailId);
//        }
        return userDetails;
    }
}

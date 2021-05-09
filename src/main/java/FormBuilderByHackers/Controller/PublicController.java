package FormBuilderByHackers.Controller;

import FormBuilderByHackers.DataTransferObject.LoginDTO;
import FormBuilderByHackers.DataTransferObject.UserRegistrationDTO;
import FormBuilderByHackers.Service.PublicService;
import FormBuilderByHackers.Utilities.CookieUtil;
import FormBuilderByHackers.Utilities.GenericResponse;

import org.opensaml.xml.signature.G;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.validation.Valid;

/**
 * Public APIs that can be accessed without authorisation
 *
 * @author bhavesh
 *
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/public")
public class PublicController {
    @Autowired
    private PublicService publicService;


    @PostMapping("/registerUser")
    public GenericResponse registerUser(@RequestBody @Valid UserRegistrationDTO registrationDTO,BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return new GenericResponse("Email Id cannot be empty");
        }
        return publicService.userRegistration(registrationDTO);
    }
    @PostMapping("/login")
    public GenericResponse login(@RequestBody LoginDTO loginDTO){
        return publicService.validateUser(loginDTO);
    }

    @PostMapping("/logout")
    public GenericResponse logout(){
        new CookieUtil().removeCookie("authorization");
        return new GenericResponse("logged out successfully",true);
    }

}

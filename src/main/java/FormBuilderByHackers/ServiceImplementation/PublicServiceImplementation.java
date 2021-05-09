package FormBuilderByHackers.ServiceImplementation;

import FormBuilderByHackers.DataAccessObject.PublicDAO;
import FormBuilderByHackers.DataTransferObject.LoginDTO;
import FormBuilderByHackers.DataTransferObject.UserRegistrationDTO;
import FormBuilderByHackers.Model.UserDetails;
import FormBuilderByHackers.Service.PublicService;
import FormBuilderByHackers.Utilities.GenericResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.regex.Pattern;

@Service
public class PublicServiceImplementation implements PublicService {
    @Autowired
    private PublicDAO publicDAO;
    public GenericResponse userRegistration(UserRegistrationDTO registrationDTO){
        GenericResponse genericResponse;
        Pattern pattern = Pattern.compile("^[A-Za-z0-9+_.-]+@(.+)$");
        if(pattern.matcher(registrationDTO.getEmailId()).matches()){
            genericResponse = publicDAO.userRegistration(registrationDTO);
        }
        else{
            genericResponse =  new GenericResponse("Invalid Email Id");
        }
        return genericResponse;
    }

    @Override
    public GenericResponse validateUser(LoginDTO loginDto,HttpServletRequest request, HttpServletResponse response) {
        return publicDAO.validateUser(loginDto,request,response);
    }
}

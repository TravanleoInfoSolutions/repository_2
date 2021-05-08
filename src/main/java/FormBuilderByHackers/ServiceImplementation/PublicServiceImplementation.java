package FormBuilderByHackers.ServiceImplementation;

import FormBuilderByHackers.DataAccessObject.PublicDAO;
import FormBuilderByHackers.DataTransferObject.UserRegistrationDTO;
import FormBuilderByHackers.Service.PublicService;
import FormBuilderByHackers.Utilities.GenericResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}

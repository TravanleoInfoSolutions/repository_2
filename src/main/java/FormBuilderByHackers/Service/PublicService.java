package FormBuilderByHackers.Service;

import FormBuilderByHackers.DataTransferObject.LoginDTO;
import FormBuilderByHackers.DataTransferObject.UserRegistrationDTO;
import FormBuilderByHackers.Utilities.GenericResponse;

public interface PublicService {
     GenericResponse userRegistration(UserRegistrationDTO registrationDTO);
     GenericResponse validateUser(LoginDTO loginDto);
}

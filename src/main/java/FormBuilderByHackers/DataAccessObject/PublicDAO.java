package FormBuilderByHackers.DataAccessObject;

import FormBuilderByHackers.DataTransferObject.LoginDTO;
import FormBuilderByHackers.DataTransferObject.UserRegistrationDTO;
import FormBuilderByHackers.Utilities.GenericResponse;

public interface PublicDAO {
    GenericResponse userRegistration(UserRegistrationDTO registrationDTO);
    GenericResponse  validateUser(LoginDTO loginDto);
}

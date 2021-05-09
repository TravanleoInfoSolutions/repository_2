package FormBuilderByHackers.DataAccessObject;

import FormBuilderByHackers.DataTransferObject.LoginDTO;
import FormBuilderByHackers.DataTransferObject.UserRegistrationDTO;
import FormBuilderByHackers.Utilities.GenericResponse;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface PublicDAO {
    GenericResponse userRegistration(UserRegistrationDTO registrationDTO);
    GenericResponse  validateUser(LoginDTO loginDto,HttpServletRequest request, HttpServletResponse response);
}

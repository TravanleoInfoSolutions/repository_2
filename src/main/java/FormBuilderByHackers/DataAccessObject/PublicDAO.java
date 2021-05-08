package FormBuilderByHackers.DataAccessObject;

import FormBuilderByHackers.DataTransferObject.UserRegistrationDTO;
import FormBuilderByHackers.Utilities.GenericResponse;

public interface PublicDAO {
    GenericResponse userRegistration(UserRegistrationDTO registrationDTO);
}

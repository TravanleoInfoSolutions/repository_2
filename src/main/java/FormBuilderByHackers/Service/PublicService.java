package FormBuilderByHackers.Service;

import FormBuilderByHackers.DataTransferObject.UserRegistrationDTO;
import FormBuilderByHackers.Utilities.GenericResponse;

public interface PublicService {
     GenericResponse userRegistration(UserRegistrationDTO registrationDTO);
}

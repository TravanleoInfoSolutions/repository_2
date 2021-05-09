package FormBuilderByHackers.ServiceImplementation;

import FormBuilderByHackers.Model.UserDetails;
import FormBuilderByHackers.Service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImplementation implements UserService {
    public UserDetails getCurrentUserDetails(){
        return new UserDetails();
    }
}

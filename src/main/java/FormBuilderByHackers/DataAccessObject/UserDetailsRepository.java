package FormBuilderByHackers.DataAccessObject;

import FormBuilderByHackers.Model.UserDetails;
import org.springframework.data.repository.CrudRepository;

public interface UserDetailsRepository extends CrudRepository<UserDetails,Long> {
    UserDetails findByEmailId(String emailId);
}

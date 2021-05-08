package FormBuilderByHackers.DataAccessObjectImplementation;

import FormBuilderByHackers.DataAccessObject.PublicDAO;
import FormBuilderByHackers.DataAccessObject.UserDetailsRepository;
import FormBuilderByHackers.DataTransferObject.UserRegistrationDTO;
import FormBuilderByHackers.Model.UserDetails;
import FormBuilderByHackers.Utilities.GenericResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class PublicDAOImplementation implements PublicDAO {
    @Autowired
    private UserDetailsRepository userDetailsRepository;


    public GenericResponse userRegistration(UserRegistrationDTO registrationDTO){
        GenericResponse genericResponse;
        try{
            UserDetails userDetails = userDetailsRepository.findByEmailId(registrationDTO.getEmailId());
            if(null == userDetails){
                userDetails = new UserDetails(registrationDTO);
                userDetailsRepository.save(userDetails);
                genericResponse = new GenericResponse("user Registered successfully",true);
            }
            else{
                genericResponse = new GenericResponse("Email Id already exists");
            }
        }catch (Exception e){
            genericResponse = new GenericResponse("Unexpected error,contact support");
        }
        return genericResponse;
    }
}

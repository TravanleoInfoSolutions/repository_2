package FormBuilderByHackers.DataAccessObjectImplementation;

import FormBuilderByHackers.DataAccessObject.PublicDAO;
import FormBuilderByHackers.DataAccessObject.UserDetailsRepository;
import FormBuilderByHackers.DataTransferObject.LoginDTO;
import FormBuilderByHackers.DataTransferObject.UserRegistrationDTO;
import FormBuilderByHackers.Model.UserDetails;
import FormBuilderByHackers.Utilities.GenericResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.Cookie;

@Transactional
@Repository
public class PublicDAOImplementation implements PublicDAO {
    @Autowired
    private UserDetailsRepository userDetailsRepository;

    @Override
    public GenericResponse userRegistration(UserRegistrationDTO registrationDTO) {
        GenericResponse genericResponse;
        try {
            UserDetails userDetails = userDetailsRepository.findByEmailId(registrationDTO.getEmailId());
            if (null == userDetails) {
                userDetails = new UserDetails(registrationDTO);
                BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
                String encodedPassword = passwordEncoder.encode(userDetails.getPassword());
                userDetails.setPassword(encodedPassword);
                userDetailsRepository.save(userDetails);
                genericResponse = new GenericResponse("user Registered successfully", true);
            } else {
                genericResponse = new GenericResponse("Email Id already exists");
            }
        } catch (Exception e) {
            genericResponse = new GenericResponse("Unexpected error,contact support");
        }
        return genericResponse;
    }
    @Override
    public GenericResponse validateUser(LoginDTO loginDto) {
        GenericResponse genericResponse;
        UserDetails user = userDetailsRepository.findByEmailId(loginDto.getEmailId());
        if (user == null) {
            return new GenericResponse("User does not exist.");
        } else {
            if (!user.getPassword().equals(loginDto.getPassword())) {
                return new GenericResponse("Password mismatch.");
            } else {
                genericResponse = new GenericResponse(user,true);
            }
        }
        return genericResponse;
    }
}

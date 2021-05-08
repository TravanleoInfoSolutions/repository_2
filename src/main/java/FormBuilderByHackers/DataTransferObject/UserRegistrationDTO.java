package FormBuilderByHackers.DataTransferObject;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class UserRegistrationDTO {
    @NotNull(message = "Email Id cannot be empty")
    private String emailId;
    private String firstName;
    private String lastName;
    private String password;


    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

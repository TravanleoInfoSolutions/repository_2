package FormBuilderByHackers.Model;

import FormBuilderByHackers.DataTransferObject.UserRegistrationDTO;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

/**
 * User details
 *
 * @author bhavesh
 *
 */

@Entity
@Table(name = "user_details")
public class UserDetails implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_details_id")
    private long userDetailsId;

    @Column(name ="email_id",length = 444)
    private String emailId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "password")
    private String password;

    @Column(name = "created_date", updatable = false)
    private Timestamp createdDate = new Timestamp(new Date().getTime());

    @Column(name = "update_date")
    private Timestamp updatedDate = new Timestamp(new Date().getTime());

    public UserDetails(){

    }

    public UserDetails(UserRegistrationDTO registrationDTO){
        this.emailId = registrationDTO.getEmailId();
        this.firstName = registrationDTO.getFirstName();
        this.lastName = registrationDTO.getLastName();
        this.password = registrationDTO.getPassword();
    }

    public long getUserDetailsId() {
        return userDetailsId;
    }

    public void setUserDetailsId(long userDetailsId) {
        this.userDetailsId = userDetailsId;
    }

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

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    public Timestamp getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Timestamp updatedDate) {
        this.updatedDate = updatedDate;
    }


}

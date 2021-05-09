package FormBuilderByHackers.Model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Form data
 *
 * @author bhavesh
 *
 */

@Entity
@Table(name = "form_data")
public class FormData implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "form_data_id")
    private long formDataId;

    @Column(name = "form_data_name")
    private String formDataName;

    @Column(name = "created_user_id")
    private long createdUserId;

    @OneToOne(cascade = { CascadeType.REFRESH }, fetch = FetchType.LAZY)
    @JoinColumn(name = "created_user_id", referencedColumnName = "user_details_id", insertable = false, updatable = false)
    private UserDetails createdUser;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "formData")
    @OrderBy("attribute_list_details_id ASC")
    private Set<AttributeDataDetails> AttributeDataDetailsSet = new HashSet<>();

    @Column(name = "created_date", updatable = false)
    private Timestamp createdDate = new Timestamp(new Date().getTime());

    @Column(name = "update_date")
    private Timestamp updatedDate = new Timestamp(new Date().getTime());

    public long getFormDataId() {
        return formDataId;
    }

    public void setFormDataId(long formDataId) {
        this.formDataId = formDataId;
    }

    public String getFormDataName() {
        return formDataName;
    }

    public void setFormDataName(String formDataName) {
        this.formDataName = formDataName;
    }

    public long getCreatedUserId() {
        return createdUserId;
    }

    public void setCreatedUserId(long createdUserId) {
        this.createdUserId = createdUserId;
    }

    public UserDetails getCreatedUser() {
        return createdUser;
    }

    public void setCreatedUser(UserDetails createdUser) {
        this.createdUser = createdUser;
    }

    public Set<AttributeDataDetails> getAttributeDataDetailsSet() {
        return AttributeDataDetailsSet;
    }

    public void setAttributeDataDetailsSet(Set<AttributeDataDetails> attributeDataDetailsSet) {
        AttributeDataDetailsSet = attributeDataDetailsSet;
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

package FormBuilderByHackers.Model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "form_sessions")
public class FormSessions implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "form_session_id")
    private long formSessionId;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "formSessions")
    @OrderBy("attribute_list_details_id ASC")
    private Set<AttributeDataDetails> attributeDataDetailsSet = new HashSet<>();

    @ManyToOne(cascade = { CascadeType.REFRESH }, fetch = FetchType.LAZY)
    @JoinColumn(name = "form_data_id", referencedColumnName = "form_data_id")
    private FormData formData;

    @Column(name = "session_name",length = 800)
    private String sessionName;

    @Column(name = "session_order")
    private Integer sessionOrder;

    @Column(name = "created_date", updatable = false)
    private Timestamp createdDate = new Timestamp(new Date().getTime());

    @Column(name = "update_date")
    private Timestamp updatedDate = new Timestamp(new Date().getTime());

    public long getFormSessionId() {
        return formSessionId;
    }

    public void setFormSessionId(long formSessionId) {
        this.formSessionId = formSessionId;
    }

    public Set<AttributeDataDetails> getAttributeDataDetailsSet() {
        return attributeDataDetailsSet;
    }

    public void setAttributeDataDetailsSet(Set<AttributeDataDetails> attributeDataDetailsSet) {
        this.attributeDataDetailsSet = attributeDataDetailsSet;
    }

    public FormData getFormData() {
        return formData;
    }

    public void setFormData(FormData formData) {
        this.formData = formData;
    }

    public String getSessionName() {
        return sessionName;
    }

    public void setSessionName(String sessionName) {
        this.sessionName = sessionName;
    }

    public Integer getSessionOrder() {
        return sessionOrder;
    }

    public void setSessionOrder(Integer sessionOrder) {
        this.sessionOrder = sessionOrder;
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

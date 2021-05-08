package FormBuilderByHackers.Model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Attribute data details
 *
 * @author bhavesh
 *
 */

@Entity
@Table(name = "attribute_data_details")
public class AttributeDataDetails implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="attribute_data_details_gen")
    @SequenceGenerator(name="attribute_data_details_gen", sequenceName="AttributeDataDetails_SEQ",allocationSize = 10)
    @Column(name = "attribute_data_details_id")
    private long attributeDataDetailsId;

    @Column(name = "attribute_id")
    private long attributeId;

    @OneToOne(cascade = { CascadeType.REFRESH }, fetch = FetchType.EAGER)
    @JoinColumn(name = "attribute_id", referencedColumnName = "attribute_id", insertable = false, updatable = false)
    private FormAttribute formAttribute;

    @Column(name = "attribute_value",length = 5000)
    private String attributeValue;

    @Column(name = "group_name",length = 800)
    private String groupName;

    @Column(name = "attribute_order")
    private Integer attributeOrder;

    @ManyToOne(cascade = { CascadeType.REFRESH }, fetch = FetchType.LAZY)
    @JoinColumn(name = "form_data_id", referencedColumnName = "form_data_id",insertable = false, updatable = false)
    private FormData formData;

    @Column(name = "created_date", updatable = false)
    private Timestamp createdDate = new Timestamp(new Date().getTime());

    @Column(name = "update_date")
    private Timestamp updatedDate = new Timestamp(new Date().getTime());

    public long getAttributeDataDetailsId() {
        return attributeDataDetailsId;
    }

    public void setAttributeDataDetailsId(long attributeDataDetailsId) {
        this.attributeDataDetailsId = attributeDataDetailsId;
    }

    public long getAttributeId() {
        return attributeId;
    }

    public void setAttributeId(long attributeId) {
        this.attributeId = attributeId;
    }

    public FormAttribute getFormAttribute() {
        return formAttribute;
    }

    public void setFormAttribute(FormAttribute formAttribute) {
        this.formAttribute = formAttribute;
    }

    public String getAttributeValue() {
        return attributeValue;
    }

    public void setAttributeValue(String attributeValue) {
        this.attributeValue = attributeValue;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Integer getAttributeOrder() {
        return attributeOrder;
    }

    public void setAttributeOrder(Integer attributeOrder) {
        this.attributeOrder = attributeOrder;
    }

    public FormData getFormData() {
        return formData;
    }

    public void setFormData(FormData formData) {
        this.formData = formData;
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

package FormBuilderByHackers.Model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Attribute list details
 *
 * @author bhavesh
 *
 */

@Entity
@Table(name = "attribute_list_details")
public class AttributeListDetails implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="attribute_list_details_gen")
    @SequenceGenerator(name="attribute_list_details_gen", sequenceName="AttributeListDetails_SEQ",allocationSize = 10)
    @Column(name = "attribute_list_details_id")
    private long attributeListDetailsId;

    @Column(name = "value",length = 800)
    private String value;

    @ManyToOne(cascade = { CascadeType.REFRESH }, fetch = FetchType.LAZY)
    @JoinColumn(name = "attribute_id", referencedColumnName = "attribute_id",insertable = false, updatable = false)
    private FormAttribute attributeData;

    @Column(name = "created_date", updatable = false)
    private Timestamp createdDate = new Timestamp(new Date().getTime());

    @Column(name = "update_date")
    private Timestamp updatedDate = new Timestamp(new Date().getTime());

    public long getAttributeListDetailsId() {
        return attributeListDetailsId;
    }

    public void setAttributeListDetailsId(long attributeListDetailsId) {
        this.attributeListDetailsId = attributeListDetailsId;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public FormAttribute getAttributeData() {
        return attributeData;
    }

    public void setAttributeData(FormAttribute attributeData) {
        this.attributeData = attributeData;
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

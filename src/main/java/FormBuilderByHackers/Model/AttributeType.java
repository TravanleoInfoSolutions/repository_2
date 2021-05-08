package FormBuilderByHackers.Model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Attribute type
 *
 * @author bhavesh
 *
 */

@Entity
@Table(name = "attribute_type")
public class AttributeType implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "attribute_type_id")
    private int formAttributeTypeId;

    @Column(name = "type_name")
    private String typeName;

    @Column(name = "type_code")
    private String typeCode;

    @Column(name = "created_date", updatable = false)
    private Timestamp createdDate = new Timestamp(new Date().getTime());

    @Column(name = "update_date")
    private Timestamp updatedDate = new Timestamp(new Date().getTime());

    public AttributeType(){

    }

    public AttributeType(String typeName,String typeCode){
        this.typeName = typeName;
        this.typeCode = typeCode;
    }

    public int getFormAttributeTypeId() {
        return formAttributeTypeId;
    }

    public void setFormAttributeTypeId(int formAttributeTypeId) {
        this.formAttributeTypeId = formAttributeTypeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
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

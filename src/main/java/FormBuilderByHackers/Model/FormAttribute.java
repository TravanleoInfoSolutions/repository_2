package FormBuilderByHackers.Model;

import FormBuilderByHackers.DataTransferObject.FormAttributeDTO;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Form attribute
 *
 * @author bhavesh
 *
 */

@Entity
@Table(name = "form_attribute")
public class FormAttribute implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="form_attribute_gen")
    @SequenceGenerator(name="form_attribute_gen", sequenceName="FormAttribute_SEQ",allocationSize = 10)
    @Column(name = "attribute_id")
    private long attributeId;

    @Column(name = "attribute_name",length = 800)
    private String attributeName;

    @Column(name = "attribute_type_id")
    private long attributeTypeId;

    @OneToOne(cascade = { CascadeType.REFRESH }, fetch = FetchType.EAGER)
    @JoinColumn(name = "attribute_type_id", referencedColumnName = "attribute_type_id", insertable = false, updatable = false)
    private AttributeType attributeType;

    @Column(name = "group_name",length = 800)
    private String groupName;

    @Column(name = "attribute_order")
    private Integer attributeOrder;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "attributeData")
    @OrderBy("attribute_list_details_id ASC")
    private Set<AttributeListDetails> AttributeListDetailsSet = new HashSet<>();

    @Column(name = "created_user_id")
    private long createdUserId;

    @OneToOne(cascade = { CascadeType.REFRESH }, fetch = FetchType.LAZY)
    @JoinColumn(name = "created_user_id", referencedColumnName = "user_details_id", insertable = false, updatable = false)
    private UserDetails createdUser;

    @Column(name = "created_date", updatable = false)
    private Timestamp createdDate = new Timestamp(new Date().getTime());

    @Column(name = "update_date")
    private Timestamp updatedDate = new Timestamp(new Date().getTime());

    public FormAttribute(){

    }

    public FormAttribute(FormAttributeDTO formAttributeDTO){
        this.attributeId = formAttributeDTO.getAttributeId();
        this.attributeName = formAttributeDTO.getAttributeName();
        this.attributeTypeId = formAttributeDTO.getAttributeTypeId();
        this.groupName = formAttributeDTO.getGroupName();
        this.attributeOrder = formAttributeDTO.getAttributeOrder();

    }

    public long getAttributeId() {
        return attributeId;
    }

    public void setAttributeId(long attributeId) {
        this.attributeId = attributeId;
    }

    public String getAttributeName() {
        return attributeName;
    }

    public void setAttributeName(String attributeName) {
        this.attributeName = attributeName;
    }

    public long getAttributeTypeId() {
        return attributeTypeId;
    }

    public void setAttributeTypeId(long attributeTypeId) {
        this.attributeTypeId = attributeTypeId;
    }

    public AttributeType getAttributeType() {
        return attributeType;
    }

    public void setAttributeType(AttributeType attributeType) {
        this.attributeType = attributeType;
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

    public Set<AttributeListDetails> getAttributeListDetailsSet() {
        return AttributeListDetailsSet;
    }

    public void setAttributeListDetailsSet(Set<AttributeListDetails> attributeListDetailsSet) {
        AttributeListDetailsSet = attributeListDetailsSet;
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

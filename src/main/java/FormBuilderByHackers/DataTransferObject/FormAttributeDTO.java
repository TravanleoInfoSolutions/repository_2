package FormBuilderByHackers.DataTransferObject;

import FormBuilderByHackers.Model.AttributeListDetails;

import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

public class FormAttributeDTO {
    private Long attributeId;
    @NotNull
    private String attributeName;
    @NotNull
    private Long attributeTypeId;
    private String groupName;
    private Integer attributeOrder;
    private Set<AttributeListDetails> attributeListDetailsSet = new HashSet<>();

    public Long getAttributeId() {
        return attributeId;
    }

    public void setAttributeId(Long attributeId) {
        this.attributeId = attributeId;
    }


    public String getAttributeName() {
        return attributeName;
    }

    public void setAttributeName(String attributeName) {
        this.attributeName = attributeName;
    }

    public Long getAttributeTypeId() {
        return attributeTypeId;
    }

    public void setAttributeTypeId(Long attributeTypeId) {
        this.attributeTypeId = attributeTypeId;
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
        return attributeListDetailsSet;
    }

    public void setAttributeListDetailsSet(Set<AttributeListDetails> attributeListDetailsSet) {
        this.attributeListDetailsSet = attributeListDetailsSet;
    }
}

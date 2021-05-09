package FormBuilderByHackers.StartUpLoader;

import FormBuilderByHackers.Constants.AttributeTypeLiterals;
import FormBuilderByHackers.DataAccessObject.AttributeTypeRepository;
import FormBuilderByHackers.Model.AttributeType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class StartUpDataLoader implements ApplicationListener<ContextRefreshedEvent> {
@Autowired
private AttributeTypeRepository attributeTypeRepository;


boolean updateDatabaseMasters = false;
    public void onApplicationEvent(final ContextRefreshedEvent event) {
        if(updateDatabaseMasters) {

            //Create Attribute Type
            this.createAttributeTypeIfNotFound(AttributeTypeLiterals.ATTRIBUTE_TYPE_BOOLEAN_NAME.getValue(),
                    AttributeTypeLiterals.ATTRIBUTE_TYPE_BOOLEAN_CODE.getValue());
            this.createAttributeTypeIfNotFound(AttributeTypeLiterals.ATTRIBUTE_TYPE_INTEGER_NAME.getValue(),
                    AttributeTypeLiterals.ATTRIBUTE_TYPE_INTEGER_CODE.getValue());
            this.createAttributeTypeIfNotFound(AttributeTypeLiterals.ATTRIBUTE_TYPE_LONG_NAME.getValue(),
                    AttributeTypeLiterals.ATTRIBUTE_TYPE_LONG_CODE.getValue());
            this.createAttributeTypeIfNotFound(AttributeTypeLiterals.ATTRIBUTE_TYPE_DOUBLE_NAME.getValue(),
                    AttributeTypeLiterals.ATTRIBUTE_TYPE_DOUBLE_CODE.getValue());
            this.createAttributeTypeIfNotFound(AttributeTypeLiterals.ATTRIBUTE_TYPE_DATE_NAME.getValue(),
                    AttributeTypeLiterals.ATTRIBUTE_TYPE_DATE_CODE.getValue());
            this.createAttributeTypeIfNotFound(AttributeTypeLiterals.ATTRIBUTE_TYPE_CHECKBOX_NAME.getValue(),
                    AttributeTypeLiterals.ATTRIBUTE_TYPE_CHECKBOX_CODE.getValue());
            this.createAttributeTypeIfNotFound(AttributeTypeLiterals.ATTRIBUTE_TYPE_SINGLE_LIST_NAME.getValue(),
                    AttributeTypeLiterals.ATTRIBUTE_TYPE_SINGLE_LIST_CODE.getValue());
            this.createAttributeTypeIfNotFound(AttributeTypeLiterals.ATTRIBUTE_TYPE_MULTI_LIST_NAME.getValue(),
                    AttributeTypeLiterals.ATTRIBUTE_TYPE_MULTI_LIST_CODE.getValue());
            this.createAttributeTypeIfNotFound(AttributeTypeLiterals.ATTRIBUTE_TYPE_RADIO_BUTTON_NAME.getValue(),
                    AttributeTypeLiterals.ATTRIBUTE_TYPE_RADIO_BUTTON_CODE.getValue());
            this.createAttributeTypeIfNotFound(AttributeTypeLiterals.ATTRIBUTE_TYPE_TEXT_BOX_NAME.getValue(),
                    AttributeTypeLiterals.ATTRIBUTE_TYPE_TEXT_BOX_CODE.getValue());
            this.createAttributeTypeIfNotFound(AttributeTypeLiterals.ATTRIBUTE_TYPE_TEXT_AREA_NAME.getValue(),
                    AttributeTypeLiterals.ATTRIBUTE_TYPE_TEXT_AREA_CODE.getValue());

        }
    }

    private void createAttributeTypeIfNotFound(String typeName,String typeCode){
        AttributeType attributeType = attributeTypeRepository.findByTypeCode(typeCode);
        if(attributeType == null){
            attributeType = new AttributeType(typeName,typeCode);
            attributeTypeRepository.save(attributeType);
        }
    }
}

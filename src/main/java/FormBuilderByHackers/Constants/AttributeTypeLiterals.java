package FormBuilderByHackers.Constants;

/**
 * Attribute type name and short codes
 *
 * @author bhavesh
 *
 */
public enum AttributeTypeLiterals {
    ATTRIBUTE_TYPE_BOOLEAN_NAME("Boolean"),ATTRIBUTE_TYPE_BOOLEAN_CODE("BOL"),
    ATTRIBUTE_TYPE_INTEGER_NAME("Integer"),ATTRIBUTE_TYPE_INTEGER_CODE("INT"),
    ATTRIBUTE_TYPE_LONG_NAME("Long"),ATTRIBUTE_TYPE_LONG_CODE("LNG"),
    ATTRIBUTE_TYPE_DOUBLE_NAME("Double"),ATTRIBUTE_TYPE_DOUBLE_CODE("DOBL"),
    ATTRIBUTE_TYPE_DATE_NAME("Date"),ATTRIBUTE_TYPE_DATE_CODE("DATE"),
    ATTRIBUTE_TYPE_CHECKBOX_NAME("Checkbox"),ATTRIBUTE_TYPE_CHECKBOX_CODE("CHBX"),
    ATTRIBUTE_TYPE_SINGLE_LIST_NAME("SingleList"),ATTRIBUTE_TYPE_SINGLE_LIST_CODE("SL"),
    ATTRIBUTE_TYPE_MULTI_LIST_NAME("MultiList"),ATTRIBUTE_TYPE_MULTI_LIST_CODE("ML"),
    ATTRIBUTE_TYPE_RADIO_BUTTON_NAME("RadioButton"),ATTRIBUTE_TYPE_RADIO_BUTTON_CODE("RB"),
    ATTRIBUTE_TYPE_TEXT_BOX_NAME("Text Box"),ATTRIBUTE_TYPE_TEXT_BOX_CODE("TB"),
    ATTRIBUTE_TYPE_TEXT_AREA_NAME("Text Area"),ATTRIBUTE_TYPE_TEXT_AREA_CODE("TA");

    private String value;

    AttributeTypeLiterals (String value){
        this.value = value;
    }

  public String getValue(){
        return value;
  }
}

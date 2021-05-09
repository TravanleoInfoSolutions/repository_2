package FormBuilderByHackers.Strategies;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;

public class FormListStrategy implements ExclusionStrategy {

    @Override
    public boolean shouldSkipField(FieldAttributes fieldAttributes) {
        return fieldAttributes.getName().equalsIgnoreCase("AttributeDataDetailsSet");
    }

    @Override
    public boolean shouldSkipClass(Class<?> aClass) {
        return false;
    }
}

package FormBuilderByHackers.Strategies;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;

public class FormViewStrategy implements ExclusionStrategy {

    @Override
    public boolean shouldSkipField(FieldAttributes fieldAttributes) {
        return fieldAttributes.getName().equalsIgnoreCase("attributeData")
                ||fieldAttributes.getName().equalsIgnoreCase("formData");
    }

    @Override
    public boolean shouldSkipClass(Class<?> aClass) {
        return false;
    }
}

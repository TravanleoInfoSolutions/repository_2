package FormBuilderByHackers.DataAccessObject;

import FormBuilderByHackers.Model.AttributeType;
import org.springframework.data.repository.CrudRepository;

public interface AttributeTypeRepository extends CrudRepository<AttributeType,Integer> {
    AttributeType findByTypeCode(String typeCode);
}

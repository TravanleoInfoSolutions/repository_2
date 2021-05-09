package FormBuilderByHackers.DataAccessObject;

import FormBuilderByHackers.Model.FormAttribute;
import FormBuilderByHackers.Model.UserDetails;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface FormAttributeRepository extends CrudRepository<FormAttribute,Long> {
    @Query("SELECT root FROM FormAttribute root WHERE root.createdUserId = ?1 ")
    Page<FormAttribute> findAllByCreatedUser(Long userId, Pageable pageRequest);

    @Query("SELECT root FROM FormAttribute root WHERE LOWER(root.attributeName) LIKE %?1% AND root.createdUserId = ?2 ")
    Page<FormAttribute> searchAllByCreatedUser(String searchKey, Long userId, Pageable pageRequest);
}
package FormBuilderByHackers.DataAccessObject;

import FormBuilderByHackers.Model.FormData;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface FormDataRepository extends CrudRepository<FormData,Long> {
    @Query("SELECT root FROM FormData root WHERE root.createdUserId = ?1 ")
    Page<FormData> findAllByCreatedUser(Long userId, Pageable pageRequest);

    @Query("SELECT root FROM FormData root WHERE LOWER(root.formDataName) LIKE %?1% AND root.createdUserId = ?2 ")
    Page<FormData> searchAllByCreatedUser(String searchKey, Long userId, Pageable pageRequest);
}

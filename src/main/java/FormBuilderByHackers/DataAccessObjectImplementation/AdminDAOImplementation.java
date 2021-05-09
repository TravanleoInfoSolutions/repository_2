package FormBuilderByHackers.DataAccessObjectImplementation;

import FormBuilderByHackers.DataAccessObject.AdminDAO;
import FormBuilderByHackers.DataAccessObject.AttributeTypeRepository;
import FormBuilderByHackers.DataAccessObject.FormAttributeRepository;
import FormBuilderByHackers.DataAccessObject.FormDataRepository;
import FormBuilderByHackers.DataTransferObject.FormAttributeDTO;
import FormBuilderByHackers.DataTransferObject.ListDTO;
import FormBuilderByHackers.Model.AttributeListDetails;
import FormBuilderByHackers.Model.FormAttribute;
import FormBuilderByHackers.Model.FormData;
import FormBuilderByHackers.Model.UserDetails;
import FormBuilderByHackers.Utilities.GenericResponse;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.IterableUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Repository
@Transactional
public class AdminDAOImplementation implements AdminDAO {
    @Autowired
    private FormAttributeRepository formAttributeRepository;

    @Autowired
    private AttributeTypeRepository attributeTypeRepository;

    @Autowired
    private FormDataRepository formDataRepository;

    public GenericResponse createFormAttribute(FormAttributeDTO formAttributeDTO, UserDetails currentUserDetails){
        GenericResponse genericResponse;
        try{
            FormAttribute formAttribute = new FormAttribute(formAttributeDTO);
            formAttribute.setCreatedUserId(currentUserDetails.getUserDetailsId());
            Set<AttributeListDetails> attributeListDetailsSet = formAttributeDTO.getAttributeListDetailsSet();
            if(CollectionUtils.isNotEmpty(attributeListDetailsSet)){
                attributeListDetailsSet.forEach(alds -> alds.setAttributeData(formAttribute));
                formAttribute.setAttributeListDetailsSet(attributeListDetailsSet);
            }
            FormAttribute savedFormAttribute = formAttributeRepository.save(formAttribute);
            Map<String,Object> response = new HashMap<>();
            response.put("attributeId",savedFormAttribute.getAttributeId());
            response.put("message",formAttributeDTO.getAttributeId() != null
                    ?"Form Attribute updated successfully" :"Form Attribute created successfully");
            genericResponse = new GenericResponse(response,true);
        }
        catch (Exception e){
            genericResponse = new GenericResponse("unexpected error");
        }
        return genericResponse;
    }

    public GenericResponse fetchAttributeTypes(){
        return new GenericResponse(IterableUtils.toList(attributeTypeRepository.findAll()),true);
    }

    public GenericResponse listAttributes(ListDTO listDTO,UserDetails currentUserDetails){
        GenericResponse genericResponse;
        try {
            Pageable pageRequest = PageRequest.of(listDTO.getPageNumber(), listDTO.getPageSize(),
                    Sort.by("attributeName").ascending());
            Page<FormAttribute> attributeList = null;
            if (StringUtils.isEmpty(listDTO.getKeyword())) {
                attributeList = formAttributeRepository.findAllByCreatedUser(currentUserDetails.getUserDetailsId(), pageRequest);
            } else {
                attributeList = formAttributeRepository.searchAllByCreatedUser(listDTO.getKeyword().toLowerCase(),
                        currentUserDetails.getUserDetailsId(), pageRequest);
            }
            genericResponse = new GenericResponse(attributeList,true);
        }
        catch (Exception e){
            genericResponse = new GenericResponse("unexpected error");
        }
        return genericResponse;
    }

   public GenericResponse createForm(FormData formData, UserDetails currentUserDetails){
        GenericResponse genericResponse;
        try{
            formData.setCreatedUserId(currentUserDetails.getUserDetailsId());
            formData.getAttributeDataDetailsSet().forEach(adds -> adds.setFormData(formData));
            FormData savedFormData = formDataRepository.save(formData);
            Map<String,Object> response = new HashMap<>();
            response.put("formDataId",savedFormData.getFormDataId());
            response.put("message",formData.getFormDataId() != 0
                    ?"Form Attribute updated successfully" :"Form Attribute created successfully");
            genericResponse = new GenericResponse(response,true);
        }
        catch (Exception e){
            genericResponse = new GenericResponse("unexpected error");
        }
        return genericResponse;
    }

    public GenericResponse listForms(ListDTO listDTO,UserDetails currentUserDetails){
        GenericResponse genericResponse;
        try {
            Pageable pageRequest = PageRequest.of(listDTO.getPageNumber(), listDTO.getPageSize(),
                    Sort.by("createdDate").descending());
            Page<FormData> formList = null;
            if (StringUtils.isEmpty(listDTO.getKeyword())) {
                formList = formDataRepository.findAllByCreatedUser(currentUserDetails.getUserDetailsId(), pageRequest);
            } else {
                formList = formDataRepository.searchAllByCreatedUser(listDTO.getKeyword().toLowerCase(),
                        currentUserDetails.getUserDetailsId(), pageRequest);
            }
            genericResponse = new GenericResponse(formList,true);
        }
        catch (Exception e){
            genericResponse = new GenericResponse("unexpected error");
        }
        return genericResponse;
    }
}

package FormBuilderByHackers.ServiceImplementation;

import FormBuilderByHackers.DataAccessObject.AdminDAO;
import FormBuilderByHackers.DataAccessObject.FormAttributeRepository;
import FormBuilderByHackers.DataAccessObject.FormDataRepository;
import FormBuilderByHackers.DataTransferObject.FormAttributeDTO;
import FormBuilderByHackers.DataTransferObject.ListDTO;
import FormBuilderByHackers.Model.AttributeListDetails;
import FormBuilderByHackers.Model.FormAttribute;
import FormBuilderByHackers.Model.FormData;
import FormBuilderByHackers.Model.UserDetails;
import FormBuilderByHackers.Service.AdminService;
import FormBuilderByHackers.Utilities.GenericResponse;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class AdminServiceImplementation implements AdminService {
    @Autowired
    private AdminDAO adminDAO;
    @Autowired
    private FormDataRepository formDataRepository;

    public GenericResponse createFormAttribute(FormAttributeDTO formAttributeDTO, UserDetails currentUserDetails){
        return adminDAO.createFormAttribute(formAttributeDTO,currentUserDetails);
    }

    public GenericResponse fetchAttributeTypes(){
        return adminDAO.fetchAttributeTypes();
    }

    public GenericResponse listAttributes(ListDTO listDTO, UserDetails currentUserDetails){
        return adminDAO.listAttributes(listDTO,currentUserDetails);
    }

    public GenericResponse createForm(FormData formData, UserDetails currentUserDetails){
        return adminDAO.createForm(formData,currentUserDetails);
    }

    public GenericResponse listForms(ListDTO listDTO,UserDetails currentUserDetails){
        return adminDAO.listForms(listDTO,currentUserDetails);
    }

    public GenericResponse fetchFormsById(Long formDataId){
        FormData formData = formDataRepository.findById(formDataId).orElse(null);
        return new GenericResponse(formData,true);
    }
}

package FormBuilderByHackers.Service;

import FormBuilderByHackers.DataTransferObject.FormAttributeDTO;
import FormBuilderByHackers.DataTransferObject.ListDTO;
import FormBuilderByHackers.Model.FormData;
import FormBuilderByHackers.Model.UserDetails;
import FormBuilderByHackers.Utilities.GenericResponse;

public interface AdminService {
    GenericResponse createFormAttribute(FormAttributeDTO formAttributeDTO,UserDetails currentUserDetails);

    GenericResponse fetchAttributeTypes();

    GenericResponse listAttributes(ListDTO listDTO,UserDetails currentUserDetails);

    GenericResponse createForm(FormData formData,UserDetails currentUserDetails);

    GenericResponse listForms(ListDTO listDTO,UserDetails currentUserDetails);

    GenericResponse fetchFormsById(Long formDataId);

    GenericResponse fetchAttributeById(Long attributeId);

}

package FormBuilderByHackers.Controller;

import FormBuilderByHackers.DataTransferObject.FormAttributeDTO;
import FormBuilderByHackers.DataTransferObject.ListDTO;
import FormBuilderByHackers.Model.FormData;
import FormBuilderByHackers.Model.UserDetails;
import FormBuilderByHackers.Service.AdminService;
import FormBuilderByHackers.Service.JsonConverter;
import FormBuilderByHackers.Service.UserService;
import FormBuilderByHackers.Strategies.AttributeListStrategy;
import FormBuilderByHackers.Strategies.FormListStrategy;
import FormBuilderByHackers.Strategies.FormViewStrategy;
import FormBuilderByHackers.Utilities.GenericResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;
    @Autowired
    private UserService userService;
    @Autowired
    private JsonConverter jsonConverter;

    @PostMapping("/createFormAttribute")
    public GenericResponse createFormAttribute(@RequestBody @Valid FormAttributeDTO formAttributeDTO,
                                               BindingResult bindingResult){
        GenericResponse genericResponse;
        if(bindingResult.hasErrors()){
            genericResponse = new GenericResponse("Data provided is not sufficient to create Form Attribute");
        }
        else{
            genericResponse = adminService.createFormAttribute(formAttributeDTO,userService.getCurrentUserDetails());
        }
        return genericResponse;
    }

    @GetMapping("/fetchAttributeTypes")
    public GenericResponse fetchAttributeTypes(){
        return adminService.fetchAttributeTypes();
    }

    @PostMapping("/listAttributes")
    public String listAttributes(@RequestBody ListDTO listDTO){
        UserDetails currentUserDetails = userService.getCurrentUserDetails();
        return jsonConverter.convertEntityToJsonProxy(adminService.listAttributes(listDTO,currentUserDetails),
                new AttributeListStrategy());
    }

    @PostMapping("/createForm")
    public GenericResponse createForm(@RequestBody FormData formData){
        UserDetails currentUserDetails = userService.getCurrentUserDetails();
        return adminService.createForm(formData,currentUserDetails);
    }

    @PostMapping("/listForms")
    public String listForms(@RequestBody ListDTO listDTO){
        UserDetails currentUserDetails = userService.getCurrentUserDetails();
        return jsonConverter.convertEntityToJsonProxy(adminService.listForms(listDTO,currentUserDetails),
                new FormListStrategy());
    }

    @GetMapping("/fetchFormsById")
    public String fetchFormsById(@RequestParam Long formDataId){
        return jsonConverter.convertEntityToJsonProxy(adminService.fetchFormsById(formDataId),new FormViewStrategy());
    }


}

package ba.infostudio.hcm.ogOrganizationalPartTypes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
public class OgOrganizationalPartTypeController {
	
	@Autowired
	private OgOrganizationalPartTypeService ogOrganizationalPartTypeService;

	@RequestMapping("/ogOrganizationalPartTypes")
	public List<OgOrganizationalPartType> getAllOgOrganizationalPartTypes() {
		return ogOrganizationalPartTypeService.getAllOgOrganizationalPartTypes();
	}
	
	@RequestMapping("/ogOrganizationalPartTypes/{id}")
	public OgOrganizationalPartType getOgOrganizationalPartType(@PathVariable String id) {
		return ogOrganizationalPartTypeService.getOgOrganizationalPartType(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/ogOrganizationalPartTypes")
	public void addOgOrganizationalPartType(@RequestBody OgOrganizationalPartType ogOrganizationalPartType) {
		ogOrganizationalPartTypeService.addOgOrganizationalPartType(ogOrganizationalPartType);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/ogOrganizationalPartTypes/{id}")
	public void updateOgOrganizationalPartType(@RequestBody OgOrganizationalPartType ogOrganizationalPartType, @PathVariable String id) {
		ogOrganizationalPartTypeService.updateOgOrganizationalPartType(ogOrganizationalPartType);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/ogOrganizationalPartTypes/{id}")
	public void deleteOgOrganizationalPartType(@PathVariable String id) {
		ogOrganizationalPartTypeService.deleteOgOrganizationalPartType(id);
	}
}
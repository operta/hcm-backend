package ba.infostudio.hcm.ogWorkPlaceTypes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = "*")
@RestController

public class OgWorkPlaceTypesController {
	
	
	@Autowired
	private OgWorkPlaceTypesService ogWorkPlaceTypesService;

	@RequestMapping("/ogWorkPlaceTypes")
	public List<OgWorkPlaceTypes> getAllOgWorkPlaceTypes(@RequestParam(defaultValue="id") String sortBy, 
			@RequestParam(defaultValue="ASC") String sort, @RequestParam(defaultValue="") String queryBy, 
			@RequestParam(defaultValue="") String query) {
		return ogWorkPlaceTypesService.getAllOgWorkPlaceTypes(sortBy, sort, queryBy, query);
	}
	
	@RequestMapping("/ogWorkPlaceTypes/{id}")
	public OgWorkPlaceTypes getOgWorkPlaceTypes(@PathVariable String id) {
		return ogWorkPlaceTypesService.getOgWorkPlaceTypes(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/ogWorkPlaceTypes")
	public OgWorkPlaceTypes addOgWorkPlaceTypes(@RequestBody OgWorkPlaceTypes ogWorkPlaceTypes) {
		return ogWorkPlaceTypesService.addOgWorkPlaceTypes(ogWorkPlaceTypes);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/ogWorkPlaceTypes/{id}")
	public void updateRgSkill(@RequestBody OgWorkPlaceTypes ogWorkPlaceTypes, @PathVariable String id) {
		ogWorkPlaceTypesService.updateOgWorkPlaceTypes(ogWorkPlaceTypes);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/ogWorkPlaceTypes/{id}")
	public void deleteRgSkill(@PathVariable String id) {
		ogWorkPlaceTypesService.deleteOgWorkPlaceTypes(id);
	}

}

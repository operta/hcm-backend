package ba.infostudio.hcm.leLegalEntityTypes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin("*")
public class LeLegalEntityTypeController {

	@Autowired
	private LeLegalEntityTypeService leLegalEntityTypeService ;
	
	@RequestMapping("/leLegalEntityTypes")
	public List<LeLegalEntityType> getAllLegalEntityTypes(){
		return leLegalEntityTypeService.getAllLegalEntityTypes();
	}
	
	@RequestMapping("/leLegalEntityTypes/{id}")
	public LeLegalEntityType getLegalEntityType(@PathVariable Long id){
		return leLegalEntityTypeService.getLeLegalEntityType(id);
	}

	@RequestMapping(method=RequestMethod.POST, value="/leLegalEntityTypes/")
	public void addLegalEntityType(@RequestBody LeLegalEntityType leLegalEntityType){
		leLegalEntityTypeService.addLeLegalEntityType(leLegalEntityType);
		
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/leLegalEntityTypes/")
	public void updateLegalEntityType(@RequestBody LeLegalEntityType leLegalEntityType){
		leLegalEntityTypeService.updateLeLegalEntityType(leLegalEntityType);
		
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/leLegalEntityTypes/")
	public void deleteLegalEntityType(@RequestBody LeLegalEntityType leLegalEntityType){
		leLegalEntityTypeService.deleteLeLegalEntityType(leLegalEntityType);
		
	}
	
}

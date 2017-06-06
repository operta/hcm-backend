package ba.infostudio.hcm.emRewardTypes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class EmRewardTypeController {
	
	@Autowired
	private EmRewardTypeService emRewardTypeService;

	@RequestMapping("/emRewardTypes")
	public List<EmRewardType> getAllupdateEmRewardTypes() {
		return emRewardTypeService.getAllEmRewardTypes();
	}
	
	@RequestMapping("/emRewardTypes/{id}")
	public EmRewardType getEmRewardType(@PathVariable String id) {
		return emRewardTypeService.getEmRewardType(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/emRewardTypes")
	public void addEmRewardType(@RequestBody EmRewardType emRewardType) {
		emRewardTypeService.addEmRewardType(emRewardType);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/emRewardTypes/{id}")
	public void updateEmRewardType(@RequestBody EmRewardType emRewardType, @PathVariable String id) {
		emRewardTypeService.updateEmRewardType(emRewardType);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/emRewardTypes/{id}")
	public void deleteEmRewardType(@PathVariable String id) {
		emRewardTypeService.deleteEmRewardType(id);
	}

}

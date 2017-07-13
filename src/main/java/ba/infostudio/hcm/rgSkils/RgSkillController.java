package ba.infostudio.hcm.rgSkils;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

@CrossOrigin(origins = "*")
@RestController
public class RgSkillController {
	
	@Autowired
	private RgSkillService rgSkillService;

	@RequestMapping("/rgSkills")
	public List<RgSkill> getAllRgSkills(@RequestParam(defaultValue="id") String sortBy, 
			@RequestParam(defaultValue="ASC") String sort, @RequestParam(defaultValue="") String queryBy, 
			@RequestParam(defaultValue="") String query) {
		return rgSkillService.getAllRgSkills(sortBy, sort, queryBy, query);
	}
	
	@RequestMapping("/rgSkills/{id}")
	public RgSkill getRgSkill(@PathVariable String id) {
		return rgSkillService.getRgSkill(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/rgSkills")
	public RgSkill addRgSkill(@RequestBody RgSkill rgSkill) {
		return rgSkillService.addRgSkill(rgSkill);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/rgSkills/{id}")
	public void updateRgSkill(@RequestBody RgSkill rgSkill, @PathVariable String id) {
		rgSkillService.updateRgSkill(rgSkill);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/rgSkills/{id}")
	public void deleteRgSkill(@PathVariable String id) {
		rgSkillService.deleteRgSkill(id);
	}
}
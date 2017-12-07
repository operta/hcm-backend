package ba.infostudio.hcm.rgSkils;

import java.util.List;

import ba.infostudio.hcm.dmDocumentTypes.DmDocumentTypeModel;
import ba.infostudio.hcm.dmDocumentTypes.DmDocumentTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
public class RgSkillController {

	@Autowired
	private RgSkillRepository rgSkillRepository;

	@RequestMapping("/skills")
	public Iterable<RgSkill> getAllSkills() {
		return this.rgSkillRepository.findAll();
	}

	@PostMapping(value = "/skills/add")
	public RgSkill addSkill(@RequestBody RgSkill skill) {
		return this.rgSkillRepository.save(skill);
	}

	@PutMapping("/skills")
	public RgSkill updateSkill(@RequestBody RgSkill body) {
		RgSkill skill = rgSkillRepository.findOne(body.getId());
		skill.setCode(body.getCode());
		skill.setName(body.getName());
		skill.setDescription(body.getDescription());
		skill.setField(body.getField());
		return this.rgSkillRepository.save(skill);
	}

	@DeleteMapping("/skills/remove/{id}")
	public boolean deleteSkill(@PathVariable String id) {
		this.rgSkillRepository.delete(Long.valueOf(id));
		return true;
	}
	
//	@Autowired
//	private RgSkillService rgSkillService;
//
//	@RequestMapping("/rgSkills")
//	public List<RgSkill> getAllRgSkills(@RequestParam(defaultValue="id") String sortBy,
//			@RequestParam(defaultValue="ASC") String sort, @RequestParam(defaultValue="") String queryBy,
//			@RequestParam(defaultValue="") String query) {
//		return rgSkillService.getAllRgSkills(sortBy, sort, queryBy, query);
//	}
//
//	@RequestMapping("/rgSkills/{id}")
//	public RgSkill getRgSkill(@PathVariable String id) {
//		return rgSkillService.getRgSkill(id);
//	}
//
//	@RequestMapping(method=RequestMethod.POST, value="/rgSkills")
//	public RgSkill addRgSkill(@RequestBody RgSkill rgSkill) {
//		return rgSkillService.addRgSkill(rgSkill);
//	}
//
//	@RequestMapping(method=RequestMethod.PUT, value="/rgSkills/{id}")
//	public void updateRgSkill(@RequestBody RgSkill rgSkill, @PathVariable String id) {
//		rgSkillService.updateRgSkill(rgSkill);
//	}
//
//	@RequestMapping(method=RequestMethod.DELETE, value="/rgSkills/{id}")
//	public void deleteRgSkill(@PathVariable String id) {
//		rgSkillService.deleteRgSkill(id);
//	}
}
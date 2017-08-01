package ba.infostudio.hcm.rgSkillGrades;


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
public class RgSkillGradeController {
	
	@Autowired
	private RgSkillGradeService rgSkillGradeService;

	@RequestMapping("/rgSkills/{idSkill}/rgSkillGrades")
	public List<RgSkillGrade> getAllRgSkillGrades(@PathVariable String idSkill, @RequestParam(defaultValue="id") String sortBy, 
			@RequestParam(defaultValue="ASC") String sort) {
		return rgSkillGradeService.getAllRgSkillGrades(idSkill, sortBy, sort);
	}
	
	@RequestMapping("/rgSkills/{idSkill}/rgSkillGrades/{id}")
	public RgSkillGrade getRgSkillGrade(@PathVariable String id) {
		return rgSkillGradeService.getRgSkillGrade(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/rgSkills/{idSkill}/rgSkillGrades")
	public RgSkillGrade addRgSkillGrade(@RequestBody RgSkillGrade rgSkillGrade, @PathVariable Long idSkill) {
		return rgSkillGradeService.addRgSkillGrade(rgSkillGrade);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/rgSkills/{idSkill}/rgSkillGrades/{id}")
	public void updateRgSkillGrade(@RequestBody RgSkillGrade rgSkillGrade, @PathVariable Long idSkill, @PathVariable Long id) {
		rgSkillGradeService.updateRgSkillGrade(rgSkillGrade);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/rgSkills/{idSkill}/rgSkillGrades/{id}")
	public void deleteRgSkillGrade(@PathVariable String id) {
		rgSkillGradeService.deleteRgSkillGrade(id);
	}
}

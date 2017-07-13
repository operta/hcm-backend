package ba.infostudio.hcm.rgSkillGrades;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ba.infostudio.hcm.rgSkils.RgSkill;

@CrossOrigin(origins = "*")
@RestController
public class RgSkillGradeController {
	
	@Autowired
	private RgSkillGradeService rgSkillGradeService;

	@RequestMapping("/rgSkills/{idSkill}/rgSkillGrades")
	public List<RgSkillGrade> getAllRgSkillGrades(@PathVariable Long idSkill) {
		return rgSkillGradeService.getAllRgSkillGrades(idSkill);
	}
	
	@RequestMapping("/rgSkills/{idSkill}/rgSkillGrades/{id}")
	public RgSkillGrade getRgSkillGrade(@PathVariable Long id) {
		return rgSkillGradeService.getRgSkillGrade(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/rgSkills/{idSkill}/rgSkillGrades")
	public void addRgSkillGrade(@RequestBody RgSkillGrade rgSkillGrade, @PathVariable Long idSkill) {
		rgSkillGrade.setRgSkill(new RgSkill(idSkill, "", "", "", ""));
		rgSkillGradeService.addRgSkillGrade(rgSkillGrade);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/rgSkills/{idSkill}/rgSkillGrades/{id}")
	public void updateRgSkillGrade(@RequestBody RgSkillGrade rgSkillGrade, @PathVariable Long idSkill, @PathVariable Long id) {
		rgSkillGrade.setRgSkill(new RgSkill(idSkill, "", "", "", ""));
		rgSkillGradeService.updateRgSkillGrade(rgSkillGrade);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/rgSkills/{idSkill}/rgSkillGrades/{id}")
	public void deleteRgSkillGrade(@PathVariable Long id) {
		rgSkillGradeService.deleteRgSkillGrade(id);
	}
}

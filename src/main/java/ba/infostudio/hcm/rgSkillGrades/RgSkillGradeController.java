package ba.infostudio.hcm.rgSkillGrades;


import java.util.List;

import ba.infostudio.hcm.rgSkils.RgSkill;
import ba.infostudio.hcm.rgSkils.RgSkillRepository;
import oracle.security.o3logon.b;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "*")
@RestController
public class RgSkillGradeController {

	@Autowired
	private RgSkillGradeRepository rgSkillGradeRepository;

	@RequestMapping("/skillGrades")
	public Iterable<RgSkillGrade> getAllSkillGrades() {
		return this.rgSkillGradeRepository.findAll();
	}

	@PostMapping(value = "/skillGrades/add")
	public RgSkillGrade addSkillGrade(@RequestBody RgSkillGrade skillGrade) {
		return this.rgSkillGradeRepository.save(skillGrade);
	}

	@PutMapping("/skillGrades")
	public RgSkillGrade updateSkillGrade(@RequestBody RgSkillGrade body) {
		RgSkillGrade skillGrade = rgSkillGradeRepository.findOne(body.getId());
		skillGrade.setCode(body.getCode());
		skillGrade.setName(body.getName());
		skillGrade.setDescription(body.getDescription());
		skillGrade.setNumerical(body.getNumerical());
		skillGrade.setGrade(body.getGrade());
		skillGrade.setIdSkill(body.getIdSkill());
		return this.rgSkillGradeRepository.save(skillGrade);
	}

	@DeleteMapping("/skillGrades/remove/{id}")
	public boolean deleteSkill(@PathVariable String id) {
		this.rgSkillGradeRepository.delete(Long.valueOf(id));
		return true;
	}



//	@Autowired
//	private RgSkillGradeService rgSkillGradeService;
//
//	@RequestMapping("/rgSkills/{idSkill}/rgSkillGrades")
//	public List<RgSkillGrade> getAllRgSkillGrades(@PathVariable String idSkill, @RequestParam(defaultValue="id") String sortBy,
//			@RequestParam(defaultValue="ASC") String sort) {
//		return rgSkillGradeService.getAllRgSkillGrades(idSkill, sortBy, sort);
//	}
//
//	@RequestMapping("/rgSkills/{idSkill}/rgSkillGrades/{id}")
//	public RgSkillGrade getRgSkillGrade(@PathVariable String id) {
//		return rgSkillGradeService.getRgSkillGrade(id);
//	}
//
//	@RequestMapping(method=RequestMethod.POST, value="/rgSkills/{idSkill}/rgSkillGrades")
//	public RgSkillGrade addRgSkillGrade(@RequestBody RgSkillGrade rgSkillGrade, @PathVariable Long idSkill) {
//		return rgSkillGradeService.addRgSkillGrade(rgSkillGrade);
//	}
//
//	@RequestMapping(method=RequestMethod.PUT, value="/rgSkills/{idSkill}/rgSkillGrades/{id}")
//	public void updateRgSkillGrade(@RequestBody RgSkillGrade rgSkillGrade, @PathVariable Long idSkill, @PathVariable Long id) {
//		rgSkillGradeService.updateRgSkillGrade(rgSkillGrade);
//	}
//
//	@RequestMapping(method=RequestMethod.DELETE, value="/rgSkills/{idSkill}/rgSkillGrades/{id}")
//	public void deleteRgSkillGrade(@PathVariable String id) {
//		rgSkillGradeService.deleteRgSkillGrade(id);
//	}
}

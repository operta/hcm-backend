package ba.infostudio.hcm.rgSkillGrades;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RgSkillGradeService {
	
	@Autowired
	private RgSkillGradeRepository rgSkillGradeRepository;

	public List<RgSkillGrade> getAllRgSkillGrades(Long idSkill) {
		List<RgSkillGrade> rgSkillGrades = new ArrayList<>();
		rgSkillGradeRepository.findByRgSkillId(idSkill).forEach(rgSkillGrades::add);
		return rgSkillGrades;
	}
	
	public RgSkillGrade getRgSkillGrade(Long id) {
		return rgSkillGradeRepository.findOne(id);
	}

	public void addRgSkillGrade(RgSkillGrade rgSkillGrade) {
		rgSkillGradeRepository.save(rgSkillGrade);
	}

	public void updateRgSkillGrade(RgSkillGrade rgSkillGrade) {
		rgSkillGradeRepository.save(rgSkillGrade);
	}

	public void deleteRgSkillGrade(Long id) {
		rgSkillGradeRepository.delete(id);
	}
}

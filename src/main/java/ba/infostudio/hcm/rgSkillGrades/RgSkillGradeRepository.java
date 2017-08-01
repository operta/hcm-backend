package ba.infostudio.hcm.rgSkillGrades;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;


public interface RgSkillGradeRepository extends CrudRepository<RgSkillGrade, Long> {

	public List<RgSkillGrade> findByIdSkill(Long idSkill, Sort sort);
}
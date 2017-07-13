package ba.infostudio.hcm.rgSkils;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.repository.CrudRepository;

public interface RgSkillRepository extends CrudRepository<RgSkill, Long>  {
	
	public List<RgSkill> findAll(Specification<RgSkill> specification, Sort sort);
	
}

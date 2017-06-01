package ba.infostudio.hcm.rgSkils;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RgSkillService {
	
	@Autowired
	private RgSkillRepository rgSkillRepository;

	public List<RgSkill> getAllRgSkills() {
		List<RgSkill> rgSkill = new ArrayList<>();
		rgSkillRepository.findAll().forEach(rgSkill::add);
		return rgSkill;
	}
	
	public RgSkill getRgSkill(String id) {
		return rgSkillRepository.findOne(Long.valueOf(id));
	}

	public void addRgSkill(RgSkill topic) {
		rgSkillRepository.save(topic);
	}

	public void updateRgSkill(RgSkill topic) {
		rgSkillRepository.save(topic);
	}

	public void deleteRgSkill(String id) {
		rgSkillRepository.delete(Long.valueOf(id));
	}
}

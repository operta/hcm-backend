package ba.infostudio.hcm.emRewardTypes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;





@Service
public class EmRewardTypeService {
	
	@Autowired
	private EmRewardTypeRepository emRewardTypeRepository;
	
	public List<EmRewardType> getAllEmRewardTypes() {
		List<EmRewardType> emRewardType = new ArrayList<>();
		emRewardTypeRepository.findAll().forEach(emRewardType::add);
		return emRewardType;
      }

	
	public EmRewardType getEmRewardType(String id) {
		return emRewardTypeRepository.findOne(Long.valueOf(id));
	}
	
	public void addEmRewardType(EmRewardType topic) {
		emRewardTypeRepository.save(topic);
	}

	public void updateEmRewardType(EmRewardType topic) {
		emRewardTypeRepository.save(topic);
	}

	public void deleteEmRewardType(String id) {
		emRewardTypeRepository.delete(Long.valueOf(id));
	}
	
}

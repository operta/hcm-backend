package ba.infostudio.hcm.ogOrganizationalPartTypes;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OgOrganizationalPartTypeService {
	
	@Autowired
	private OgOrganizationalPartTypeRepository ogOrganizationalPartTypeRepository;

	public List<OgOrganizationalPartType> getAllOgOrganizationalPartTypes() {
		List<OgOrganizationalPartType> ogOrganizationalPartType = new ArrayList<>();
		ogOrganizationalPartTypeRepository.findAll().forEach(ogOrganizationalPartType::add);
		return ogOrganizationalPartType;
	}
	
	public OgOrganizationalPartType getOgOrganizationalPartType(String id) {
		return ogOrganizationalPartTypeRepository.findOne(Long.valueOf(id));
	}

	public void addOgOrganizationalPartType(OgOrganizationalPartType topic) {
		ogOrganizationalPartTypeRepository.save(topic);
	}

	public void updateOgOrganizationalPartType(OgOrganizationalPartType topic) {
		ogOrganizationalPartTypeRepository.save(topic);
	}

	public void deleteOgOrganizationalPartType(String id) {
		ogOrganizationalPartTypeRepository.delete(Long.valueOf(id));
	}
}

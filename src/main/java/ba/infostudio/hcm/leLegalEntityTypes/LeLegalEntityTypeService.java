package ba.infostudio.hcm.leLegalEntityTypes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ba.infostudio.hcm.leLegalEntityTypes.LeLegalEntityType;


@Service
public class LeLegalEntityTypeService {

 @Autowired
 private LeLegalEntityTypeRepository leLegalEntityTypeRepository;
 
 	public List<LeLegalEntityType> getAllLegalEntityTypes(){
		List<LeLegalEntityType> leLegalEntityTypes = new ArrayList<>();
		leLegalEntityTypeRepository.findAll().forEach(leLegalEntityTypes::add);
		return leLegalEntityTypes;
	 
 }
 
	public LeLegalEntityType getLeLegalEntityType(Long id){
		return leLegalEntityTypeRepository.findOne(id);
	}
	
	public void addLeLegalEntityType(LeLegalEntityType leLegalEntityType) {
		leLegalEntityTypeRepository.save(leLegalEntityType);
	}	
	
	public void updateLeLegalEntityType(LeLegalEntityType leLegalEntityType) {
		leLegalEntityTypeRepository.save(leLegalEntityType);
	}	
	
	public void deleteLeLegalEntityType(LeLegalEntityType leLegalEntityType) {
		leLegalEntityTypeRepository.delete(leLegalEntityType);
	}	
	
	
	
}

package ba.infostudio.hcm.rgSkillGrades;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import ba.infostudio.hcm.rgSkils.RgSkill;

@Service
public class RgSkillGradeService {
	
	@Autowired
	private RgSkillGradeRepository rgSkillGradeRepository;

	public List<RgSkillGrade> getAllRgSkillGrades(String idSkill, String sortBy, String sort) {
        Field[] fields = RgSkill.class.getDeclaredFields();
		
		sortBy = (sortBy == null)?"id":sortBy;
		sort = (sort == null)?"ASC":sort;
		String sortCamel = toCamelCase(sortBy);
		boolean sortByValid = false;
		for (int i = 0; i < fields.length; i++) {
			if (sortCamel.trim().equals(fields[i].getName())) {
				sortByValid = true;
				break;
			}
		}
		if (!sortByValid) {
			sortBy = "id";
			sort = "ASC";
		}
		Sort resultSort = new Sort(((sort.toUpperCase().trim().equals("DESC"))?Sort.Direction.DESC:Sort.Direction.ASC), sortBy.toLowerCase());
		
		List<RgSkillGrade> rgSkillGrades = new ArrayList<>();
		rgSkillGradeRepository.findByIdSkill(Long.valueOf(idSkill), resultSort).forEach(rgSkillGrades::add);
		return rgSkillGrades;
	}
	
	public RgSkillGrade getRgSkillGrade(String id) {
		return rgSkillGradeRepository.findOne(Long.valueOf(id));
	}

	public RgSkillGrade addRgSkillGrade(RgSkillGrade rgSkillGrade) {
		return rgSkillGradeRepository.save(rgSkillGrade);
	}

	public void updateRgSkillGrade(RgSkillGrade rgSkillGrade) {
		rgSkillGradeRepository.save(rgSkillGrade);
	}

	public void deleteRgSkillGrade(String id) {
		rgSkillGradeRepository.delete(Long.valueOf(id));
	}
	
	private String toCamelCase(String input) {
	    StringBuilder upperCamelCase = new StringBuilder();
	    boolean nextUpperCase = false;

	    for (char c : input.toCharArray()) {
	        if (c == '_') {
	        	nextUpperCase = true;
	        }
	        else {
	        	if (nextUpperCase) {
		            c = Character.toUpperCase(c);
		            nextUpperCase = false;
		        }
	        	else {
	        		c = Character.toLowerCase(c);
	        	}
	        	upperCamelCase.append(c);
	        }
	    }
	    return upperCamelCase.toString();
	}
}

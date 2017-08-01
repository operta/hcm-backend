package ba.infostudio.hcm.rgSkils;


import java.util.ArrayList;
import java.util.List;

import java.lang.reflect.Field;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import ba.infostudio.QuerySpecification;


@Service
public class RgSkillService {
	
	@Autowired
	private RgSkillRepository rgSkillRepository;

	public List<RgSkill> getAllRgSkills(String sortBy, String sort, String queryColumn, String queryValue) {
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
		
		boolean queryValid = false;
		if (queryColumn != null && queryValue != null) {
			queryColumn = queryColumn.trim();
			queryValue = queryValue.trim();
			String queryColumnCamel = toCamelCase(queryColumn);
			for (int i = 0; i < fields.length; i++) {
				if (queryColumnCamel.equals(fields[i].getName())) {
					queryValid = true;
					break;
				}
			}
			while (queryValue.startsWith("%")) {
				queryValue = queryValue.substring(1);
			}
			while (queryValue.endsWith("%")) {
				queryValue = queryValue.substring(0, queryValue.length()-1);
			}
			queryValue = queryValue.trim().toUpperCase();
			if (queryValue.length() == 0) {
				queryValid = false;
			}
		}
		
		QuerySpecification<RgSkill> querySpecification = null;
		
		if (queryValid) {
			querySpecification = new QuerySpecification<RgSkill>(queryColumn, "%"+queryValue+"%");
		}
		
		List<RgSkill> rgSkill = new ArrayList<>();
		rgSkillRepository.findAll(querySpecification, resultSort).forEach(rgSkill::add);
		return rgSkill;
	}
	
	public RgSkill getRgSkill(String id) {
		return rgSkillRepository.findOne(Long.valueOf(id));
	}

	public RgSkill addRgSkill(RgSkill rgSkill) {
		return rgSkillRepository.save(rgSkill);
	}

	public void updateRgSkill(RgSkill rgSkill) {
		rgSkillRepository.save(rgSkill);
	}

	public void deleteRgSkill(String id) {
		rgSkillRepository.delete(Long.valueOf(id));
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

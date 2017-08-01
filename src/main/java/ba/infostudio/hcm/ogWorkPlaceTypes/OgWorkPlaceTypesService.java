package ba.infostudio.hcm.ogWorkPlaceTypes;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import ba.infostudio.QuerySpecification;

@Service

public class OgWorkPlaceTypesService {
	
	@Autowired
	private OgWorkPlaceTypesRepository ogWorkPlaceTypesRepository;
	
	
	public List<OgWorkPlaceTypes> getAllOgWorkPlaceTypes(String sortBy, String sort, String queryColumn, String queryValue) {
		Field[] fields = OgWorkPlaceTypes.class.getDeclaredFields();
		
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
		
		QuerySpecification<OgWorkPlaceTypes> querySpecification = null;
		
		if (queryValid) {
			querySpecification = new QuerySpecification<OgWorkPlaceTypes>(queryColumn, "%"+queryValue+"%");
		}
		
		List<OgWorkPlaceTypes> ogWorkPlaceTypes = new ArrayList<>();
		ogWorkPlaceTypesRepository.findAll(querySpecification, resultSort).forEach(ogWorkPlaceTypes::add);
		return ogWorkPlaceTypes;
	}
	
	public OgWorkPlaceTypes getOgWorkPlaceTypes(String id) {
		return ogWorkPlaceTypesRepository.findOne(Long.valueOf(id));
	}

	public OgWorkPlaceTypes addOgWorkPlaceTypes(OgWorkPlaceTypes ogWorkPlaceTypes) {
		return ogWorkPlaceTypesRepository.save(ogWorkPlaceTypes);
	}

	public void updateOgWorkPlaceTypes(OgWorkPlaceTypes topic) {
		ogWorkPlaceTypesRepository.save(topic);
	}

	public void deleteOgWorkPlaceTypes(String id) {
		ogWorkPlaceTypesRepository.delete(Long.valueOf(id));
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

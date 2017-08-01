package ba.infostudio.hcm.ogWorkPlaceTypes;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.repository.CrudRepository;



public interface OgWorkPlaceTypesRepository extends CrudRepository<OgWorkPlaceTypes, Long>{
	
	public List<OgWorkPlaceTypes> findAll(Specification<OgWorkPlaceTypes> specification, Sort sort);

}

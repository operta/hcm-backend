package ba.infostudio.hcm.atJobApplicationHistory;

import ba.infostudio.hcm.atJobApplications.AtJobApplicationModel;
import org.springframework.data.repository.CrudRepository;

public interface AtJobApplicationHistoryRepository extends CrudRepository<AtJobApplicationHistoryModel, Long> {
    Iterable<AtJobApplicationHistoryModel> findByIdJobApplication_id(Long id);

}

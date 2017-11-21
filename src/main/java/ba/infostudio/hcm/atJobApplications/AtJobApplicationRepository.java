package ba.infostudio.hcm.atJobApplications;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface AtJobApplicationRepository extends JpaRepository<AtJobApplicationModel, Long> {
}

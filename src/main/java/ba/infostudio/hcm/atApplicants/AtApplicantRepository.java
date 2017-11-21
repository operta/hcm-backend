package ba.infostudio.hcm.atApplicants;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface AtApplicantRepository extends JpaRepository<AtApplicantModel, Long> {
}

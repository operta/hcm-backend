package ba.infostudio.hcm.atApplicants;

import ba.infostudio.hcm.apUsers.ApUserModel;
import org.springframework.data.repository.CrudRepository;

public interface AtApplicantRepository extends CrudRepository<AtApplicantModel, Long> {
    AtApplicantModel findByIdUser_id(Long id);
}

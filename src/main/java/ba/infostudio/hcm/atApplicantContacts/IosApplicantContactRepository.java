package ba.infostudio.hcm.atApplicantContacts;

import org.springframework.data.repository.CrudRepository;

public interface IosApplicantContactRepository extends CrudRepository<IosApplicantContactModel, Long>{
    Iterable<IosApplicantContactModel> findByIdApplicant_Id(Long id);
}

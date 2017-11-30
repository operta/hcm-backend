package ba.infostudio.hcm.atApplicantAccomplishments;

import org.springframework.data.repository.CrudRepository;

public interface AtApplicantAccomplishmentRepository extends CrudRepository<AtApplicantAccomplishmentModel, Long>{
    Iterable<AtApplicantAccomplishmentModel> findByIdApplicant_id(Long id);
}
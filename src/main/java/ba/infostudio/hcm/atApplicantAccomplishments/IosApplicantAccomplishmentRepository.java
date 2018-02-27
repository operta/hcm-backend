package ba.infostudio.hcm.atApplicantAccomplishments;

import org.springframework.data.repository.CrudRepository;

public interface IosApplicantAccomplishmentRepository extends CrudRepository<IosApplicantAccomplishmentModel, Long>{

    Iterable<IosApplicantAccomplishmentModel> findByIdApplicant_Id(Long id);
}

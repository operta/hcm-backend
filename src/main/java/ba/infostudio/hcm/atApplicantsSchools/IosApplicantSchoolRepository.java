package ba.infostudio.hcm.atApplicantsSchools;

import org.springframework.data.repository.CrudRepository;

public interface IosApplicantSchoolRepository extends CrudRepository<IosApplicantSchoolModel, Long> {
    Iterable<IosApplicantSchoolModel> findByIdApplicant_Id(Long id);
    Iterable<IosApplicantSchoolModel> findByIdApplicant_idOrderByDateFromDesc(Long id);

}

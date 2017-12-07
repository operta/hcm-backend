package ba.infostudio.hcm.atApplicantsSchools;

import org.springframework.data.repository.CrudRepository;

public interface AtApplicantSchoolRepository extends CrudRepository<AtApplicantSchoolModel, Long> {
    Iterable<AtApplicantSchoolModel> findByIdApplicant_id(Long id);
    Iterable<AtApplicantSchoolModel> findByIdApplicant_idOrderByDateFromDesc(Long id);
}



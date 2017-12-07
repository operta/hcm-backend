package ba.infostudio.hcm.atApplicantExperiences;

import org.springframework.data.repository.CrudRepository;

public interface AtApplicantExperienceRepository extends CrudRepository<AtApplicantExperienceModel, Long> {
    Iterable<AtApplicantExperienceModel> findByIdApplicant_id(Long id);
}

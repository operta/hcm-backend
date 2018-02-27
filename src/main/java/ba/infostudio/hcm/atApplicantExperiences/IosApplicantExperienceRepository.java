package ba.infostudio.hcm.atApplicantExperiences;

import org.springframework.data.repository.CrudRepository;

public interface IosApplicantExperienceRepository extends CrudRepository<IosApplicantExperienceModel, Long> {
    Iterable<IosApplicantExperienceModel> findByIdApplicant_id(Long id);
}

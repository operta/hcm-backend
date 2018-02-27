package ba.infostudio.hcm.atApplicantExperiences;

import ba.infostudio.hcm.atApplicantExperiences.AtApplicantExperienceModel;
import ba.infostudio.hcm.atApplicantExperiences.AtApplicantExperienceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AtApplicantExperienceController {
    @Autowired
    private AtApplicantExperienceRepository atApplicantExperienceRepository;

    @Autowired
    private IosApplicantExperienceRepository iosApplicantExperienceRepository;

    @RequestMapping("/applicantExperiences")
    public Iterable<AtApplicantExperienceModel> getAllApplicantExperiences() {
        return this.atApplicantExperienceRepository.findAll();
    }

    @GetMapping("/applicantExperiences/{id}")
    @ResponseBody
    public Iterable<AtApplicantExperienceModel> getApplicantExperience(@PathVariable String id) {
        return this.atApplicantExperienceRepository.findByIdApplicant_id(Long.valueOf(id));
    }

    @GetMapping("/applicantExperiences/njsog/{id}")
    @ResponseBody
    public Iterable<IosApplicantExperienceModel> getApplicantExperienceWithoutJsog(@PathVariable String id) {
        return this.iosApplicantExperienceRepository.findByIdApplicant_id(Long.valueOf(id));
    }

    @PostMapping(value = "/applicantExperiences/add")
    public AtApplicantExperienceModel addApplicantExperience(@RequestBody AtApplicantExperienceModel atApplicantExperienceModel) {
        return this.atApplicantExperienceRepository.save(atApplicantExperienceModel);
    }

    @PutMapping("/applicantExperiences")
    public AtApplicantExperienceModel updateApplicantExperience(@RequestBody AtApplicantExperienceModel body) {
        AtApplicantExperienceModel experience = atApplicantExperienceRepository.findOne(body.getId());
        experience.setCompany(body.getCompany());
        experience.setLocation(body.getLocation());
        experience.setPosition(body.getPosition());
        experience.setDate_from(body.getDate_from());
        experience.setDate_to(body.getDate_to());
        experience.setOngoing(body.getOngoing());
        return this.atApplicantExperienceRepository.save(experience);
    }

    @DeleteMapping("/applicantExperiences/remove/{id}")
    public boolean deleteApplicantExperience(@PathVariable String id) {
        this.atApplicantExperienceRepository.delete(Long.valueOf(id));
        return true;
    }
}


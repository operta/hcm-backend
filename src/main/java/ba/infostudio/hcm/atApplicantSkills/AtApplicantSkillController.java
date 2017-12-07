package ba.infostudio.hcm.atApplicantSkills;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AtApplicantSkillController {
    @Autowired
    private AtApplicantSkillRepository atApplicantSkillRepository;

    @RequestMapping("/applicantSkills")
    public Iterable<AtApplicantSkillModel> getAllApplicantSkills() {
        return this.atApplicantSkillRepository.findAll();
    }

    @PostMapping(value = "/applicantSkills/add")
    public AtApplicantSkillModel addApplicantSkill(@RequestBody AtApplicantSkillModel body) {
        return this.atApplicantSkillRepository.save(body);
    }

    @PutMapping("/applicantSkills")
    public AtApplicantSkillModel updateApplicantSkill(@RequestBody AtApplicantSkillModel body) {
        AtApplicantSkillModel item = atApplicantSkillRepository.findOne(body.getId());
        item.setIdApplicant(body.getIdApplicant());
        item.setId_skill(body.getId_skill());
        item.setSkill(body.getSkill());
        item.setDate_skill(body.getDate_skill());
        item.setId_grade(body.getId_grade());
        return this.atApplicantSkillRepository.save(item);
    }

    @DeleteMapping("/applicantSkills/remove/{id}")
    public boolean deleteApplicantSkill(@PathVariable String id) {
        this.atApplicantSkillRepository.delete(Long.valueOf(id));
        return true;
    }
}
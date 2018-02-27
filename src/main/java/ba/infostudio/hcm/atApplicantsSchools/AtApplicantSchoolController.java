package ba.infostudio.hcm.atApplicantsSchools;

import ba.infostudio.hcm.atApplicants.AtApplicantModel;
import ba.infostudio.hcm.atVacancies.AtVacancyModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AtApplicantSchoolController {
    @Autowired
    private AtApplicantSchoolRepository atApplicantSchoolRepository;

    @Autowired
    private IosApplicantSchoolRepository iosApplicantSchoolRepository;

    @RequestMapping("/applicantSchools")
    public Iterable<AtApplicantSchoolModel> getAllApplicantSchools() {
        return this.atApplicantSchoolRepository.findAll();
    }

    @GetMapping("/applicantSchools/{id}")
    @ResponseBody
    public Iterable<AtApplicantSchoolModel> getApplicantSchools(@PathVariable String id) {
        return this.atApplicantSchoolRepository.findByIdApplicant_idOrderByDateFromDesc(Long.valueOf(id));
    }

    @GetMapping("/applicantSchools/nojsog/{id}")
    @ResponseBody
    public Iterable<IosApplicantSchoolModel> getApplicantSchoolsWithoutJsog(@PathVariable String id) {
        return this.iosApplicantSchoolRepository.findByIdApplicant_idOrderByDateFromDesc(Long.valueOf(id));
    }

    @PostMapping(value = "/applicantSchools/add")
    public AtApplicantSchoolModel addApplicantSchool(@RequestBody AtApplicantSchoolModel atApplicantSchoolModel) {
        return this.atApplicantSchoolRepository.save(atApplicantSchoolModel);
    }

    @PutMapping("/applicantSchools")
    public AtApplicantSchoolModel updateApplicantSchool(@RequestBody AtApplicantSchoolModel body) {
        AtApplicantSchoolModel school = atApplicantSchoolRepository.findOne(body.getId());
        school.setDegree(body.getDegree());
        school.setId_qualification(body.getId_qualification());
        school.setSchool(body.getSchool());
        school.setId_school(body.getId_school());
        school.setDateFrom(body.getDateFrom());
        school.setDate_to(body.getDate_to());
        school.setMajor(body.getMajor());
        school.setGrade(body.getGrade());
        school.setDescription(body.getDescription());
        school.setLink(body.getLink());
        return this.atApplicantSchoolRepository.save(school);
    }

    @DeleteMapping("/applicantSchools/remove/{id}")
    public boolean deleteApplicantSchool(@PathVariable String id) {
        this.atApplicantSchoolRepository.delete(Long.valueOf(id));
        return true;
    }
}

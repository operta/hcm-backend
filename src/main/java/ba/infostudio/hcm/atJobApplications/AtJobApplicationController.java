package ba.infostudio.hcm.atJobApplications;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("jobApplications")
public class AtJobApplicationController {
    @Autowired
    private AtJobApplicationRepository atJobApplicationRepository;

    @GetMapping("")
    private @ResponseBody Iterable<AtJobApplicationModel> getJobApplications(){
        return this.atJobApplicationRepository.findAll();
    }

    @GetMapping("/byApplicant/{id}")
    private @ResponseBody Iterable<AtJobApplicationModel> getJobApplicationsByApplicant(@PathVariable Long id) {
        return this.atJobApplicationRepository.findByApplicantid_id(id);
    }

    @PostMapping(value = "/add")
    public AtJobApplicationModel addJobApplication(@RequestBody AtJobApplicationModel jobApplication) {
        return this.atJobApplicationRepository.save(jobApplication);
    }

    @PutMapping("")
    public AtJobApplicationModel updateApplicantSchool(@RequestBody AtJobApplicationModel body) {
        AtJobApplicationModel item = atJobApplicationRepository.findOne(body.getId());
        item.setApplicantid(body.getApplicantid());
        item.setVacancyid(body.getVacancyid());
        item.setId_status(body.getId_status());
        item.setGrade(body.getGrade());
        item.setReview(body.getReview());
        item.setDate_applied(body.getDate_applied());
        item.setInterview_grade(body.getInterview_grade());
        item.setTest_grade(body.getTest_grade());
        item.setTest(body.getTest());
        item.setInterview(body.getInterview());
        return this.atJobApplicationRepository.save(item);
    }

}

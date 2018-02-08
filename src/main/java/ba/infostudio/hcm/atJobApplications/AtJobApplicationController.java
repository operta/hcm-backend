package ba.infostudio.hcm.atJobApplications;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("jobApplications")
public class AtJobApplicationController {
    @Autowired
    private AtJobApplicationRepository atJobApplicationRepository;
    @Autowired
    private AtJobApplicationMRepository atJobApplicationMRepository;

    @GetMapping("")
    private @ResponseBody Iterable<AtJobApplicationModel> getJobApplications(){
        return this.atJobApplicationRepository.findAll();
    }

    //get all jobAppications mobile
    @GetMapping("/M")
    private @ResponseBody Iterable<AtJobApplicationMModel> getJobApplicationsM(){
        return this.atJobApplicationMRepository.findAll();
    }

    @GetMapping("/{id}")
    public @ResponseBody AtJobApplicationModel getJobApplication(@PathVariable String id) {
        return this.atJobApplicationRepository.findOne(Long.valueOf(id));
    }

    //get job application by id mobile
    @GetMapping("/M/{id}")
    public @ResponseBody AtJobApplicationMModel getJobApplicationM(@PathVariable String id) {
        return this.atJobApplicationMRepository.findOne(Long.valueOf(id));
    }

    @GetMapping("/byVacancy/{id}")
    private @ResponseBody Iterable<AtJobApplicationModel> getJobApplicationsByVacancy(@PathVariable Long id) {
        return this.atJobApplicationRepository.findByVacancyid_Id(id);
    }

    //get jobapplications by vacancy id mobile
    @GetMapping("/byVacancy/M/{id}")
    private @ResponseBody Iterable<AtJobApplicationMModel> getJobApplicationsByVacancyM(@PathVariable Long id) {
        return this.atJobApplicationMRepository.findByVacancyid_Id(id);
    }


    @GetMapping("/byApplicant/{id}")
    private @ResponseBody Iterable<AtJobApplicationModel> getJobApplicationsByApplicant(@PathVariable Long id) {
        return this.atJobApplicationRepository.findByApplicantid_id(id);
    }

    //get jobapplications by applicant id mobile
    @GetMapping("/byApplicant/M/{id}")
    private @ResponseBody Iterable<AtJobApplicationMModel> getJobApplicationsByApplicantM(@PathVariable Long id) {
        return this.atJobApplicationMRepository.findByApplicantid_id(id);
    }

    @PostMapping(value = "/add")
    public AtJobApplicationModel addJobApplication(@RequestBody AtJobApplicationModel jobApplication) {
        return this.atJobApplicationRepository.save(jobApplication);
    }

    //add new job application mobile
    @PostMapping(value = "/M/add")
    public AtJobApplicationMModel addJobApplication(@RequestBody AtJobApplicationMModel jobApplication) {
        return this.atJobApplicationMRepository.save(jobApplication);
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

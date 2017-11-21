package ba.infostudio.hcm.atApplicants;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/applicants")
@CrossOrigin("*")
public class AtApplicantController {
    @Autowired
    private AtApplicantService atApplicantService;

    @GetMapping("")
    public @ResponseBody Iterable<AtApplicantModel> getAllApplicants(){
        return this.atApplicantService.getAllApplicants();
    }


    @PostMapping(value = "/add")
    public AtApplicantModel addApplicant(@RequestBody AtApplicantModel atApplicantModel) {
        return this.atApplicantService.addApplicant(atApplicantModel);
    }

    @RequestMapping(value = "", method=RequestMethod.PUT, produces={"application/json"})
    public @ResponseBody boolean updateApplicant(@RequestBody AtApplicantModel applicant) {
        this.atApplicantService.updateApplicant(applicant);

        return true;
    }
}

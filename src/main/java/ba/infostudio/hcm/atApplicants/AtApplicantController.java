package ba.infostudio.hcm.atApplicants;

import ba.infostudio.hcm.apUsers.ApUserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/applicants")
@CrossOrigin("*")
public class AtApplicantController {
    @Autowired
    private AtApplicantService atApplicantService;
    @Autowired
    private AtApplicantRepository atApplicantRepository;
    @Autowired
    private AtApplicantMService atApplicantMService;

    @GetMapping("")
    public @ResponseBody Iterable<AtApplicantModel> getAllApplicants(){
        return this.atApplicantService.getAllApplicants();
    }
    //Get all applicants mobile
    @GetMapping("/M")
    public @ResponseBody Iterable<AtApplicantMModel> getAllMApplicants(){
        return this.atApplicantMService.getAllApplicants();
    }

    //by user
    @GetMapping("/{id}")
    public AtApplicantModel getApplicant(@PathVariable String id, HttpServletResponse response) {
        return this.atApplicantService.getApplicant(Long.valueOf(id));
    }

    //Get by userId mobile
    @GetMapping("/M/{id}")
    public AtApplicantMModel getMApplicant(@PathVariable String id, HttpServletResponse response) {
        return this.atApplicantMService.getApplicantByUser(Long.valueOf(id));
    }

    //get by ID
    @GetMapping("/applicant/{id}")
    public AtApplicantModel getApplicantByApplicantId(@PathVariable String id, HttpServletResponse response) {
        return this.atApplicantRepository.findOne(Long.valueOf(id));
    }

    //get by ID mobile
    @GetMapping("/applicant/M/{id}")
    public AtApplicantMModel getApplicantMByApplicantId(@PathVariable String id, HttpServletResponse response) {
        return this.atApplicantMService.getApplicantById(Long.valueOf(id));
    }

    //Add applicant mobile
    @PostMapping(value = "/M/add")
    public AtApplicantMModel addMApplicant(@RequestBody AtApplicantMModel atApplicantModel) {
        return this.atApplicantMService.addApplicant(atApplicantModel);
    }

    @PostMapping(value = "/add")
    public AtApplicantModel addApplicant(@RequestBody AtApplicantModel atApplicantModel) {
        return this.atApplicantService.addApplicant(atApplicantModel);
    }


    //Update applicant mobile
    @RequestMapping(value = "/M", method=RequestMethod.PUT, produces={"application/json"})
    public AtApplicantMModel updateApplicant(@RequestBody AtApplicantMModel applicant) {
        return this.atApplicantMService.updateApplicant(applicant);
    }

    @RequestMapping(value = "", method=RequestMethod.PUT, produces={"application/json"})
    public AtApplicantModel updateApplicant(@RequestBody AtApplicantModel applicant) {
        return this.atApplicantService.updateApplicant(applicant);
    }
}

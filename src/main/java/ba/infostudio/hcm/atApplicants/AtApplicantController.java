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

    @GetMapping("")
    public @ResponseBody Iterable<AtApplicantModel> getAllApplicants(){
        return this.atApplicantService.getAllApplicants();
    }

    @GetMapping("/{id}")
    public AtApplicantModel getApplicant(@PathVariable String id, HttpServletResponse response) {
        return this.atApplicantService.getApplicant(Long.valueOf(id));
    }

    @GetMapping("/applicant/{id}")
    public AtApplicantModel getApplicantByApplicantId(@PathVariable String id, HttpServletResponse response) {
        return this.atApplicantRepository.findOne(Long.valueOf(id));
    }

    @PostMapping(value = "/add")
    public AtApplicantModel addApplicant(@RequestBody AtApplicantModel atApplicantModel) {
        return this.atApplicantService.addApplicant(atApplicantModel);
    }

    @RequestMapping(value = "", method=RequestMethod.PUT, produces={"application/json"})
    public AtApplicantModel updateApplicant(@RequestBody AtApplicantModel applicant) {
        return this.atApplicantService.updateApplicant(applicant);
    }
}

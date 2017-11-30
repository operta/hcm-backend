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

    @GetMapping("")
    public @ResponseBody Iterable<AtApplicantModel> getAllApplicants(){
        return this.atApplicantService.getAllApplicants();
    }

    @GetMapping("/{id}")
    public AtApplicantModel getApplicant(@PathVariable String id, HttpServletResponse response) {
        System.out.print("ID___________");
        System.out.print(id);
        System.out.println("GET APPLICANT CONTROLLER__________");
        System.out.print(this.atApplicantService.getApplicant(id));
        AtApplicantModel applicant = this.atApplicantService.getApplicant(id);
        if(applicant == null){
            System.out.println("NO APPLICANT__________");
            response.setStatus(204);
        }
        return this.atApplicantService.getApplicant(id);
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

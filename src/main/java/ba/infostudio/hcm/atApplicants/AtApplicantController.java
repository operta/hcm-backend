package ba.infostudio.hcm.atApplicants;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/applicants")
public class AtApplicantController {
    @Autowired
    private AtApplicantRepository atApplicantRepository;

    @GetMapping("")
    public Iterable<AtApplicantModel> getApplicants() {
        return this.atApplicantRepository.findAll();
    }

}

package ba.infostudio.hcm.atJobApplications;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("jobApplications")
public class AtJobApplicationController {
    @Autowired
    private AtJobApplicationRepository atJobApplicationRepository;

    @GetMapping("")
    private Iterable<AtJobApplicationModel> getJobApplications(){
        return this.atJobApplicationRepository.findAll();
    }

}

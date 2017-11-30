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

}

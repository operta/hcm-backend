package ba.infostudio.hcm.atJobApplicationTest;

import ba.infostudio.hcm.atJobApplications.AtJobApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("test")
@CrossOrigin("*")
public class AtJobApplicationTestController {
    @Autowired
    private AtJobApplicationTestRepository atJobApplicationTestRepository;

    @GetMapping("")
    public Iterable<AtJobApplicationTestModel> getAll(){
        return this.atJobApplicationTestRepository.findAll();
    }
}

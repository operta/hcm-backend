package ba.infostudio.hcm.atJobApplicationTest;

import ba.infostudio.hcm.atJobApplications.AtJobApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("test")
@CrossOrigin("*")
public class AtJobApplicationTestController {
    @Autowired
    private AtJobApplicationTestService atJobApplicationTestService;

    @GetMapping("")
    public @ResponseBody Iterable<AtJobApplicationTestModel> getAll(){
        return this.atJobApplicationTestService.getAll();
    }

    @PostMapping(value = "/add")
    public AtJobApplicationTestModel addInterview(@RequestBody AtJobApplicationTestModel atJobApplicationTestModel) {
        return this.atJobApplicationTestService.addTest(atJobApplicationTestModel);
    }
}

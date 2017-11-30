package ba.infostudio.hcm.atJobApplicationInterview;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("interview")
@CrossOrigin("*")
public class AtJobApplicationInterviewController {
    @Autowired
    private AtJobApplicationInterviewRepository atJobApplicationInterviewRepository;

    @GetMapping("")
    public @ResponseBody Iterable<AtJobApplicationInterviewModel> getAll(){
        return this.atJobApplicationInterviewRepository.findAll();
    }
}

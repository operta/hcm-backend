package ba.infostudio.hcm.atJobApplicationInterview;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("interview")
@CrossOrigin("*")
public class AtJobApplicationInterviewController {
    @Autowired
    private AtJobApplicationInterviewService atJobApplicationInterviewService;

    @GetMapping("")
    public @ResponseBody Iterable<AtJobApplicationInterviewModel> getAll(){
        return this.atJobApplicationInterviewService.getAll();
    }

    @PostMapping(value = "/add")
    public AtJobApplicationInterviewModel addInterview(@RequestBody AtJobApplicationInterviewModel atJobApplicationInterviewModel) {
        return this.atJobApplicationInterviewService.addInterview(atJobApplicationInterviewModel);
    }

    @PutMapping("/update")
    public AtJobApplicationInterviewModel updateInterview(@RequestBody AtJobApplicationInterviewModel atJobApplicationInterviewModel){
        return this.atJobApplicationInterviewService.updateInterview(atJobApplicationInterviewModel);
    }
}

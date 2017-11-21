package ba.infostudio.hcm.apUserStatuses;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/userStatuses")
@CrossOrigin("*")
public class ApUserStatusController {
    @Autowired
    private ApUserStatusRepository apUserStatusRepository;

    @GetMapping("")
    public @ResponseBody Iterable<ApUserStatusModel> getUserStatuses(){
        return this.apUserStatusRepository.findAll();
    }

}
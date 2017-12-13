package ba.infostudio.hcm.atJobApplicationHistory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("jobApplicationHistory")
public class AtJobApplicationHistoryController {
    @Autowired
    private AtJobApplicationHistoryRepository atJobApplicationHistoryRepository;

    @GetMapping("/{id}")
    private @ResponseBody Iterable<AtJobApplicationHistoryModel> getJobApplicationHistory(@PathVariable Long id) {
        return this.atJobApplicationHistoryRepository.findByIdJobApplication_id(id);
    }

    @PostMapping(value = "/add")
    public AtJobApplicationHistoryModel addJobApplicationHistory(@RequestBody AtJobApplicationHistoryModel jobApplicationHistory) {
        System.out.println("OVDJE ______________");
        System.out.println(jobApplicationHistory.toString());
        return this.atJobApplicationHistoryRepository.save(jobApplicationHistory);
    }
}

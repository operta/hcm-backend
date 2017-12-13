package ba.infostudio.hcm.atJobApplicationStatus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AtJobApplicationStatusController {
    @Autowired
    private AtJobApplicationStatusRepository atJobApplicationStatusRepository;

    @RequestMapping("/jobApplicationStatuses")
    public Iterable<AtJobApplicationStatusModel> getAllJobApplicationStatuses(){
        return this.atJobApplicationStatusRepository.findAll();
    }

    @PostMapping(value = "/jobApplicationStatuses/add")
    public AtJobApplicationStatusModel addJobApplicationStatus(@RequestBody AtJobApplicationStatusModel status) {
        return this.atJobApplicationStatusRepository.save(status);
    }

    @PutMapping("/jobApplicationStatuses")
    public AtJobApplicationStatusModel updateJobApplicationStatus(@RequestBody AtJobApplicationStatusModel body) {
        AtJobApplicationStatusModel q = atJobApplicationStatusRepository.findOne(body.getId());
        q.setCode(body.getCode());
        q.setName(body.getName());
        q.setDescription(body.getDescription());
        return this.atJobApplicationStatusRepository.save(q);
    }

    @DeleteMapping("/jobApplicationStatuses/{id}")
    public boolean deleteJobApplicationStatus(@PathVariable String id) {
        this.atJobApplicationStatusRepository.delete(Long.valueOf(id));
        return true;
    }

}

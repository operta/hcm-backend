package ba.infostudio.hcm.rgQualifications;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class RgQualificationsController {
    @Autowired
    private  RgQualificationsRepository rgQualificationsRepository;


    @RequestMapping("/qualifications")
    public Iterable<RgQualificationsModel> getAllQualifications(){
        return this.rgQualificationsRepository.findAll();
    }

    @PostMapping(value = "/qualifications/add")
    public RgQualificationsModel addQualification(@RequestBody RgQualificationsModel skillGrade) {
        return this.rgQualificationsRepository.save(skillGrade);
    }

    @PutMapping("/qualifications")
    public RgQualificationsModel updateQualification(@RequestBody RgQualificationsModel body) {
        RgQualificationsModel q = rgQualificationsRepository.findOne(body.getId());
        q.setCode(body.getCode());
        q.setName(body.getName());
        q.setDescription(body.getDescription());
        return this.rgQualificationsRepository.save(q);
    }

    @DeleteMapping("/qualifications/remove/{id}")
    public boolean deleteSkill(@PathVariable String id) {
        this.rgQualificationsRepository.delete(Long.valueOf(id));
        return true;
    }
}



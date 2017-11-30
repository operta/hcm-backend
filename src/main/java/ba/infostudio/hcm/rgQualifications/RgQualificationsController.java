package ba.infostudio.hcm.rgQualifications;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RgQualificationsController {
    @Autowired
    private  RgQualificationsRepository rgQualificationsRepository;


    @RequestMapping("/qualifications")
    public Iterable<RgQualificationsModel> getAllQualifications(){
        return this.rgQualificationsRepository.findAll();
    }
}



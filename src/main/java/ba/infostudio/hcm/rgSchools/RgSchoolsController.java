package ba.infostudio.hcm.rgSchools;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RgSchoolsController {
    @Autowired
    private RgSchoolsRepository rgSchoolsRepository;

    @RequestMapping("/schools")
    public Iterable<RgSchoolsModel> getAllSchools(){
            return this.rgSchoolsRepository.findAll();
        }
}

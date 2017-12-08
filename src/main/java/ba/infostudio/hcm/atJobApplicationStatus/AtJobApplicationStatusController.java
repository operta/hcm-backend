package ba.infostudio.hcm.atJobApplicationStatus;

import ba.infostudio.hcm.rgRegionTypes.RgRegionTypesModel;
import ba.infostudio.hcm.rgRegionTypes.RgRegionTypesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AtJobApplicationStatusController {
    @Autowired
    private AtJobApplicationStatusRepository atJobApplicationStatusRepository;

    @RequestMapping("/jobApplicationStatuses")
    public Iterable<AtJobApplicationStatusModel> getAllJobApplicationStatuses(){
        return this.atJobApplicationStatusRepository.findAll();
    }

}

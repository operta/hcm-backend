package ba.infostudio.hcm.rgRegionTypes;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RgRegionTypesController {
    @Autowired
    private RgRegionTypesRepository rgRegionTypesRepository;

    @RequestMapping("/regionTypes")
    public Iterable<RgRegionTypesModel> getAllRegions(){
        return this.rgRegionTypesRepository.findAll();
    }
}

package ba.infostudio.hcm.rgRegions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin("*")
public class RgRegionsController {
    @Autowired
    private RgRegionsRepository rgRegionsRepository;

    @RequestMapping("/regions")
    public @ResponseBody Iterable<RgRegionsModel> getAllRegions(){
        return this.rgRegionsRepository.findAll();
    }

}

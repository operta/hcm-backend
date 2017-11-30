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

    @RequestMapping("/regions/cities")
    public @ResponseBody Iterable<RgRegionsModel> getAllCities(){
        return this.rgRegionsRepository.findByIdType_name("City");
    }

    @RequestMapping("/regions/states")
    public @ResponseBody Iterable<RgRegionsModel> getAllStates(){
        return this.rgRegionsRepository.findByIdType_name("State");
    }

    @RequestMapping("/regions/countries")
    public @ResponseBody Iterable<RgRegionsModel> getAllCountries(){
        return this.rgRegionsRepository.findByIdType_name("Country");
    }
    @RequestMapping("/regions/regions")
    public @ResponseBody Iterable<RgRegionsModel> getAllRRegions(){
        return this.rgRegionsRepository.findByIdType_name("Region");
    }

}

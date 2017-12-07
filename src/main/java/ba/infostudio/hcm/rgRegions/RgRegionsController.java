package ba.infostudio.hcm.rgRegions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


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

    @PostMapping(value = "/regions/add")
    public RgRegionsModel addRegion(@RequestBody RgRegionsModel region) {
        return this.rgRegionsRepository.save(region);
    }

    @PutMapping("/regions")
    public RgRegionsModel updateRegion(@RequestBody RgRegionsModel body) {
        RgRegionsModel region = rgRegionsRepository.findOne(body.getId());
        region.setCode(body.getCode());
        region.setName(body.getName());
        region.setDescription(body.getDescription());
        region.setId_parent(body.getId_parent());
        region.setIdType(body.getIdType());
        return this.rgRegionsRepository.save(region);
    }

    @DeleteMapping("/regions/remove/{id}")
    public boolean deleteRegion(@PathVariable String id) {
        this.rgRegionsRepository.delete(Long.valueOf(id));
        return true;
    }

}

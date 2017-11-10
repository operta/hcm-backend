package ba.infostudio.hcm.leLegalEntities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/legalEntities")
public class LeLegalEntitiesController {
    @Autowired
    private LeLegalEntitiesRepository leLegalEntitiesRepository;

    @GetMapping("")
    private @ResponseBody Iterable<LeLegalEntitiesModel> getAll(){
        return this.leLegalEntitiesRepository.findAll();
    }
}

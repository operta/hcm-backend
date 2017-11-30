package ba.infostudio.hcm.atAccomplishmentTypes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AtAccomplishmentTypesController {
    @Autowired
    private AtAccomplishmentTypesRepository atAccomplishmentTypesRepository;

    @RequestMapping("/accomplishmentTypes")
    public Iterable<AtAccomplishmentTypesModel> getAllAccomplishmentTypes(){
        return this.atAccomplishmentTypesRepository.findAll();
    }
}


package ba.infostudio.hcm.ogWorkPlaces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class OgWorkPlacesController {
    @Autowired
    private OgWorkPlacesRepository ogWorkPlacesRepository;

    @RequestMapping("/workPlaces")
    public @ResponseBody Iterable<OgWorkPlacesModel> getWorkPlaces(){
        return this.ogWorkPlacesRepository.findAll();
    }

}

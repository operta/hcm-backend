package ba.infostudio.hcm.ogOrganizations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OgOrganizationsController {
    @Autowired
    private OgOrganizationsRepository ogOrganizationsRepository;

    @RequestMapping("/organizations")
    public Iterable<OgOrganizationsModel> getOrganizations(){
        return this.ogOrganizationsRepository.findAll();
    }
}

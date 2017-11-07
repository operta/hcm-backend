package ba.infostudio.hcm.atVacancies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
public class AtVacancyController {
    @Autowired
    private AtVacancyService atVacancyService;


    @RequestMapping("/vacancies")
    public @ResponseBody Iterable<AtVacancyModel> getAllVacancies(){
        return this.atVacancyService.getAllVacancies();
    }


    @RequestMapping("/vacancies/{id}")
    public AtVacancyModel getAtVacancy(@PathVariable String id) {
        return atVacancyService.getAtVacancy(id);
    }
}

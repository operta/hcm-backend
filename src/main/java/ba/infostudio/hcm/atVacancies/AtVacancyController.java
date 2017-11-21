package ba.infostudio.hcm.atVacancies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/vacancies")
@CrossOrigin("*")
public class AtVacancyController {
    @Autowired
    private AtVacancyService atVacancyService;


    @GetMapping("")
    public @ResponseBody Iterable<AtVacancyModel> getAllVacancies(){
        return this.atVacancyService.getAllVacancies();
    }

    @GetMapping("/{id}")
    public @ResponseBody AtVacancyModel getVacancy(@PathVariable String id) {
        return this.atVacancyService.getVacancy(Long.valueOf(id));
    }


    @PostMapping(value = "/add")
    public AtVacancyModel addVacancy(@RequestBody AtVacancyModel atVacancyModel) {
        return this.atVacancyService.newVacancy(atVacancyModel);
    }



}

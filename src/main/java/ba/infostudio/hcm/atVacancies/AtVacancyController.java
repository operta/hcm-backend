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
    @Autowired
    private AtVacancyRepository atVacancyRepository;


    @GetMapping("")
    public @ResponseBody Iterable<AtVacancyModel> getAllVacancies(){
        return this.atVacancyService.getAllVacancies();
    }


    @PostMapping(value = "/add")
    public AtVacancyModel addVacancy(@RequestBody AtVacancyModel atVacancyModel) {
        System.out.println("bla");
        return this.atVacancyRepository.save(atVacancyModel);
    }




}

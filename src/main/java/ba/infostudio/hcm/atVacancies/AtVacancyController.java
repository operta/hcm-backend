package ba.infostudio.hcm.atVacancies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/vacancies")
@CrossOrigin("*")
public class AtVacancyController {
    @Autowired
    private AtVacancyService atVacancyService;

/*    @GetMapping("")
    public @ResponseBody
    Page<AtVacancyModel> getAllVacancies(){
        return this.atVacancyService.getAllVacancies();
    }*/
    @GetMapping("/{id}")
    public @ResponseBody AtVacancyModel getVacancy(@PathVariable String id) {
        return this.atVacancyService.getVacancy(Long.valueOf(id));
    }


    @GetMapping("/{page}/{size}")
    public @ResponseBody
    Page<AtVacancyModel> getAllVacancies(@PathVariable String page, @PathVariable String size){
        return this.atVacancyService.getAllVacancies(Integer.valueOf(page), Integer.valueOf(size));
    }


    @GetMapping("/active/{page}/{size}")
    public @ResponseBody Page<AtVacancyModel> getActiveVacancies(@PathVariable String page, @PathVariable String size) {
        return this.atVacancyService.getActiveVacancies(Integer.valueOf(page), Integer.valueOf(size));
    }





    @PostMapping(value = "/add")
    public AtVacancyModel addVacancy(@RequestBody AtVacancyModel atVacancyModel) {
        return this.atVacancyService.newVacancy(atVacancyModel);
    }

    @RequestMapping(value = "", method=RequestMethod.PUT, produces={"application/json"})
    public @ResponseBody boolean updateAtVacancy(@RequestBody AtVacancyModel vacancy) {
        this.atVacancyService.updateAtVacancy(vacancy);

        return true;
    }

    @DeleteMapping(value = "/delete/{id}")
    public String deleteVacancy(@PathVariable String id) {
        this.atVacancyService.deleteVacancy(Long.valueOf(id));
        return id;
    }
}

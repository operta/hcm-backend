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
    @Autowired
    private AtVacancyMService atVacancyMService;

/*    @GetMapping("")
    public @ResponseBody
    Page<AtVacancyModel> getAllVacancies(){
        return this.atVacancyService.getAllVacancies();
    }*/

    @GetMapping("/{page}/{size}")
    public @ResponseBody
    Page<AtVacancyModel> getAllVacancies(@PathVariable String page, @PathVariable String size){
        return this.atVacancyService.getAllVacancies(Integer.valueOf(page), Integer.valueOf(size));
    }

    //all vacancies mobile
    @GetMapping("/M/{page}/{size}")
    public @ResponseBody
    Page<AtVacancyMModel> getAllMVacancies(@PathVariable String page, @PathVariable String size){
        return this.atVacancyMService.getAllMVacancies(Integer.valueOf(page), Integer.valueOf(size));
    }

    @GetMapping("/{id}")
    public @ResponseBody AtVacancyModel getVacancy(@PathVariable String id) {
        return this.atVacancyService.getVacancy(Long.valueOf(id));
    }

    //vacancy by vacancy id mobile
    @GetMapping("/M/{id}")
    public @ResponseBody AtVacancyMModel getVacancyM(@PathVariable String id) {
        return this.atVacancyMService.getVacancy(Long.valueOf(id));
    }

    @GetMapping("/active/{page}/{size}")
    public @ResponseBody Page<AtVacancyModel> getActiveVacancies(@PathVariable String page, @PathVariable String size) {
        return this.atVacancyService.getActiveVacancies(Integer.valueOf(page), Integer.valueOf(size));
    }

    //all active vacancy mobile
    @GetMapping("/active/M/{page}/{size}")
    public @ResponseBody Page<AtVacancyMModel> getActiveVacanciesM(@PathVariable String page, @PathVariable String size) {
        return this.atVacancyMService.getActiveMVacancies(Integer.valueOf(page), Integer.valueOf(size));
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

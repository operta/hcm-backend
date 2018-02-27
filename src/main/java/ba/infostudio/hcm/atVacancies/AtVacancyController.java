package ba.infostudio.hcm.atVacancies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.*;

@RestController
@RequestMapping("/vacancies")
@CrossOrigin("*")
public class AtVacancyController {
    @Autowired
    private AtVacancyService atVacancyService;

    @Autowired
    private AtVacancyRepository atVacancyRepository;

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

    @GetMapping("/search")
    public ResponseEntity<List<AtVacancyModel>> getBySearchParameters(
            @RequestParam(value = "fromDate", required = false) Date fromDate,
            @RequestParam(value = "toDate", required = false) Date toDate,
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "statusId", required = false) String statusId,
            @RequestParam(value = "regionId", required = false) String regionId,
            Pageable pageable)
    {

        Set<Integer> vacancyIds = new HashSet<Integer>(Arrays.asList(extractIds(atVacancyRepository.findAll())));

        if(fromDate != null) {
            List<AtVacancyModel> list  = atVacancyRepository.findByDateFromGreaterThanEqual(fromDate);
            Set<Integer> s = new HashSet<Integer>(Arrays.asList(extractIds(list)));
            vacancyIds.retainAll(s);
        }
        if(toDate != null) {
            List<AtVacancyModel> list = atVacancyRepository.findByDateToLessThanEqual(toDate);
            Set<Integer> s = new HashSet<Integer>(Arrays.asList(extractIds(list)));
            vacancyIds.retainAll(s);
        }
        if(name != null && !name.isEmpty()) {
            List<AtVacancyModel> list = atVacancyRepository.findByNameContainingIgnoreCase(name);
            Set<Integer> s = new HashSet<Integer>(Arrays.asList(extractIds(list)));
            vacancyIds.retainAll(s);
        }
        if(statusId != null) {
            List<AtVacancyModel> list = atVacancyRepository.findByStatusId(Long.valueOf(statusId));
            Set<Integer> s = new HashSet<Integer>(Arrays.asList(extractIds(list)));
            vacancyIds.retainAll(s);
        }
        if(regionId != null) {
            List<AtVacancyModel> list = atVacancyRepository.findByIdLocationId(Long.valueOf(regionId));
            Set<Integer> s = new HashSet<Integer>(Arrays.asList(extractIds(list)));
            vacancyIds.retainAll(s);
        }

        Integer[] result = vacancyIds.toArray(new Integer[vacancyIds.size()]);

        List<AtVacancyModel> employees = new ArrayList<AtVacancyModel>();
        for(int i = 0; i < result.length; i++) {
            AtVacancyModel employee = atVacancyRepository.findOne(result[i].longValue());
            employees.add(employee);
        }

        Page<AtVacancyModel> page = new PageImpl<AtVacancyModel>(employees, pageable, employees.size());
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/vacancies/search");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    public static Integer[] extractIds(List<AtVacancyModel> array) {
        if(array.size() == 0) {
            return new Integer[0];
        }
        Integer[] result = new Integer[array.size()];
        for(int i = 0; i < array.size(); i++) {
            result[i] = (array.get(i).getId().intValue());
        }
        return result;
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

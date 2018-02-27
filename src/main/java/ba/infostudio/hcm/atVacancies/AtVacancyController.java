package ba.infostudio.hcm.atVacancies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

@RestController
@RequestMapping("/vacancies")
@CrossOrigin("*")
public class AtVacancyController {
    @Autowired
    private AtVacancyService atVacancyService;
    @Autowired
    private AtVacancyMService atVacancyMService;

    @Autowired
    private AtVacancyMRepository atVacancyMRepository;

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

    @GetMapping("/search")
    public Page<AtVacancyMModel> getBySearchParameters(
            @RequestParam(value = "fromDate", required = false) String fromDate,
            @RequestParam(value = "toDate", required = false) String toDate,
            @RequestParam(value = "dateFormat", required = false) String dateFormat,
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "statusId", required = false) String statusId,
            @RequestParam(value = "regionId", required = false) String regionId,
            @RequestParam(value = "page", required = false) Integer page,
            @RequestParam(value = "size", required = false) Integer size,
            Pageable pageable)
    {

        Set<Integer> vacancyIds = new HashSet<Integer>(Arrays.asList(extractIds(atVacancyMRepository.findAll())));

        if(fromDate != null) {
            SimpleDateFormat formatter = new SimpleDateFormat();
            if (dateFormat != null) {
               formatter = new SimpleDateFormat(dateFormat);
            } else {
                formatter = new SimpleDateFormat("yyyy-MM-dd");
            }
            Date dateFrom = new Date();

            try {
                dateFrom = formatter.parse(fromDate);

            } catch (ParseException e) {
                e.printStackTrace();
            }

            List<AtVacancyMModel> list  = atVacancyMRepository.findByDateFromGreaterThanEqual(dateFrom);
            Set<Integer> s = new HashSet<Integer>(Arrays.asList(extractIds(list)));
            vacancyIds.retainAll(s);
        }
        if(toDate != null) {
            SimpleDateFormat formatter = new SimpleDateFormat();
            if (dateFormat != null) {
                formatter = new SimpleDateFormat(dateFormat);
            } else {
                formatter = new SimpleDateFormat("yyyy-MM-dd");
            }
            Date dateTo = new Date();

            try {
                dateTo = formatter.parse(fromDate);

            } catch (ParseException e) {
                e.printStackTrace();
            }
            List<AtVacancyMModel> list = atVacancyMRepository.findByDateToLessThanEqual(dateTo);
            Set<Integer> s = new HashSet<Integer>(Arrays.asList(extractIds(list)));
            vacancyIds.retainAll(s);
        }
        if(name != null && !name.isEmpty()) {
            List<AtVacancyMModel> list = atVacancyMRepository.findByNameContainingIgnoreCase(name);
            Set<Integer> s = new HashSet<Integer>(Arrays.asList(extractIds(list)));
            vacancyIds.retainAll(s);
        }
        if(statusId != null) {
            List<AtVacancyMModel> list = atVacancyMRepository.findByStatusStatus(statusId);
            Set<Integer> s = new HashSet<Integer>(Arrays.asList(extractIds(list)));
            vacancyIds.retainAll(s);
        }
        if(regionId != null) {
            List<AtVacancyMModel> list = atVacancyMRepository.findByIdLocationId(Long.valueOf(regionId));
            Set<Integer> s = new HashSet<Integer>(Arrays.asList(extractIds(list)));
            vacancyIds.retainAll(s);
        }

        Integer[] result = vacancyIds.toArray(new Integer[vacancyIds.size()]);

        List<AtVacancyMModel> vacancies = new ArrayList<AtVacancyMModel>();
        for(int i = 0; i < result.length; i++) {
            AtVacancyMModel employee = atVacancyMRepository.findOne(result[i].longValue());
            vacancies.add(employee);
        }

        
        return this.createPaging(page, size, vacancies);
    }
    
    public static Page<AtVacancyMModel> createPaging(Integer page, Integer size, List<AtVacancyMModel> data) {
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = new PageRequest(page, size, sort);
        int start = pageable.getOffset();
        int end = (start + pageable.getPageSize()) > data.size() ? data.size() : (start + pageable.getPageSize());
        Page<AtVacancyMModel> currentPage = new PageImpl<AtVacancyMModel>(data.subList(start,end), pageable, data.size());
        return currentPage;
    }

    public static Integer[] extractIds(List<AtVacancyMModel> array) {
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

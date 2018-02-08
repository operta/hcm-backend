package ba.infostudio.hcm.atVacancies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class AtVacancyMService {
    @Autowired
    private AtVacancyMRepository atVacancyMRepository;

    public Page<AtVacancyMModel> getAllMVacancies (Integer page, Integer size) {
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = new PageRequest(page, size, sort);
        return this.atVacancyMRepository.findAll(pageable);
    }

    public Page<AtVacancyMModel> getActiveMVacancies(Integer page, Integer size) {
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = new PageRequest(page, size, sort);
        return this.atVacancyMRepository.findByStatus_Id(Long.valueOf(1),pageable);
    }

    public AtVacancyMModel getVacancy(Long id){
        return this.atVacancyMRepository.findOne(id);
    }

    public AtVacancyMModel updateAtVacancy (AtVacancyMModel vac){
        AtVacancyMModel vacancy = atVacancyMRepository.findOne(vac.getId());

        vacancy.setName(vac.getName());
        vacancy.setDescription(vac.getDescription());
        vacancy.setCode(vac.getCode());
        vacancy.setDate_from(vac.getDate_from());
        vacancy.setDate_to(vac.getDate_to());
        vacancy.setId_location(vac.getId_location());
        vacancy.setStatus(vac.getStatus());

        atVacancyMRepository.save(vacancy);

        return vacancy;
    }

    public AtVacancyMModel newVacancy(AtVacancyMModel vacancy) {
        return this.atVacancyMRepository.save(vacancy);
    }

    public void deleteVacancy(Long id) {
        this.atVacancyMRepository.delete(id);
    }
}

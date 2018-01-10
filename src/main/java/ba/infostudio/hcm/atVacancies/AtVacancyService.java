package ba.infostudio.hcm.atVacancies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class AtVacancyService {
    @Autowired
    private AtVacancyRepository atVacancyRepository;

    public Page<AtVacancyModel> getAllVacancies (Integer page, Integer size) {
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = new PageRequest(page, size, sort);
        return this.atVacancyRepository.findAll(pageable);
    }

    public Page<AtVacancyModel> getActiveVacancies(Integer page, Integer size) {
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = new PageRequest(page, size, sort);
        return this.atVacancyRepository.findByStatus_Id(Long.valueOf(1),pageable);
    }

    public AtVacancyModel getVacancy(Long id){
        return this.atVacancyRepository.findOne(id);
    }

    public AtVacancyModel updateAtVacancy (AtVacancyModel vac){
        AtVacancyModel vacancy = atVacancyRepository.findOne(vac.getId());

        vacancy.setName(vac.getName());
        vacancy.setDescription(vac.getDescription());
        vacancy.setCode(vac.getCode());
        vacancy.setDate_from(vac.getDate_from());
        vacancy.setDate_to(vac.getDate_to());
        vacancy.setId_location(vac.getId_location());
        vacancy.setStatus(vac.getStatus());

        atVacancyRepository.save(vacancy);

        return vacancy;
    }

    public AtVacancyModel newVacancy(AtVacancyModel vacancy) {
        return this.atVacancyRepository.save(vacancy);
    }

    public void deleteVacancy(Long id) {
        this.atVacancyRepository.delete(id);
    }
}

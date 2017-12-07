package ba.infostudio.hcm.atVacancies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class AtVacancyService {
    @Autowired
    private AtVacancyRepository atVacancyRepository;

    public Iterable<AtVacancyModel> getAllVacancies () {
        return this.atVacancyRepository.findAll();
    }

    public AtVacancyModel getVacancy(Long id){
        return this.atVacancyRepository.findOne(id);
    }

    public AtVacancyModel addVacancy(AtVacancyModel atVacancyModel){
        return this.atVacancyRepository.save(atVacancyModel);
    }



    public AtVacancyModel updateAtVacancy (AtVacancyModel vac){
        AtVacancyModel vacancy = atVacancyRepository.findOne(vac.getId());

        vacancy.setName(vac.getName());
        vacancy.setDescription(vac.getDescription());
        vacancy.setCode(vac.getCode());
        vacancy.setDate_from(vac.getDate_from());
        vacancy.setDate_to(vac.getDate_to());
        vacancy.setId_location(vac.getId_location());
        vacancy.setId_work_place(vac.getId_work_place());

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

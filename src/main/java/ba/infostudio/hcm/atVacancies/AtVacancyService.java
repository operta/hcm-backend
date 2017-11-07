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

    public AtVacancyModel getAtVacancy (String id){
        return atVacancyRepository.findOne(Long.valueOf(id));
    }
}

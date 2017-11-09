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


    public AtVacancyModel addVacancy(AtVacancyModel atVacancyModel){
        return this.atVacancyRepository.save(atVacancyModel);
    }

    public AtVacancyModel updateAtVacancy (AtVacancyModel vac){
        System.out.println("START MESSAGE ______________");

        System.out.println("RECEIVED DATA ______________");
        System.out.println(vac.toString());


        AtVacancyModel vacancy = atVacancyRepository.findOne(vac.getId());

        System.out.println("MODEL FROM DB ______________");
        System.out.println(vacancy.toString());
        vacancy.setName(vac.getName());
        vacancy.setDescription(vac.getDescription());
        vacancy.setCode(vac.getCode());
        vacancy.setDate_from(vac.getDate_from());
        vacancy.setDate_to(vac.getDate_to());

        System.out.println("AFTER NAME CHANGE MODEL FROM DB ______________");
        System.out.println(vacancy.toString());

        atVacancyRepository.save(vacancy);

        System.out.println("END MESSAGE ______________");
        return vacancy;
    }
}

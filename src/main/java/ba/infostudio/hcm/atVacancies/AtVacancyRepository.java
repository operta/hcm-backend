package ba.infostudio.hcm.atVacancies;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface AtVacancyRepository extends JpaRepository<AtVacancyModel, Long> {
}

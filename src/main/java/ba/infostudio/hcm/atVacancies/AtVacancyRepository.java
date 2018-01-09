package ba.infostudio.hcm.atVacancies;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface AtVacancyRepository extends JpaRepository<AtVacancyModel, Long> {
    Page<AtVacancyModel> findByStatus_Id(Long id, Pageable pageable);
    Page<AtVacancyModel> findAll(Pageable pageable);
}

package ba.infostudio.hcm.atVacancies;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AtVacancyMRepository extends JpaRepository<AtVacancyMModel, Long> {
    Page<AtVacancyMModel> findByStatus_Id(Long id, Pageable pageable);
    Page<AtVacancyMModel> findAll(Pageable pageable);
}

package ba.infostudio.hcm.atVacancies;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface AtVacancyMRepository extends JpaRepository<AtVacancyMModel, Long> {
    Page<AtVacancyMModel> findByStatus_Id(Long id, Pageable pageable);
    Page<AtVacancyMModel> findAll(Pageable pageable);
    List<AtVacancyMModel> findByDateFromGreaterThanEqual(Date fromDate);
    List<AtVacancyMModel> findByDateToLessThanEqual(Date toDate);
    List<AtVacancyMModel> findByIdLocationId(Long id);
    List<AtVacancyMModel> findByStatusStatus(String value);
    List<AtVacancyMModel> findByNameContainingIgnoreCase(String value);
}

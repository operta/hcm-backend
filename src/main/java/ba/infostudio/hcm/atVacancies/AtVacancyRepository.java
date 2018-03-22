package ba.infostudio.hcm.atVacancies;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.util.Date;
import java.util.List;


public interface AtVacancyRepository extends JpaRepository<AtVacancyModel, Long> {
    Page<AtVacancyModel> findByStatus_Id(Long id, Pageable pageable);
    Page<AtVacancyModel> findAll(Pageable pageable);

    @Query("SELECT ATV.name FROM AtVacancyModel ATV, AtJobApplicationModel ATJ WHERE ATV.id = ATJ.vacancyid AND ATJ.id = :jobApplicationId")
    String findByJobApplicationId(@Param("jobApplicationId") long jobApplicationId);

}

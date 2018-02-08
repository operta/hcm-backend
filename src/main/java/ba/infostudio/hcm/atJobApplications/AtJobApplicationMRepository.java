package ba.infostudio.hcm.atJobApplications;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AtJobApplicationMRepository extends JpaRepository<AtJobApplicationMModel, Long> {
    Iterable<AtJobApplicationMModel> findByApplicantid_id(Long id);
    Iterable<AtJobApplicationMModel> findByVacancyid_Id(Long id);
}

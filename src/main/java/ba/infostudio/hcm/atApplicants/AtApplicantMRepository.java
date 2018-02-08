package ba.infostudio.hcm.atApplicants;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AtApplicantMRepository extends JpaRepository<AtApplicantMModel, Long> {
    AtApplicantMModel findByIdUser_id(Long id);
}

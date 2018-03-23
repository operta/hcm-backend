package ba.infostudio.hcm.apUsers;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ApUserRepository extends CrudRepository<ApUserModel, Long>{
    ApUserModel findByUsername(String username);
    ApUserModel findByEmail(String email);

    @Query("SELECT AP.username FROM ApUserModel AP, AtApplicantModel ATA, AtJobApplicationModel ATJ WHERE ATA.id = ATJ.applicantid AND AP.id = ATA.idUser AND ATJ.id = :jobApplicationId")
    String findByJobApplicationId(@Param("jobApplicationId") long jobApplicationId);
}

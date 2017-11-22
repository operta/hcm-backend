package ba.infostudio.hcm.atApplicants;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AtApplicantService {
    @Autowired
    private AtApplicantRepository atApplicantRepository;

    public Iterable<AtApplicantModel> getAllApplicants () {
        return this.atApplicantRepository.findAll();
    }

    public AtApplicantModel getApplicant(String id) {
        return this.atApplicantRepository.findByIdUser_id(Long.valueOf(id));
    }


    public AtApplicantModel addApplicant(AtApplicantModel atApplicantModel){
        return this.atApplicantRepository.save(atApplicantModel);
    }

    public AtApplicantModel updateApplicant (AtApplicantModel applicantData){
        AtApplicantModel applicant = atApplicantRepository.findOne(applicantData.getId());

        applicant.setName(applicantData.getName());
        applicant.setBirthdate(applicantData.getBirthdate());
        applicant.setSurname(applicantData.getSurname());
        applicant.setMiddle_name(applicantData.getMiddle_name());
        applicant.setMaiden_name(applicantData.getMaiden_name());
        applicant.setGender(applicantData.getGender());
        applicant.setMarital_status(applicantData.getMarital_status());
//        applicant.setId_city(applicantData.getId_city());
//        applicant.setId_country(applicantData.getId_country());
        applicant.setId_region(applicantData.getId_region());

        return this.atApplicantRepository.save(applicant);
    }

}

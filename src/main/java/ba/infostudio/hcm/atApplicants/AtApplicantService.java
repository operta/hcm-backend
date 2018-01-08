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

    public AtApplicantModel getApplicant(Long id) {
        return this.atApplicantRepository.findByIdUser_id(id);
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
        applicant.setId_city(applicantData.getId_city());
        applicant.setId_country(applicantData.getId_country());
        applicant.setId_region(applicantData.getId_region());
        applicant.setAddress(applicantData.getAddress());
        applicant.setId_qualification(applicantData.getId_qualification());
        applicant.setEmployed(applicantData.getEmployed());
        applicant.setEmployment_position(applicantData.getEmployment_position());
        applicant.setIndustry(applicantData.getIndustry());
        applicant.setDescription(applicantData.getDescription());

        return this.atApplicantRepository.save(applicant);
    }

    public void updateApplicantImage (String link, Long userId) {
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println(link);
        System.out.println(userId);

        AtApplicantModel applicant = atApplicantRepository.findByIdUser_id(userId);
        if(applicant != null){
            applicant.setImage_link(link);
            atApplicantRepository.save(applicant);
        }
    }

}

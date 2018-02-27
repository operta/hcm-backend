package ba.infostudio.hcm.atApplicants;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AtApplicantMService {
    @Autowired
    private AtApplicantMRepository atApplicantMRepository;

    public Iterable<AtApplicantMModel> getAllApplicants () {
        return this.atApplicantMRepository.findAll();
    }

    public AtApplicantMModel getApplicantByUser(Long id) {
        return this.atApplicantMRepository.findByIdUser_id(id);
    }

    public AtApplicantMModel getApplicantById(Long id) {
        return this.atApplicantMRepository.findOne(id);
    }


    public AtApplicantMModel addApplicant(AtApplicantMModel AtApplicantMModel){
        return this.atApplicantMRepository.save(AtApplicantMModel);
    }

    public AtApplicantMModel updateApplicant (AtApplicantMModel applicantData){
        AtApplicantMModel applicant = atApplicantMRepository.findOne(applicantData.getId());

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

        return this.atApplicantMRepository.save(applicant);
    }

    public void updateApplicantImage (String link, Long userId) {
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println(link);
        System.out.println(userId);

        AtApplicantMModel applicant = atApplicantMRepository.findByIdUser_id(userId);
        if(applicant != null){
            applicant.setImage_link(link);
            atApplicantMRepository.save(applicant);
        }
    }

}

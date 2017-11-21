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


    public AtApplicantModel addApplicant(AtApplicantModel atApplicantModel){
        return this.atApplicantRepository.save(atApplicantModel);
    }

    public AtApplicantModel updateApplicant (AtApplicantModel applicantData){
        AtApplicantModel applicant = atApplicantRepository.findOne(applicantData.getId());

        applicant.setName(applicantData.getName());


        return this.atApplicantRepository.save(applicant);
    }

}

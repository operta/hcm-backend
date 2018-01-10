package ba.infostudio.hcm.atJobApplicationInterview;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Collection;

@Service
public class AtJobApplicationInterviewService {
    @Autowired
    private AtJobApplicationInterviewRepository atJobApplicationInterviewRepository;

    public Collection<AtJobApplicationInterviewModel> getAll() {
        return this.atJobApplicationInterviewRepository.findAll();
    }

    public AtJobApplicationInterviewModel addInterview(AtJobApplicationInterviewModel interview) {
        return this.atJobApplicationInterviewRepository.save(interview);
    }

    public AtJobApplicationInterviewModel updateInterview(AtJobApplicationInterviewModel interview){
        AtJobApplicationInterviewModel i = atJobApplicationInterviewRepository.findOne(interview.getId());
        i.setGrade(interview.getGrade());
        i.setDescription(interview.getDescription());
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        i.setUpdated_at(timestamp);
        return this.atJobApplicationInterviewRepository.save(i);
    }
}

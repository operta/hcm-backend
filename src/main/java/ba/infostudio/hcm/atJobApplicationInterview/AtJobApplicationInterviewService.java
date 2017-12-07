package ba.infostudio.hcm.atJobApplicationInterview;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}

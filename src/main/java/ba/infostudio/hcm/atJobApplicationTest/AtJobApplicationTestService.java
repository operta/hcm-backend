package ba.infostudio.hcm.atJobApplicationTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Collection;

@Service
public class AtJobApplicationTestService {
    @Autowired
    private AtJobApplicationTestRepository atJobApplicationTestRepository;

    public Collection<AtJobApplicationTestModel> getAll() {
        return this.atJobApplicationTestRepository.findAll();
    }

    public AtJobApplicationTestModel addTest(AtJobApplicationTestModel test) {
        return this.atJobApplicationTestRepository.save(test);
    }

    public AtJobApplicationTestModel updateTest(AtJobApplicationTestModel test){
        AtJobApplicationTestModel i = atJobApplicationTestRepository.findOne(test.getId());
        i.setScore(test.getScore());
        i.setShort_description(test.getShort_description());
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        i.setUpdated_at(timestamp);
        return this.atJobApplicationTestRepository.save(i);
    }
}

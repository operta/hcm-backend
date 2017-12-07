package ba.infostudio.hcm.atJobApplicationTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}

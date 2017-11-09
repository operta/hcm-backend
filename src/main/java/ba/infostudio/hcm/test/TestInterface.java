package ba.infostudio.hcm.test;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;


public interface TestInterface extends CrudRepository<TestModel, Long> {

}

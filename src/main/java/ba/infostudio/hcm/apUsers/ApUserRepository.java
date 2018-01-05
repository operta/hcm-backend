package ba.infostudio.hcm.apUsers;

import org.springframework.data.repository.CrudRepository;

public interface ApUserRepository extends CrudRepository<ApUserModel, Long>{
    ApUserModel findByUsername(String username);
    ApUserModel findByEmail(String email);
}

package ba.infostudio.hcm.apUserDeviceTokens;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface apUserDeviceTokenRepository extends CrudRepository<apUserDeviceTokenModel, Long> {
    Iterable<apUserDeviceTokenModel> findByIdUserId(Long id);

    @Query("SELECT AP.content FROM apUserDeviceTokenModel AP WHERE AP.idUser = (SELECT U.id FROM ApUserModel U WHERE U.username = :username)")
    List<String> findByUsername(@Param("username") String username);
}


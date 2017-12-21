package ba.infostudio.hcm.atJobApplicationNotifications;


import org.springframework.data.repository.CrudRepository;

public interface AtJobApplicationNotificationRepository extends CrudRepository<AtJobApplicationNotificationModel, Long>{
    Iterable<AtJobApplicationNotificationModel> findAllByOrderByDateSentDesc();
}

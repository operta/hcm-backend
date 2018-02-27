package ba.infostudio.hcm.atJobApplicationNotifications;

import org.springframework.data.repository.CrudRepository;

public interface IosJobApplicationNotificationRepository extends CrudRepository<IosJobApplicationNotificationModel, Long> {
    Iterable<IosJobApplicationNotificationModel> findAllByOrderByDateSentDesc();
    Iterable<IosJobApplicationNotificationModel> findByIdJobApplication_Applicantid_IdOrderByDateSentDesc(Long id);
}

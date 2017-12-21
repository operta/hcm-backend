package ba.infostudio.hcm.atJobApplicationNotifications;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AtJobApplicationNotificationController {

    @Autowired
    private AtJobApplicationNotificationRepository atJobApplicationNotificationRepository;


    @RequestMapping("/jobApplicationNotifications")
    public Iterable<AtJobApplicationNotificationModel> getAllJobApplicationNotifications(){
        return this.atJobApplicationNotificationRepository.findAllByOrderByDateSentDesc();
    }

    @PostMapping(value = "/jobApplicationNotifications/add")
    public AtJobApplicationNotificationModel addJobApplicationNotification(@RequestBody AtJobApplicationNotificationModel notification) {
        return this.atJobApplicationNotificationRepository.save(notification);
    }

    @PutMapping("/jobApplicationNotifications")
    public AtJobApplicationNotificationModel updateJobApplicationNotification(@RequestBody AtJobApplicationNotificationModel body) {
        AtJobApplicationNotificationModel q = atJobApplicationNotificationRepository.findOne(body.getId());
        q.setIdJobApplication(body.getIdJobApplication());
        q.setId_notification(body.getId_notification());
        q.setIs_active(body.getIs_active());
        q.setDateSent(body.getDateSent());
        return this.atJobApplicationNotificationRepository.save(q);
    }

}

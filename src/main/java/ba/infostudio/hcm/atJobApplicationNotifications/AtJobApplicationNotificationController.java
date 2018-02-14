package ba.infostudio.hcm.atJobApplicationNotifications;

import ba.infostudio.hcm.atApplicantsSchools.IosApplicantSchoolModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;

@RestController
public class AtJobApplicationNotificationController {

    @Autowired
    private AtJobApplicationNotificationRepository atJobApplicationNotificationRepository;

    @Autowired
    private IosJobApplicationNotificationRepository iosJobApplicationNotificationRepository;

    @Autowired
    public JavaMailSender emailSender;

    @RequestMapping("/jobApplicationNotifications")
    public Iterable<AtJobApplicationNotificationModel> getAllJobApplicationNotifications(){
        return this.atJobApplicationNotificationRepository.findAllByOrderByDateSentDesc();
    }

    @GetMapping("/jobApplicationNotifications/nojsog/{id}")
    public Iterable<IosJobApplicationNotificationModel> getAllJobApplicationNotificationsWithoutJsog(@PathVariable String id){
        return this.iosJobApplicationNotificationRepository.findByIdJobApplication_Applicantid_IdOrderByDateSentDesc(Long.valueOf(id));
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
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        q.setUpdated_at(timestamp);
        return this.atJobApplicationNotificationRepository.save(q);
    }

}

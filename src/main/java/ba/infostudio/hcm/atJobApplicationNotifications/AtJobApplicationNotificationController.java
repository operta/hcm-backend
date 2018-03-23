package ba.infostudio.hcm.atJobApplicationNotifications;

import ba.infostudio.hcm.apUserDeviceTokens.ApUserDeviceTokenController;
import ba.infostudio.hcm.apUserDeviceTokens.apUserDeviceTokenModel;
import ba.infostudio.hcm.apUserDeviceTokens.apUserDeviceTokenRepository;
import ba.infostudio.hcm.apUsers.ApUserModel;
import ba.infostudio.hcm.apUsers.ApUserRepository;
import ba.infostudio.hcm.atApplicants.AtApplicantRepository;
import ba.infostudio.hcm.atApplicantsSchools.IosApplicantSchoolModel;
import ba.infostudio.hcm.atVacancies.AtVacancyRepository;
import com.voodoodyne.jackson.jsog.JSOGGenerator;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.jwt.Jwt;
import org.springframework.security.jwt.JwtHelper;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@RestController
public class AtJobApplicationNotificationController {

    @Autowired
    private AtJobApplicationNotificationRepository atJobApplicationNotificationRepository;

    @Autowired
    private IosJobApplicationNotificationRepository iosJobApplicationNotificationRepository;

    @Autowired
    private apUserDeviceTokenRepository tokenRepository;

    @Autowired
    private AtVacancyRepository atVacancyRepository;

    @Autowired
    private ApUserRepository apUserRepository;

    @Autowired
    public JavaMailSender emailSender;

    @Autowired
    AndroidPushNotificationsService androidPushNotificationsService;

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



        String userName = this.apUserRepository.findByJobApplicationId(notification.getIdJobApplication().getId());
        System.out.println("Username: ");
        System.out.println(userName);
        // user device tokens where the notifications are going to be sent
        List<String> deviceTokens = tokenRepository.findByUsername(userName);

        // name of the vacancy for which the job application status has been updated
        String vacancyName = atVacancyRepository.findByJobApplicationId(notification.getIdJobApplication().getId());


        for (String deviceToken : deviceTokens) {
            try {
                JSONObject pushNotification = new JSONObject();
                pushNotification.put("title", vacancyName);
                pushNotification.put("body", "Your status has been successfully updated!");

                JSONObject body = new JSONObject();
                body.put("to", deviceToken);
                body.put("priority", "high");


                body.put("notification", pushNotification);
                HttpEntity<String> request = new HttpEntity<>(body.toString());

                CompletableFuture<String> pushNotifications = androidPushNotificationsService.send(request);
                CompletableFuture.allOf(pushNotifications).join();

                try {
                    String firebaseResponse = pushNotifications.get();
                    System.out.println(firebaseResponse);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
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

package ba.infostudio.hcm.email;

import ba.infostudio.hcm.atApplicants.AtApplicantModel;
import ba.infostudio.hcm.atApplicants.AtApplicantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmailController {

    @Autowired
    public JavaMailSender emailSender;

    @Autowired
    public AtApplicantRepository atApplicantRepository;


    @PostMapping(value = "/email/{applicantId}")
    public boolean sendEmail(@PathVariable long applicantId, @RequestBody String content) {
        AtApplicantModel applicant = this.atApplicantRepository.findOne(applicantId);
        String userEmail = applicant.getIdUser().getEmail();
        if(userEmail != null) {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(userEmail);
            message.setSubject("Recruitment manager");
            content = content.toString();
            content.replaceAll("\\n","<br>");
            message.setText(content);
            emailSender.send(message);
            return true;
        }
        return false;
    }


}


package ba.infostudio.hcm.apUsers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class ApUserService implements UserDetailsService {
    @Autowired
    private ApUserRepository apUserRepository;

    @Autowired
    public JavaMailSender emailSender;

    @Value("${security.encoding-strength}")
    private Integer encodingStrength;

    public Iterable<ApUserModel> getAllUsers() {
        return this.apUserRepository.findAll();
    }

    public ApUserModel getUser(String id){
        return apUserRepository.findOne(Long.valueOf(id));
    }

    public ApUserModel addUser(ApUserModel apUserModel){
        ShaPasswordEncoder encoder = new ShaPasswordEncoder(encodingStrength);
        apUserModel.setPassword(encoder.encodePassword(apUserModel.getPassword(), null));
        return this.apUserRepository.save(apUserModel);
    }

    public ApUserModel updatePassword(String id, String password) {
        ApUserModel user = this.apUserRepository.findOne(Long.valueOf(id));
        ShaPasswordEncoder encoder = new ShaPasswordEncoder(encodingStrength);
        user.setPassword(encoder.encodePassword(password, null));
        return this.apUserRepository.save(user);
    }

    public boolean comparePassword(String id, String password) {
        ApUserModel user = this.apUserRepository.findOne(Long.valueOf(id));
        ShaPasswordEncoder encoder = new ShaPasswordEncoder(encodingStrength);
        String hashedPassword = encoder.encodePassword(password, null);
        if(hashedPassword.equals(user.getPassword()) ) {
            return true;
        } else {
            return false;
        }
    }

    public boolean resetPasswordFor(String userEmail) {
        ApUserModel user = this.apUserRepository.findByEmail(userEmail);
        if(user != null){
            ShaPasswordEncoder encoder = new ShaPasswordEncoder(encodingStrength);
            Random random = new Random();
            int unHashedPassword = 100000 + random.nextInt(900000);
            System.out.println();
            System.out.println(String.valueOf(unHashedPassword));
            String hashedPassword = encoder.encodePassword(String.valueOf(unHashedPassword), null);
            user.setPassword(hashedPassword);
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            user.setUpdated_at(timestamp);
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(userEmail);
            message.setSubject("Reset password");
            message.setText(
                "Your password has been successfully reset. \n" +
                "Your new password is: " + unHashedPassword +
                "\nYour username is: " + user.getUsername() +
                "\nYou can change your password in Account Settings.\n" +
                "\nBest regards, \n" +
                "Infostudio Team"
            );
            emailSender.send(message);
            apUserRepository.save(user);
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        ApUserModel user = apUserRepository.findByUsername(s);

        if(user == null) {
            throw new UsernameNotFoundException(String.format("The username %s doesn't exist", s));
        }

        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(user.getRole()));


        UserDetails userDetails = new org.springframework.security.core.userdetails.
                User(user.getUsername(), user.getPassword(), authorities);

        return userDetails;
    }
}


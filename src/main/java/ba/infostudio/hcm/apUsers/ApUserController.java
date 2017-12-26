package ba.infostudio.hcm.apUsers;

import ba.infostudio.hcm.atApplicantAccomplishments.AtApplicantAccomplishmentModel;
import ba.infostudio.hcm.atVacancies.AtVacancyModel;
import ba.infostudio.hcm.atVacancies.AtVacancyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/users")
public class ApUserController {
    @Autowired
    private ApUserService apUserService;

    @Autowired
    private ApUserRepository apUserRepository;

    @GetMapping("")
    @PreAuthorize("hasAuthority('ADMIN')")
    public @ResponseBody
    Iterable<ApUserModel> getAllUsers(){
        return this.apUserService.getAllUsers();
    }

    @PutMapping("")
    public ApUserModel updateUser(@RequestBody ApUserModel body) {
        ApUserModel user = apUserRepository.findOne(body.getId());
        user.setEmail(body.getEmail());
        user.setUsername(body.getUsername());
        user.setImage_path(body.getImage_path());
        return this.apUserRepository.save(user);
    }

    @RequestMapping("/{username}")
//    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('USER')")
    public ApUserModel getUser(@PathVariable String username) {
        return this.apUserRepository.findByUsername(username);
    }

    @RequestMapping("/passwordOf/{id}")
    public boolean comparePassword(@PathVariable String id, @RequestParam("password") String password) {
        return this.apUserService.comparePassword(id, password);
    }

    @PutMapping("/passwordOf/{id}")
    public ApUserModel updatePassword(@PathVariable String id, @RequestBody String password) {
        return this.apUserService.updatePassword(id, password);
    }


    @PostMapping(value = "/add")
    public boolean addUser(@RequestBody ApUserModel apUserModel) {
        if(this.apUserRepository.findByUsername(apUserModel.getUsername()) == null)
        {
            this.apUserService.addUser(apUserModel);
            return true;
        }
        else
            return false;
    }


//    @PostMapping(value = "/image")
//    public boolean savePhoto(@RequestBody ApUserModel apUserModel) {
//        if(this.apUserRepository.findByUsername(apUserModel.getUsername()) == null)
//        {
//            this.apUserService.addUser(apUserModel);
//            return true;
//        }
//        else
//            return false;
//    }

}


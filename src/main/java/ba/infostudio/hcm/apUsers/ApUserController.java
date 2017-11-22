package ba.infostudio.hcm.apUsers;

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

    @RequestMapping("/{username}")
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('USER')")
    public ApUserModel getUser(@PathVariable String username) {
        return this.apUserRepository.findByUsername(username);
    }

    @PostMapping(value = "/add")
    public ApUserModel addUser(@RequestBody ApUserModel apUserModel) {
        return this.apUserService.addUser(apUserModel);
    }

}


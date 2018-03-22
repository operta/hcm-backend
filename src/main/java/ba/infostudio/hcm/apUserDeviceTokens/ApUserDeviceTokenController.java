package ba.infostudio.hcm.apUserDeviceTokens;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class ApUserDeviceTokenController {
    @Autowired
    private apUserDeviceTokenRepository apUserDeviceTokenRepository;


    @RequestMapping("/userDeviceTokens")
    public Iterable<apUserDeviceTokenModel> getAllTokens() {
        return this.apUserDeviceTokenRepository.findAll();
    }

    @GetMapping("/userDeviceTokens/{id}")
    @ResponseBody
    public Iterable<apUserDeviceTokenModel> getUserTokens(@PathVariable String id) {
        return this.apUserDeviceTokenRepository.findByIdUserId(Long.valueOf(id));
    }


    @PostMapping(value = "/userDeviceTokens/add")
    public apUserDeviceTokenModel addUserToken(@RequestBody apUserDeviceTokenModel body) {
        return this.apUserDeviceTokenRepository.save(body);
    }

    @PutMapping("/userDeviceTokens")
    public apUserDeviceTokenModel updateUserToken(@RequestBody apUserDeviceTokenModel body) {
        apUserDeviceTokenModel item = apUserDeviceTokenRepository.findOne(body.getId());
        item.setContent(body.getContent());
        return this.apUserDeviceTokenRepository.save(item);
    }

    @DeleteMapping("/userDeviceTokens/remove/{id}")
    public boolean deleteUserToken(@PathVariable String id) {
        this.apUserDeviceTokenRepository.delete(Long.valueOf(id));
        return true;
    }
}
package ba.infostudio.hcm.rgContactTypes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class RgContactTypeController {
    @Autowired
    private RgContactTypeRepository rgContactTypeRepository;

    @RequestMapping("/contactTypes")
    public Iterable<RgContactTypeModel> getAllContactTypes() {
        return this.rgContactTypeRepository.findAll();
    }

    @PostMapping(value = "/contactTypes/add")
    public RgContactTypeModel addContactType(@RequestBody RgContactTypeModel body) {
        return this.rgContactTypeRepository.save(body);
    }

    @PutMapping("/contactTypes")
    public RgContactTypeModel updateContactType(@RequestBody RgContactTypeModel body) {
        RgContactTypeModel item = rgContactTypeRepository.findOne(body.getId());
        item.setCode(body.getCode());
        item.setName(body.getName());
        item.setDescription(body.getDescription());
        return this.rgContactTypeRepository.save(item);
    }

    @DeleteMapping("/contactTypes/remove/{id}")
    public boolean deleteContactType(@PathVariable String id) {
        this.rgContactTypeRepository.delete(Long.valueOf(id));
        return true;
    }
}



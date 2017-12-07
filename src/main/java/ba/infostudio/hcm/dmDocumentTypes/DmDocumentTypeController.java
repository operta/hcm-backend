package ba.infostudio.hcm.dmDocumentTypes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class DmDocumentTypeController {
    @Autowired
    private DmDocumentTypeRepository dmDocumentTypeRepository;

    @RequestMapping("/documentTypes")
    public Iterable<DmDocumentTypeModel> getAllDocumentTypes() {
        return this.dmDocumentTypeRepository.findAll();
    }

    @PostMapping(value = "/documentTypes/add")
    public DmDocumentTypeModel addDocumentType(@RequestBody DmDocumentTypeModel document) {
        return this.dmDocumentTypeRepository.save(document);
    }

    @PutMapping("/documentTypes")
    public DmDocumentTypeModel updateDocumentType(@RequestBody DmDocumentTypeModel body) {
        DmDocumentTypeModel document = dmDocumentTypeRepository.findOne(body.getId());
        document.setCode(body.getCode());
        document.setName(body.getName());
        document.setDescription(body.getDescription());
        return this.dmDocumentTypeRepository.save(document);
    }

    @DeleteMapping("/documentTypes/remove/{id}")
    public boolean deleteDocumentType(@PathVariable String id) {
        this.dmDocumentTypeRepository.delete(Long.valueOf(id));
        return true;
    }
}
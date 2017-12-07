package ba.infostudio.hcm.atApplicantContacts;

import ba.infostudio.hcm.atApplicantDocuments.AtApplicantDocumentModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class AtApplicantContactController {
    @Autowired
    private AtApplicantContactRepository atApplicantContactRepository;

    @RequestMapping("/applicantContacts")
    public Iterable<AtApplicantContactModel> getAllApplicantContacts() {
        return this.atApplicantContactRepository.findAll();
    }

    @GetMapping("/applicantContacts/{id}")
    @ResponseBody
    public Iterable<AtApplicantContactModel> getApplicantContacts(@PathVariable String id) {
        return this.atApplicantContactRepository.findByIdApplicant_id(Long.valueOf(id));
    }

    @PostMapping(value = "/applicantContacts/add")
    public AtApplicantContactModel addApplicantContact(@RequestBody AtApplicantContactModel body) {
        return this.atApplicantContactRepository.save(body);
    }

    @PutMapping("/applicantContacts")
    public AtApplicantContactModel updateApplicantContact(@RequestBody AtApplicantContactModel body) {
        AtApplicantContactModel item = atApplicantContactRepository.findOne(body.getId());
        item.setIdApplicant(body.getIdApplicant());
        item.setId_contact_type(body.getId_contact_type());
        item.setContact(body.getContact());
        item.setDescription(body.getDescription());
        return this.atApplicantContactRepository.save(item);
    }

    @DeleteMapping("/applicantContacts/remove/{id}")
    public boolean deleteApplicantContact(@PathVariable String id) {
        this.atApplicantContactRepository.delete(Long.valueOf(id));
        return true;
    }
}
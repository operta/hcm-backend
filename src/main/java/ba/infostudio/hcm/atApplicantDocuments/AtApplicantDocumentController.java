package ba.infostudio.hcm.atApplicantDocuments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AtApplicantDocumentController {
    @Autowired
    private AtApplicantDocumentRepository atApplicantDocumentRepository;

    @RequestMapping("/applicantDocuments")
    public Iterable<AtApplicantDocumentModel> getAllApplicantDocuments() {
        return this.atApplicantDocumentRepository.findAll();
    }

    @GetMapping("/applicantDocuments/{id}")
    @ResponseBody
    public Iterable<AtApplicantDocumentModel> getApplicantDocuments(@PathVariable String id) {
        return this.atApplicantDocumentRepository.findByIdApplicant_id(Long.valueOf(id));
    }


    @PostMapping(value = "/applicantDocuments/add")
    public AtApplicantDocumentModel addApplicantDocument(@RequestBody AtApplicantDocumentModel document) {
        return this.atApplicantDocumentRepository.save(document);
    }

    @PutMapping("/applicantDocuments")
    public AtApplicantDocumentModel updateApplicantDocument(@RequestBody AtApplicantDocumentModel body) {
        AtApplicantDocumentModel document = atApplicantDocumentRepository.findOne(body.getId());
        document.setIdApplicant(body.getIdApplicant());
        document.setId_document_link(body.getId_document_link());
        document.setId_document_type(body.getId_document_type());
        document.setName(body.getName());
        document.setDescription(body.getDescription());
        document.setValid_from(body.getValid_from());
        document.setValid_to(body.getValid_to());
        return this.atApplicantDocumentRepository.save(document);
    }

    @DeleteMapping("/applicantDocuments/remove/{id}")
    public boolean deleteApplicantDocument(@PathVariable String id) {
        this.atApplicantDocumentRepository.delete(Long.valueOf(id));
        return true;
    }
}
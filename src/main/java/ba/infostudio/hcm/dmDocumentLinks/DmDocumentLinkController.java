package ba.infostudio.hcm.dmDocumentLinks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class DmDocumentLinkController {
    @Autowired
    private DmDocumentLinkRepository dmDocumentLinkRepository;

    @RequestMapping("/documentLinks")
    public Iterable<DmDocumentLinkModel> getAllDocumentLinks() {
        return this.dmDocumentLinkRepository.findAll();
    }

    @PostMapping(value = "/documentLinks/add")
    public DmDocumentLinkModel addDocumentLink(@RequestBody DmDocumentLinkModel document) {
        return this.dmDocumentLinkRepository.save(document);
    }

    @PutMapping("/documentLinks")
    public DmDocumentLinkModel updateDocumentLink(@RequestBody DmDocumentLinkModel body) {
        DmDocumentLinkModel document = dmDocumentLinkRepository.findOne(body.getId());
        document.setDocument_name(body.getDocument_name());
        document.setFile_name(body.getFile_name());
        document.setFile_path(body.getFile_path());
        document.setUri(body.getUri());
        document.setDocument_blob(body.getDocument_blob());
        return this.dmDocumentLinkRepository.save(document);
    }

    @DeleteMapping("/documentLinks/remove/{id}")
    public boolean deleteDocumentLink(@PathVariable String id) {
        this.dmDocumentLinkRepository.delete(Long.valueOf(id));
        return true;
    }
}



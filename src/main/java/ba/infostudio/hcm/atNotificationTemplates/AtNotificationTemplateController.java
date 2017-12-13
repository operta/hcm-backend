package ba.infostudio.hcm.atNotificationTemplates;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AtNotificationTemplateController {
    @Autowired
    private AtNotificationTemplateRepository atNotificationTemplateRepository;


    @RequestMapping("/notificationTemplates")
    public Iterable<AtNotificationTemplateModel> getAllNotificationTemplates(){
        return this.atNotificationTemplateRepository.findAll();
    }

    @PostMapping(value = "/notificationTemplates/add")
    public AtNotificationTemplateModel addNotificationTemplate(@RequestBody AtNotificationTemplateModel template) {
        return this.atNotificationTemplateRepository.save(template);
    }

    @PutMapping("/notificationTemplates")
    public AtNotificationTemplateModel updateNotificationTemplate(@RequestBody AtNotificationTemplateModel body) {
        AtNotificationTemplateModel q = atNotificationTemplateRepository.findOne(body.getId());
        q.setSubject(body.getSubject());
        q.setTemplate(body.getTemplate());
        q.setCode(body.getCode());
        return this.atNotificationTemplateRepository.save(q);
    }

    @DeleteMapping("/notificationTemplates/{id}")
    public boolean deleteNotificationTemplate(@PathVariable String id) {
        this.atNotificationTemplateRepository.delete(Long.valueOf(id));
        return true;
    }
}

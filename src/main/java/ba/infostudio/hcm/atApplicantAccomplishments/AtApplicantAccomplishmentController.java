package ba.infostudio.hcm.atApplicantAccomplishments;

import ba.infostudio.hcm.atApplicantContacts.IosApplicantContactRepository;
import ba.infostudio.hcm.atApplicantsSchools.AtApplicantSchoolModel;
import ba.infostudio.hcm.atApplicantsSchools.AtApplicantSchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AtApplicantAccomplishmentController {
    @Autowired
    private AtApplicantAccomplishmentRepository atApplicantAccomplishmentRepository;

    @Autowired
    private IosApplicantAccomplishmentRepository iosApplicantAccomplishmentRepository;

    @RequestMapping("/applicantAccomplishments")
    public Iterable<AtApplicantAccomplishmentModel> getAllApplicantAccomplishments() {
        return this.atApplicantAccomplishmentRepository.findAll();
    }

    @GetMapping("/applicantAccomplishments/{id}")
    @ResponseBody
    public Iterable<AtApplicantAccomplishmentModel> getApplicantAccomplishment(@PathVariable String id) {
        return this.atApplicantAccomplishmentRepository.findByIdApplicant_id(Long.valueOf(id));
    }

    @GetMapping("/applicantAccomplishments/nojsog/{id}")
    @ResponseBody
    public Iterable<IosApplicantAccomplishmentModel> getApplicantAccomplishmentWithoutJsog(@PathVariable String id) {
        return this.iosApplicantAccomplishmentRepository.findByIdApplicant_Id(Long.valueOf(id));
    }

    @PostMapping(value = "/applicantAccomplishments/add")
    public AtApplicantAccomplishmentModel addApplicantAccomplishment(@RequestBody AtApplicantAccomplishmentModel atApplicantAccomplishmentModel) {
        return this.atApplicantAccomplishmentRepository.save(atApplicantAccomplishmentModel);
    }

    @PutMapping("/applicantAccomplishments")
    public AtApplicantAccomplishmentModel updateApplicantAccomplishment(@RequestBody AtApplicantAccomplishmentModel body) {
        AtApplicantAccomplishmentModel accomplishment = atApplicantAccomplishmentRepository.findOne(body.getId());
        accomplishment.setTitle(body.getTitle());
        accomplishment.setDescription(body.getDescription());
        accomplishment.setAssociation(body.getAssociation());
        accomplishment.setOngoing(body.getOngoing());
        accomplishment.setLink(body.getLink());
        accomplishment.setDate_from(body.getDate_from());
        accomplishment.setDate_to(body.getDate_to());
        accomplishment.setProficiency(body.getProficiency());
        accomplishment.setLicence_number(body.getLicence_number());
        accomplishment.setOccupation(body.getOccupation());
        return this.atApplicantAccomplishmentRepository.save(accomplishment);
    }

    @DeleteMapping("/applicantAccomplishments/remove/{id}")
    public boolean deleteApplicantAccomplishment(@PathVariable String id) {
        this.atApplicantAccomplishmentRepository.delete(Long.valueOf(id));
        return true;
    }
}

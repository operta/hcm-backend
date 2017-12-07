package ba.infostudio.hcm.atApplicantContacts;

import ba.infostudio.hcm.atApplicantDocuments.AtApplicantDocumentModel;
import org.springframework.data.repository.CrudRepository;

public interface AtApplicantContactRepository  extends CrudRepository<AtApplicantContactModel, Long> {
    Iterable<AtApplicantContactModel> findByIdApplicant_id(Long id);
}


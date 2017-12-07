package ba.infostudio.hcm.atApplicantDocuments;

import org.springframework.data.repository.CrudRepository;

public interface AtApplicantDocumentRepository  extends CrudRepository<AtApplicantDocumentModel, Long> {
    Iterable<AtApplicantDocumentModel> findByIdApplicant_id(Long id);
}

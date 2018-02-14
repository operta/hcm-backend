package ba.infostudio.hcm.atApplicantDocuments;

import org.springframework.data.repository.CrudRepository;

public interface IosApplicantDocumentRepository extends CrudRepository<IosApplicantDocumentModel, Long> {
    Iterable<IosApplicantDocumentModel> findByIdApplicant_id(Long id);
}
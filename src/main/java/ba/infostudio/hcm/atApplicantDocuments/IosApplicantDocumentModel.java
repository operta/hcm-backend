package ba.infostudio.hcm.atApplicantDocuments;

import ba.infostudio.hcm.atApplicants.AtApplicantModel;
import ba.infostudio.hcm.dmDocumentLinks.DmDocumentLinkModel;
import ba.infostudio.hcm.dmDocumentTypes.DmDocumentTypeModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Table(name="AT_APPLICANTS_DOCUMENTS")
public class IosApplicantDocumentModel {
    @Id
    @SequenceGenerator(name="OID", sequenceName="OID", allocationSize=1)
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="OID")
    private Long id;

    @OneToOne
    @JoinColumn(name = "ID_DOCUMENT_LINK")
    private DmDocumentLinkModel id_document_link;

    @OneToOne
    @JsonIgnore
    @JoinColumn(name = "ID_APPLICANT")
    private AtApplicantModel idApplicant;

    @OneToOne
    @JoinColumn(name = "ID_DOCUMENT_TYPE")
    private DmDocumentTypeModel id_document_type;

    private String name;
    private String description;
    private Date valid_from;
    private Date valid_to;
    private String created_by;
    private Timestamp created_at;
    private String updated_by;
    private Timestamp updated_at;

    public IosApplicantDocumentModel(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DmDocumentLinkModel getId_document_link() {
        return id_document_link;
    }

    public void setId_document_link(DmDocumentLinkModel id_document_link) {
        this.id_document_link = id_document_link;
    }

    public AtApplicantModel getIdApplicant() {
        return idApplicant;
    }

    public void setIdApplicant(AtApplicantModel idApplicant) {
        this.idApplicant = idApplicant;
    }

    public DmDocumentTypeModel getId_document_type() {
        return id_document_type;
    }

    public void setId_document_type(DmDocumentTypeModel id_document_type) {
        this.id_document_type = id_document_type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getValid_from() {
        return valid_from;
    }

    public void setValid_from(Date valid_from) {
        this.valid_from = valid_from;
    }

    public Date getValid_to() {
        return valid_to;
    }

    public void setValid_to(Date valid_to) {
        this.valid_to = valid_to;
    }

    public String getCreated_by() {
        return created_by;
    }

    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_by() {
        return updated_by;
    }

    public void setUpdated_by(String updated_by) {
        this.updated_by = updated_by;
    }

    public Timestamp getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Timestamp updated_at) {
        this.updated_at = updated_at;
    }

    public IosApplicantDocumentModel(DmDocumentLinkModel id_document_link, AtApplicantModel idApplicant, DmDocumentTypeModel id_document_type, String name, String description, Date valid_from, Date valid_to, String created_by, Timestamp created_at, String updated_by, Timestamp updated_at) {
        this.id_document_link = id_document_link;
        this.idApplicant = idApplicant;
        this.id_document_type = id_document_type;
        this.name = name;
        this.description = description;
        this.valid_from = valid_from;
        this.valid_to = valid_to;
        this.created_by = created_by;
        this.created_at = created_at;
        this.updated_by = updated_by;
        this.updated_at = updated_at;
    }
}

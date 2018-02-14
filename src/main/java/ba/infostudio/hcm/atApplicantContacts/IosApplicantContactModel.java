package ba.infostudio.hcm.atApplicantContacts;


import ba.infostudio.hcm.atApplicants.AtApplicantModel;
import ba.infostudio.hcm.rgContactTypes.RgContactTypeModel;
import ba.infostudio.hcm.rgSkillGrades.RgSkillGrade;
import ba.infostudio.hcm.rgSkils.RgSkill;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Table(name = "AT_APPLICANTS_CONTACTS")
public class IosApplicantContactModel {
    @Id
    @SequenceGenerator(name="OID", sequenceName="OID", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="OID")
    private Long id;

    @OneToOne
    @JsonIgnore
    @JoinColumn(name = "ID_APPLICANT")
    private AtApplicantModel idApplicant;

    @OneToOne
    @JoinColumn(name = "ID_CONTACT_TYPE")
    private RgContactTypeModel id_contact_type;

    private String contact;
    private String description;
    private String created_by;
    private Timestamp created_at;
    private String updated_by;
    private Timestamp updated_at;

    public IosApplicantContactModel(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AtApplicantModel getIdApplicant() {
        return idApplicant;
    }

    public void setIdApplicant(AtApplicantModel idApplicant) {
        this.idApplicant = idApplicant;
    }

    public RgContactTypeModel getId_contact_type() {
        return id_contact_type;
    }

    public void setId_contact_type(RgContactTypeModel id_contact_type) {
        this.id_contact_type = id_contact_type;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public IosApplicantContactModel(AtApplicantModel idApplicant, RgContactTypeModel id_contact_type, String contact, String description, String created_by, Timestamp created_at, String updated_by, Timestamp updated_at) {
        this.idApplicant = idApplicant;
        this.id_contact_type = id_contact_type;
        this.contact = contact;
        this.description = description;
        this.created_by = created_by;
        this.created_at = created_at;
        this.updated_by = updated_by;
        this.updated_at = updated_at;
    }
}



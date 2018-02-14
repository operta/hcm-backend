package ba.infostudio.hcm.atApplicantAccomplishments;

import ba.infostudio.hcm.atAccomplishmentTypes.AtAccomplishmentTypesModel;
import ba.infostudio.hcm.atApplicants.AtApplicantModel;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Table(name="AT_APPLICANT_ACCOMPLISHMENTS")
public class IosApplicantAccomplishmentModel {
    @Id
    @SequenceGenerator(name="OID", sequenceName="OID", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="OID")
    private Long id;

    @OneToOne
    @JsonIgnore
    @JoinColumn(name = "ID_APPLICANT")
    private AtApplicantModel idApplicant;

    @OneToOne
    @JoinColumn(name = "ID_ACCOMPLISHMENT_TYPE")
    private AtAccomplishmentTypesModel id_accomplishment_type;
    private String title;
    private String description;
    private String location;
    private String association;
    private String ongoing;
    private String link;
    private Date date_from;
    private Date date_to;
    private String proficiency;
    private String occupation;
    private String licence_number;
    private String created_by;
    private Timestamp created_at;
    private String updated_by;
    private Timestamp updated_at;

    public IosApplicantAccomplishmentModel(){}

    public IosApplicantAccomplishmentModel(AtApplicantModel idApplicant, AtAccomplishmentTypesModel id_accomplishment_type, String title, String description, String location, String association, String ongoing, String link, Date date_from, Date date_to, String proficiency, String occupation, String licence_number, String created_by, Timestamp created_at, String updated_by, Timestamp updated_at) {
        this.idApplicant = idApplicant;
        this.id_accomplishment_type = id_accomplishment_type;
        this.title = title;
        this.description = description;
        this.location = location;
        this.association = association;
        this.ongoing = ongoing;
        this.link = link;
        this.date_from = date_from;
        this.date_to = date_to;
        this.proficiency = proficiency;
        this.occupation = occupation;
        this.licence_number = licence_number;
        this.created_by = created_by;
        this.created_at = created_at;
        this.updated_by = updated_by;
        this.updated_at = updated_at;
    }

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

    public AtAccomplishmentTypesModel getId_accomplishment_type() {
        return id_accomplishment_type;
    }

    public void setId_accomplishment_type(AtAccomplishmentTypesModel id_accomplishment_type) {
        this.id_accomplishment_type = id_accomplishment_type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getAssociation() {
        return association;
    }

    public void setAssociation(String association) {
        this.association = association;
    }

    public String getOngoing() {
        return ongoing;
    }

    public void setOngoing(String ongoing) {
        this.ongoing = ongoing;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Date getDate_from() {
        return date_from;
    }

    public void setDate_from(Date date_from) {
        this.date_from = date_from;
    }

    public Date getDate_to() {
        return date_to;
    }

    public void setDate_to(Date date_to) {
        this.date_to = date_to;
    }

    public String getProficiency() {
        return proficiency;
    }

    public void setProficiency(String proficiency) {
        this.proficiency = proficiency;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getLicence_number() {
        return licence_number;
    }

    public void setLicence_number(String licence_number) {
        this.licence_number = licence_number;
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
}


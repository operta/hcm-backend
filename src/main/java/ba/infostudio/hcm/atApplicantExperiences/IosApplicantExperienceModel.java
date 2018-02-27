package ba.infostudio.hcm.atApplicantExperiences;

import ba.infostudio.hcm.atAccomplishmentTypes.AtAccomplishmentTypesModel;
import ba.infostudio.hcm.atApplicants.AtApplicantModel;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Table(name="AT_APPLICANT_EXPERIENCES")
public class IosApplicantExperienceModel {
    @Id
    @SequenceGenerator(name="OID", sequenceName="OID", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="OID")
    private Long id;

    @OneToOne
    @JsonIgnore
    @JoinColumn(name = "ID_APPLICANT")
    private AtApplicantModel idApplicant;

    private String company;
    private String position;
    private String location;
    private String ongoing;
    private Date date_from;
    private Date date_to;
    private String created_by;
    private Timestamp created_at;
    private String updated_by;
    private Timestamp updated_at;

    public IosApplicantExperienceModel(){}

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

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getOngoing() {
        return ongoing;
    }

    public void setOngoing(String ongoing) {
        this.ongoing = ongoing;
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

    public IosApplicantExperienceModel(AtApplicantModel idApplicant, String company, String position, String location, String ongoing, Date date_from, Date date_to, String created_by, Timestamp created_at, String updated_by, Timestamp updated_at) {
        this.idApplicant = idApplicant;
        this.company = company;
        this.position = position;
        this.location = location;
        this.ongoing = ongoing;
        this.date_from = date_from;
        this.date_to = date_to;
        this.created_by = created_by;
        this.created_at = created_at;
        this.updated_by = updated_by;
        this.updated_at = updated_at;
    }
}


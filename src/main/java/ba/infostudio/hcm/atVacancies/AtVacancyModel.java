package ba.infostudio.hcm.atVacancies;

import ba.infostudio.hcm.atJobApplications.AtJobApplicationModel;
import ba.infostudio.hcm.atVacancyStatus.AtVacancyStatusModel;
import ba.infostudio.hcm.ogWorkPlaces.OgWorkPlacesModel;
import ba.infostudio.hcm.rgRegions.RgRegionsModel;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.voodoodyne.jackson.jsog.JSOGGenerator;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;

/*@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
/*
@JsonIdentityInfo(generator = ObjectIdGenerators.UUIDGenerator.class, property="@UUID")
*/
@JsonIdentityInfo(generator=JSOGGenerator.class)
@Entity
@Table(name = "AT_VACANCIES")
public class AtVacancyModel {
    @Id
    @SequenceGenerator(name="OID", sequenceName="OID", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="OID")
    private Long id;
    private String code;
    private String name;
    private String description;

    @OneToOne
    @JoinColumn(name = "ID_LOCATION")
    private RgRegionsModel idLocation;

    @Column(name = "date_from")
    private Date dateFrom;

    @Column(name = "date_to")
    private Date dateTo;

/*    @ManyToOne
    @JoinColumn(name = "ID_WORK_PLACE")
    private OgWorkPlacesModel id_work_place;*/
    private String created_by;
    private Timestamp created_at;
    private String updated_by;
    private Timestamp updated_at;


    @OneToMany(mappedBy = "vacancyid", cascade = CascadeType.ALL)
    private Collection<AtJobApplicationModel> jobApplications;

    @ManyToOne
    @JoinColumn(name = "STATUS")
    private AtVacancyStatusModel status;

    private String job_role;
    private String job_working_time;
    private String skills_requirement;
    private String language_requirement;
    private String education_requirement;
    private String experience_requirement;

    public AtVacancyModel() {
    }

    public AtVacancyModel(String code, String name, String description, RgRegionsModel idLocation, Date dateFrom, Date dateTo, String created_by, Timestamp created_at, String updated_by, Timestamp updated_at, Collection<AtJobApplicationModel> jobApplications, AtVacancyStatusModel status, String job_role, String job_working_time, String skills_requirement, String language_requirement, String education_requirement, String experience_requirement) {
        this.code = code;
        this.name = name;
        this.description = description;
        this.idLocation = idLocation;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.created_by = created_by;
        this.created_at = created_at;
        this.updated_by = updated_by;
        this.updated_at = updated_at;
        this.jobApplications = jobApplications;
        this.status = status;
        this.job_role = job_role;
        this.job_working_time = job_working_time;
        this.skills_requirement = skills_requirement;
        this.language_requirement = language_requirement;
        this.education_requirement = education_requirement;
        this.experience_requirement = experience_requirement;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public RgRegionsModel getId_location() {
        return idLocation;
    }

    public void setId_location(RgRegionsModel idLocation) {
        this.idLocation = idLocation;
    }

    public Date getDate_from() {
        return dateFrom;
    }

    public void setDate_from(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public Date getDate_to() {
        return dateTo;
    }

    public void setDate_to(Date dateTo) {
        this.dateTo = dateTo;
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

    public Collection<AtJobApplicationModel> getJobApplications() {
        return jobApplications;
    }

    public void setJobApplications(Collection<AtJobApplicationModel> jobApplications) {
        this.jobApplications = jobApplications;
    }

    public AtVacancyStatusModel getStatus() {
        return status;
    }

    public void setStatus(AtVacancyStatusModel status) {
        this.status = status;
    }

    public String getJob_role() {
        return job_role;
    }

    public void setJob_role(String job_role) {
        this.job_role = job_role;
    }

    public String getJob_working_time() {
        return job_working_time;
    }

    public void setJob_working_time(String job_working_time) {
        this.job_working_time = job_working_time;
    }

    public String getSkills_requirement() {
        return skills_requirement;
    }

    public void setSkills_requirement(String skills_requirement) {
        this.skills_requirement = skills_requirement;
    }

    public String getLanguage_requirement() {
        return language_requirement;
    }

    public void setLanguage_requirement(String language_requirement) {
        this.language_requirement = language_requirement;
    }

    public String getEducation_requirement() {
        return education_requirement;
    }

    public void setEducation_requirement(String education_requirement) {
        this.education_requirement = education_requirement;
    }

    public String getExperience_requirement() {
        return experience_requirement;
    }

    public void setExperience_requirement(String experience_requirement) {
        this.experience_requirement = experience_requirement;
    }
}

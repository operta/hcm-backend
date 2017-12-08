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
    private RgRegionsModel id_location;

    private Date date_from;
    private Date date_to;

    @ManyToOne
    @JoinColumn(name = "ID_WORK_PLACE")
    private OgWorkPlacesModel id_work_place;
    private String created_by;
    private Timestamp created_at;
    private String updated_by;
    private Timestamp updated_at;


    @OneToMany(mappedBy = "vacancyid", cascade = CascadeType.ALL)
    private Collection<AtJobApplicationModel> jobApplications;

    @ManyToOne
    @JoinColumn(name = "STATUS")
    private AtVacancyStatusModel status;

    public AtVacancyModel() {
    }

    public AtVacancyModel(String code, String name, String description, RgRegionsModel id_location, Date date_from, Date date_to, OgWorkPlacesModel id_work_place, String created_by, Timestamp created_at, String updated_by, Timestamp updated_at, Collection<AtJobApplicationModel> jobApplications, AtVacancyStatusModel status) {
        this.code = code;
        this.name = name;
        this.description = description;
        this.id_location = id_location;
        this.date_from = date_from;
        this.date_to = date_to;
        this.id_work_place = id_work_place;
        this.created_by = created_by;
        this.created_at = created_at;
        this.updated_by = updated_by;
        this.updated_at = updated_at;
        this.jobApplications = jobApplications;
        this.status = status;
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
        return id_location;
    }

    public void setId_location(RgRegionsModel id_location) {
        this.id_location = id_location;
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

    public OgWorkPlacesModel getId_work_place() {
        return id_work_place;
    }

    public void setId_work_place(OgWorkPlacesModel id_work_place) {
        this.id_work_place = id_work_place;
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

    @Override
    public String toString() {
        return "AtVacancyModel{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", id_location=" + id_location +
                ", date_from=" + date_from +
                ", date_to=" + date_to +
                ", id_work_place=" + id_work_place +
                ", created_by='" + created_by + '\'' +
                ", created_at=" + created_at +
                ", updated_by='" + updated_by + '\'' +
                ", updated_at=" + updated_at +
                '}';
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
}

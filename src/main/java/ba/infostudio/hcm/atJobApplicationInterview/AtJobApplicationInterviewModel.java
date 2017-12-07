package ba.infostudio.hcm.atJobApplicationInterview;

import ba.infostudio.hcm.atJobApplications.AtJobApplicationModel;
import ba.infostudio.hcm.rgRegions.RgRegionsModel;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Table(name = "AT_JOB_APPLICATIONS_INTERVIEWS")
public class AtJobApplicationInterviewModel {
    @Id
    @SequenceGenerator(name="OID", sequenceName="OID", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="OID")
    private Long id;
    private Long grade;
    private String description;
    private String created_by;
    private Timestamp created_at;
    private String updated_by;
    private Timestamp updated_at;
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "JOB_APPLICATION_ID")
    private AtJobApplicationModel job_application_id;
    @ManyToOne
    @JoinColumn(name = "LOCATION_ID")
    private RgRegionsModel location_id;


    private Date interview_date;

    public AtJobApplicationInterviewModel() {
    }

    public AtJobApplicationInterviewModel(Long grade, String description, String created_by, Timestamp created_at, String updated_by, Timestamp updated_at, AtJobApplicationModel job_application_id, RgRegionsModel location_id, Date interview_date) {
        this.grade = grade;
        this.description = description;
        this.created_by = created_by;
        this.created_at = created_at;
        this.updated_by = updated_by;
        this.updated_at = updated_at;
        this.job_application_id = job_application_id;
        this.location_id = location_id;
        this.interview_date = interview_date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getGrade() {
        return grade;
    }

    public void setGrade(Long grade) {
        this.grade = grade;
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

    public AtJobApplicationModel getJob_application_id() {
        return job_application_id;
    }

    public void setJob_application_id(AtJobApplicationModel job_application_id) {
        this.job_application_id = job_application_id;
    }

    public Date getInterview_date() {
        return interview_date;
    }

    public void setInterview_date(Date interview_date) {
        this.interview_date = interview_date;
    }

    public RgRegionsModel getLocation_id() {
        return location_id;
    }

    public void setLocation_id(RgRegionsModel location_id) {
        this.location_id = location_id;
    }
}

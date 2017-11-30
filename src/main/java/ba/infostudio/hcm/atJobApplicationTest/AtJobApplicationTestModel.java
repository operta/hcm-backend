package ba.infostudio.hcm.atJobApplicationTest;

import ba.infostudio.hcm.atJobApplications.AtJobApplicationModel;
import ba.infostudio.hcm.rgRegions.RgRegionsModel;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.voodoodyne.jackson.jsog.JSOGGenerator;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Table(name = "AT_JOB_APPLICATION_TEST")
public class AtJobApplicationTestModel {
    @Id
    private Long id;
    private Long score;
    private String created_by;
    private Timestamp created_at;
    private String updated_by;
    private Timestamp updated_at;
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "JOB_APPLICATION_ID")
    private AtJobApplicationModel job_application_id;

    private Date test_date;

    @OneToOne
    @JoinColumn(name = "LOCATION_ID")
    private RgRegionsModel location_id;

    public AtJobApplicationTestModel() {
    }

    public AtJobApplicationTestModel(Long id, Long score, String created_by, Timestamp created_at, String updated_by, Timestamp updated_at, AtJobApplicationModel job_application_id, Date test_date, RgRegionsModel location_id) {
        this.id = id;
        this.score = score;
        this.created_by = created_by;
        this.created_at = created_at;
        this.updated_by = updated_by;
        this.updated_at = updated_at;
        this.job_application_id = job_application_id;
        this.test_date = test_date;
        this.location_id = location_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getScore() {
        return score;
    }

    public void setScore(Long score) {
        this.score = score;
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

    public RgRegionsModel getLocation_id() {
        return location_id;
    }

    public void setLocation_id(RgRegionsModel location_id) {
        this.location_id = location_id;
    }

    public Date getTest_date() {
        return test_date;
    }

    public void setTest_date(Date test_date) {
        this.test_date = test_date;
    }
}

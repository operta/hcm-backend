package ba.infostudio.hcm.atJobApplicationStatus;

import ba.infostudio.hcm.atJobApplications.AtJobApplicationModel;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name = "AT_JOB_APPLICATION_STATUSES")
public class AtJobApplicationStatusModel {
    @Id
    @SequenceGenerator(name="OID", sequenceName="OID", allocationSize=1)
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="OID")
    private Long id;
    private String code;
    private String name;
    private String description;
    private String created_by;
    private Date created_at;
    private String updated_by;
    private Date updated_at;

    @OneToMany(mappedBy = "id_status")
    private Collection<AtJobApplicationModel> jobApplications;

    public AtJobApplicationStatusModel() {
    }

    public AtJobApplicationStatusModel(String code, String name, String description, String created_by, Date created_at, String updated_by, Date updated_at, Collection<AtJobApplicationModel> jobApplications) {
        this.code = code;
        this.name = name;
        this.description = description;
        this.created_by = created_by;
        this.created_at = created_at;
        this.updated_by = updated_by;
        this.updated_at = updated_at;
        this.jobApplications = jobApplications;
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

    public String getCreated_by() {
        return created_by;
    }

    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_by() {
        return updated_by;
    }

    public void setUpdated_by(String updated_by) {
        this.updated_by = updated_by;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

    public Collection<AtJobApplicationModel> getJobApplications() {
        return jobApplications;
    }

    public void setJobApplications(Collection<AtJobApplicationModel> jobApplications) {
        this.jobApplications = jobApplications;
    }
}

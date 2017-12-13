package ba.infostudio.hcm.atJobApplicationHistory;

import ba.infostudio.hcm.atJobApplicationStatus.AtJobApplicationStatusModel;
import ba.infostudio.hcm.atJobApplications.AtJobApplicationModel;
import ba.infostudio.hcm.rgRegions.RgRegionsModel;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "AT_JOB_APPLICATION_HISTORY")
public class AtJobApplicationHistoryModel {
    @Id
    @SequenceGenerator(name="OID", sequenceName="OID", allocationSize=1)
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="OID")
    private Long id;


    @OneToOne
    @JoinColumn(name = "ID_JOB_APPLICATION")
    private AtJobApplicationModel idJobApplication;

    @OneToOne
    @JoinColumn(name = "ID_STATUS_FROM")
    private AtJobApplicationStatusModel id_status_from;

    @OneToOne
    @JoinColumn(name = "ID_STATUS_TO")
    private AtJobApplicationStatusModel id_status_to;

    private String created_by;
    private Date created_at;
    private String updated_by;
    private Date updated_at;

    public AtJobApplicationHistoryModel() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AtJobApplicationModel getIdJobApplication() {
        return idJobApplication;
    }

    public void setIdJobApplication(AtJobApplicationModel idJobApplication) {
        this.idJobApplication = idJobApplication;
    }

    public AtJobApplicationStatusModel getId_status_from() {
        return id_status_from;
    }

    public void setId_status_from(AtJobApplicationStatusModel id_status_from) {
        this.id_status_from = id_status_from;
    }

    public AtJobApplicationStatusModel getId_status_to() {
        return id_status_to;
    }

    public void setId_status_to(AtJobApplicationStatusModel id_status_to) {
        this.id_status_to = id_status_to;
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

    public AtJobApplicationHistoryModel(AtJobApplicationModel idJobApplication, AtJobApplicationStatusModel id_status_from, AtJobApplicationStatusModel id_status_to, String created_by, Date created_at, String updated_by, Date updated_at) {
        this.idJobApplication = idJobApplication;
        this.id_status_from = id_status_from;
        this.id_status_to = id_status_to;
        this.created_by = created_by;
        this.created_at = created_at;
        this.updated_by = updated_by;
        this.updated_at = updated_at;
    }
}




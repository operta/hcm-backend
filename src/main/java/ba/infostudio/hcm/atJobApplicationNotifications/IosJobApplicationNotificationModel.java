package ba.infostudio.hcm.atJobApplicationNotifications;

import ba.infostudio.hcm.atJobApplications.AtJobApplicationMModel;
import ba.infostudio.hcm.atNotificationTemplates.AtNotificationTemplateModel;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "AT_JOB_APP_NOTIFICATIONS")
public class IosJobApplicationNotificationModel {
    @Id
    @SequenceGenerator(name="OID", sequenceName="OID", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="OID")
    private Long id;

    @OneToOne
    @JoinColumn(name = "ID_JOB_APPLICATION")
    private AtJobApplicationMModel idJobApplication;

    @OneToOne
    @JoinColumn(name = "ID_NOTIFICATION")
    private AtNotificationTemplateModel id_notification;
    private Timestamp dateSent;
    private String is_active;
    private String created_by;
    private Timestamp created_at;
    private String updated_by;
    private Timestamp updated_at;

    public IosJobApplicationNotificationModel() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AtJobApplicationMModel getIdJobApplication() {
        return idJobApplication;
    }

    public void setIdJobApplication(AtJobApplicationMModel idJobApplication) {
        this.idJobApplication = idJobApplication;
    }

    public AtNotificationTemplateModel getId_notification() {
        return id_notification;
    }

    public void setId_notification(AtNotificationTemplateModel id_notification) {
        this.id_notification = id_notification;
    }

    public Timestamp getDateSent() {
        return dateSent;
    }

    public void setDateSent(Timestamp dateSent) {
        this.dateSent = dateSent;
    }

    public String getIs_active() {
        return is_active;
    }

    public void setIs_active(String is_active) {
        this.is_active = is_active;
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

    public IosJobApplicationNotificationModel(AtJobApplicationMModel idJobApplication, AtNotificationTemplateModel id_notification, Timestamp dateSent, String is_active, String created_by, Timestamp created_at, String updated_by, Timestamp updated_at) {
        this.idJobApplication = idJobApplication;
        this.id_notification = id_notification;
        this.dateSent = dateSent;
        this.is_active = is_active;
        this.created_by = created_by;
        this.created_at = created_at;
        this.updated_by = updated_by;
        this.updated_at = updated_at;
    }
}

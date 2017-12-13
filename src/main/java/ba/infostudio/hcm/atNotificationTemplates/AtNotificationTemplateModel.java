package ba.infostudio.hcm.atNotificationTemplates;

import javax.persistence.*;
import java.sql.Clob;
import java.sql.Timestamp;

@Entity
@Table(name = "AT_NOTIFICATION_TEMPLATES")
public class AtNotificationTemplateModel {
    @Id
    @SequenceGenerator(name = "OID", sequenceName = "OID", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "OID")
    private Long id;
    private String code;
    private String subject;
    private String template;
    private String created_by;
    private Timestamp created_at;
    private String updated_by;
    private Timestamp updated_at;

    public AtNotificationTemplateModel() {
    }

    public AtNotificationTemplateModel(String code, String subject, String template, String created_by, Timestamp created_at, String updated_by, Timestamp updated_at) {
        this.code = code;
        this.subject = subject;
        this.template = template;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
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

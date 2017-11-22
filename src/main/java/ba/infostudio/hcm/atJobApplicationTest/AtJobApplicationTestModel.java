package ba.infostudio.hcm.atJobApplicationTest;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
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

    public AtJobApplicationTestModel() {
    }

    public AtJobApplicationTestModel(Long id, Long score, String created_by, Timestamp created_at, String updated_by, Timestamp updated_at) {
        this.id = id;
        this.score = score;
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
}

package ba.infostudio.hcm.atJobApplicationInterview;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "AT_JOB_APPLICATION_INTERVIEW")
public class AtJobApplicationInterviewModel {
    @Id
    private Long id;
    private Long grade;
    private String description;

    public AtJobApplicationInterviewModel() {
    }

    public AtJobApplicationInterviewModel(Long id, Long grade, String description) {
        this.id = id;
        this.grade = grade;
        this.description = description;
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
}

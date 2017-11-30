package ba.infostudio.hcm.atJobApplications;

import ba.infostudio.hcm.atApplicants.AtApplicantModel;
import ba.infostudio.hcm.atJobApplicationInterview.AtJobApplicationInterviewModel;
import ba.infostudio.hcm.atJobApplicationTest.AtJobApplicationTestModel;
import ba.infostudio.hcm.atVacancies.AtVacancyModel;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.voodoodyne.jackson.jsog.JSOGGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Collection;


/*@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@JsonIdentityInfo(generator = ObjectIdGenerators.UUIDGenerator.class, property="@UUID")*/
@JsonIdentityInfo(generator=JSOGGenerator.class)
@Entity
@Table(name = "AT_JOB_APPLICATIONS")
public class AtJobApplicationModel implements Serializable {
    @Id
    @SequenceGenerator(name="OID", sequenceName="OID", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="OID")
    private Long id;

    @ManyToOne
    @JoinColumn(name="ID_APPLICANT")
    private AtApplicantModel id_applicant;


    @ManyToOne
    @JoinColumn(name = "ID_VACANCIES")
    private AtVacancyModel id_vacancies;
    private Long id_status;
    private Long grade;
    private String review;
    private Date date_applied;
    private String created_by;
    private Timestamp created_at;
    private String updated_by;
    private Timestamp updated_at;
    private Long interview_grade;
    private Long test_grade;

    @OneToMany(mappedBy = "job_application_id")
    private Collection<AtJobApplicationTestModel> test;
    @OneToMany(mappedBy = "job_application_id")
    private Collection<AtJobApplicationInterviewModel> interview;

    public AtJobApplicationModel() {
    }

    public AtJobApplicationModel(AtApplicantModel id_applicant, AtVacancyModel id_vacancies, Long id_status, Long grade, String review, Date date_applied, String created_by, Timestamp created_at, String updated_by, Timestamp updated_at, Long interview_grade, Long test_grade, Collection<AtJobApplicationTestModel> test, Collection<AtJobApplicationInterviewModel> interview) {
        this.id_applicant = id_applicant;
        this.id_vacancies = id_vacancies;
        this.id_status = id_status;
        this.grade = grade;
        this.review = review;
        this.date_applied = date_applied;
        this.created_by = created_by;
        this.created_at = created_at;
        this.updated_by = updated_by;
        this.updated_at = updated_at;
        this.interview_grade = interview_grade;
        this.test_grade = test_grade;
        this.test = test;
        this.interview = interview;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AtApplicantModel getId_applicant() {
        return id_applicant;
    }

    public void setId_applicant(AtApplicantModel id_applicant) {
        this.id_applicant = id_applicant;
    }

    public AtVacancyModel getId_vacancies() {
        return id_vacancies;
    }

    public void setId_vacancies(AtVacancyModel id_vacancies) {
        this.id_vacancies = id_vacancies;
    }

    public Long getId_status() {
        return id_status;
    }

    public void setId_status(Long id_status) {
        this.id_status = id_status;
    }

    public Long getGrade() {
        return grade;
    }

    public void setGrade(Long grade) {
        this.grade = grade;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public Date getDate_applied() {
        return date_applied;
    }

    public void setDate_applied(Date date_applied) {
        this.date_applied = date_applied;
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

    public Collection<AtJobApplicationInterviewModel> getInterview() {
        return interview;
    }

    public void setInterview(Collection<AtJobApplicationInterviewModel> interview) {
        this.interview = interview;
    }

    public Collection<AtJobApplicationTestModel> getTest() {
        return test;
    }

    public void setTest(Collection<AtJobApplicationTestModel> test) {
        this.test = test;
    }

    public Long getTest_grade() {
        return test_grade;
    }

    public void setTest_grade(Long test_grade) {
        this.test_grade = test_grade;
    }

    public Long getInterview_grade() {
        return interview_grade;
    }

    public void setInterview_grade(Long interview_grade) {
        this.interview_grade = interview_grade;
    }
}

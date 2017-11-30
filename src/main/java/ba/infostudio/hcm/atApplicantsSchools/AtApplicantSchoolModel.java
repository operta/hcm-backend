package ba.infostudio.hcm.atApplicantsSchools;

import ba.infostudio.hcm.atApplicants.AtApplicantModel;
import ba.infostudio.hcm.rgQualifications.RgQualificationsModel;
import ba.infostudio.hcm.rgSchools.RgSchoolsModel;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Table(name="AT_APPLICANTS_SCHOOLS")
public class AtApplicantSchoolModel {
    @Id
    @SequenceGenerator(name="OID", sequenceName="OID", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="OID")
    private Long id;

    @OneToOne
    @JoinColumn(name = "ID_SCHOOL")
    private RgSchoolsModel id_school;

    @OneToOne
    @JoinColumn(name = "ID_APPLICANT")
    private AtApplicantModel idApplicant;

    private String school;
    private Date date_from;
    private Date date_to;
    private String major;
    private String degree;

    @OneToOne
    @JoinColumn(name = "ID_QUALIFICATION")
    private RgQualificationsModel id_qualification;

    private int grade;
    private String description;
    private String link;
    private String created_by;
    private Timestamp created_at;
    private String updated_by;
    private Timestamp updated_at;

    public AtApplicantSchoolModel(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RgSchoolsModel getId_school() {
        return id_school;
    }

    public void setId_school(RgSchoolsModel id_school) {
        this.id_school = id_school;
    }

    public AtApplicantModel getIdApplicant() {
        return idApplicant;
    }

    public void setIdApplicant(AtApplicantModel idApplicant) {
        this.idApplicant = idApplicant;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
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

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public RgQualificationsModel getId_qualification() {
        return id_qualification;
    }

    public void setId_qualification(RgQualificationsModel id_qualification) {
        this.id_qualification = id_qualification;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
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

    public AtApplicantSchoolModel(RgSchoolsModel id_school, AtApplicantModel idApplicant, String school, Date date_from, Date date_to, String major, String degree, RgQualificationsModel id_qualification, int grade, String description, String link, String created_by, Timestamp created_at, String updated_by, Timestamp updated_at) {
        this.id_school = id_school;
        this.idApplicant = idApplicant;
        this.school = school;
        this.date_from = date_from;
        this.date_to = date_to;
        this.major = major;
        this.degree = degree;
        this.id_qualification = id_qualification;
        this.grade = grade;
        this.description = description;
        this.link = link;
        this.created_by = created_by;
        this.created_at = created_at;
        this.updated_by = updated_by;
        this.updated_at = updated_at;
    }
}

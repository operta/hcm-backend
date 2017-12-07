package ba.infostudio.hcm.atApplicantSkills;

import ba.infostudio.hcm.atApplicants.AtApplicantModel;
import ba.infostudio.hcm.rgSkillGrades.RgSkillGrade;
import ba.infostudio.hcm.rgSkils.RgSkill;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Table(name = "AT_APPLICANTS_SKILLS")
public class AtApplicantSkillModel {
    @Id
    @SequenceGenerator(name="OID", sequenceName="OID", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="OID")
    private Long id;

    @OneToOne
    @JoinColumn(name = "ID_APPLICANT")
    private AtApplicantModel idApplicant;

    @OneToOne
    @JoinColumn(name = "ID_SKILL")
    private RgSkill id_skill;

    @OneToOne
    @JoinColumn(name = "ID_GRADE")
    private RgSkillGrade id_grade;

    private String skill;
    private Date date_skill;
    private String created_by;
    private Timestamp created_at;
    private String updated_by;
    private Timestamp updated_at;

    public AtApplicantSkillModel(){}
    public AtApplicantSkillModel(AtApplicantModel idApplicant, RgSkill id_skill, RgSkillGrade id_grade, String skill, Date date_skill, String created_by, Timestamp created_at, String updated_by, Timestamp updated_at) {
        this.idApplicant = idApplicant;
        this.id_skill = id_skill;
        this.id_grade = id_grade;
        this.skill = skill;
        this.date_skill = date_skill;
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

    public AtApplicantModel getIdApplicant() {
        return idApplicant;
    }

    public void setIdApplicant(AtApplicantModel idApplicant) {
        this.idApplicant = idApplicant;
    }

    public RgSkill getId_skill() {
        return id_skill;
    }

    public void setId_skill(RgSkill id_skill) {
        this.id_skill = id_skill;
    }

    public RgSkillGrade getId_grade() {
        return id_grade;
    }

    public void setId_grade(RgSkillGrade id_grade) {
        this.id_grade = id_grade;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public Date getDate_skill() {
        return date_skill;
    }

    public void setDate_skill(Date date_skill) {
        this.date_skill = date_skill;
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



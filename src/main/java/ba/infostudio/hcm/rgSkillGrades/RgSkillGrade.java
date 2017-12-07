package ba.infostudio.hcm.rgSkillGrades;

import ba.infostudio.hcm.rgRegions.RgRegionsModel;
import ba.infostudio.hcm.rgSkils.RgSkill;

import java.lang.reflect.Field;
import java.sql.Timestamp;

import javax.persistence.*;

@Entity
@Table(name = "RG_SKILL_GRADES")
public class RgSkillGrade {

	@Id
	@SequenceGenerator(name = "OID", sequenceName = "OID", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "OID")
	private Long id;
	private String code;
	private String name;
	private String description;
	private Long grade;
	private String numerical;

	@OneToOne
	@JoinColumn(name = "ID_SKILL")
	private RgSkill idSkill;
	private String created_by;
	private Timestamp created_at;
	private String updated_by;
	private Timestamp updated_at;

	public RgSkillGrade() {
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

	public Long getGrade() {
		return grade;
	}

	public void setGrade(Long grade) {
		this.grade = grade;
	}

	public String getNumerical() {
		return numerical;
	}

	public void setNumerical(String numerical) {
		this.numerical = numerical;
	}

	public RgSkill getIdSkill() {
		return idSkill;
	}

	public void setIdSkill(RgSkill idSkill) {
		this.idSkill = idSkill;
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

	public RgSkillGrade(String code, String name, String description, Long grade, String numerical, RgSkill idSkill, String created_by, Timestamp created_at, String updated_by, Timestamp updated_at) {
		this.code = code;
		this.name = name;
		this.description = description;
		this.grade = grade;
		this.numerical = numerical;
		this.idSkill = idSkill;
		this.created_by = created_by;
		this.created_at = created_at;
		this.updated_by = updated_by;
		this.updated_at = updated_at;
	}

}

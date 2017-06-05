package ba.infostudio.hcm.rgSkillGrades;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import ba.infostudio.hcm.rgSkils.RgSkill;

@Entity
@Table(name = "RG_SKILL_GRADES")
public class RgSkillGrade {
	
	@Id
	private Long    id;//ID komentar SEQ OID
	private String  code;
	private String  name;
	private String  description;
	private Long    grade;
	private String  numerical;
	@JoinColumn(name="ID_SKILL")
	@ManyToOne
	private RgSkill rgSkill;
	
	public RgSkillGrade() {
	}
	
	public RgSkillGrade(Long id, String code, String name, String description, Long grade, String numerical,
			RgSkill rgSkill) {
		super();
		this.id = id;
		this.code = code;
		this.name = name;
		this.description = description;
		this.grade = grade;
		this.numerical = numerical;
		this.rgSkill = rgSkill;
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
	
	public RgSkill getRgSkill() {
		return rgSkill;
	}
	
	public void setRgSkill(RgSkill rgSkill) {
		this.rgSkill = rgSkill;
	}
}

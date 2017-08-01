package ba.infostudio.hcm.rgSkillGrades;

import java.lang.reflect.Field;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "RG_SKILL_GRADES")
public class RgSkillGrade {
	
	@Id
	@SequenceGenerator(name="OID", sequenceName="OID", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="OID")
	private Long    id;
	private String  code;
	private String  name;
	private String  description;
	private Long    grade;
	private String  numerical;
	private Long    idSkill;
	
	public RgSkillGrade() {
	}
	
	public RgSkillGrade(Long id, String code, String name, String description, Long grade, String numerical,
			Long idSkill) {
		super();
		this.id = id;
		this.code = code;
		this.name = name;
		this.description = description;
		this.grade = grade;
		this.numerical = numerical;
		this.idSkill = idSkill;
	}

	@Override
    public String toString() {
        String classValues = null;
        try {
            classValues = getClass().getName() + " [";
            Field[] fields = getClass().getDeclaredFields();
            for (int i = 0; i < fields.length; i++) {
                classValues = classValues + fields[i].getName() + "=";
                classValues = classValues + fields[i].get(this) + ", ";
            }
            classValues = classValues.substring(0, classValues.length() - 2);
            classValues = classValues + "]";
        }
        catch (Exception e) {
            classValues = super.toString();
        }
        return classValues;
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

	public Long getIdSkill() {
		return idSkill;
	}

	public void setIdSkill(Long idSkill) {
		this.idSkill = idSkill;
	}
}

package ba.infostudio.hcm.rgSkils;

import java.lang.reflect.Field;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "RG_SKILLS")
public class RgSkill {

	@Id
	@SequenceGenerator(name="OID", sequenceName="OID", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="OID")
	private Long   id;
	private String code;
	private String name;
	private String description;
	private String field;
	
	public RgSkill() {
	}

	public RgSkill(Long id, String code, String name, String description, String field) {
		super();
		this.id = id;
		this.code = code;
		this.name = name;
		this.description = description;
		this.field = field;
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

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}
}

package ba.infostudio.hcm.ogOrganizationalPartTypes;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "OG_ORGANIZATIONAL_PART_TYPES")
public class OgOrganizationalPartType {

	@Id
	private Long   id;
	private String code;
	private String name;
	private String description;
	
	public OgOrganizationalPartType() {
	}

	public OgOrganizationalPartType(Long id, String code, String name, String description, String field) {
		super();
		this.id = id;
		this.code = code;
		this.name = name;
		this.description = description;

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


}

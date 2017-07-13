package ba.infostudio.hcm.leLegalEntityTypes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity    
@Table(name = "LE_LEGAL_ENTITY_TYPES")   
public class LeLegalEntityType{

	@Id
	@Column(name="ID")
	private Long id;
	
	@Column(name="CODE")
	private String code;

	@Column(name="NAME")
	private String name;
	
	@Column(name="DESCRIPTION")
	private	String description;

	public LeLegalEntityType(){
		
	}
	
	
	public LeLegalEntityType(Long id, String code, String name, String description) {
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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("LeLegalEntityType [id=");
		builder.append(id);
		builder.append(", code=");
		builder.append(code);
		builder.append(", name=");
		builder.append(name);
		builder.append(", description=");
		builder.append(description);
		builder.append("]");
		return builder.toString();
	}
	


}

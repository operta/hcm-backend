package ba.infostudio.hcm.emRewardTypes;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "EM_REWARD_TYPES")

public class EmRewardType {
	
    @Id
	private long id;
	private String code;
	private String name;
	private String description;

	
	public EmRewardType() {
		
	}
	
	public EmRewardType(Long id, String code, String name, String description, String field) {
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

package gov.healthit.chpl.dto;

import gov.healthit.chpl.entity.TestFunctionalityEntity;

public class TestFunctionalityDTO {
	private Long id;
	private String name;
	private String category;
	
	public TestFunctionalityDTO(){}
	
	public TestFunctionalityDTO(TestFunctionalityEntity entity){		
		this.id = entity.getId();
		this.name = entity.getName();
		this.category = entity.getCategory();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
}

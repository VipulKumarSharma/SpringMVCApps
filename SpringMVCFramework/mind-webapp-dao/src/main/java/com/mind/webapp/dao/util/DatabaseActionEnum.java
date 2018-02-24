package com.mind.webapp.dao.util;

public enum DatabaseActionEnum {
	
	INSERT(1,"Insert","Insert a new record in Database"),
	UPDATE(2,"Update","Update a existing record in Database"),
	DELETE(3,"Delete","Delete a existing record from Database");
	
	private int id;
	private String name;
	private String description;
	
	DatabaseActionEnum(int id, String name, String decsription){
		this.id = id;
		this.name = name;
		this.description = description;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

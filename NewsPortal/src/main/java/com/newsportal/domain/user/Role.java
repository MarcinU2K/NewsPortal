package com.newsportal.domain.user;
public class Role {
	
    private String name;
	
	public Role() {
	}
	
	public Role(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
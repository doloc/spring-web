package com.doloc.aopdemo;

public class Account {
	
	private String name;
	private String level;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getLevel() {
		return level;
	}
	
	public void setLevel(String level) {
		this.level = level;
	}

	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Account(String name, String level) {
		this.name = name;
		this.level = level;
	}
	
}

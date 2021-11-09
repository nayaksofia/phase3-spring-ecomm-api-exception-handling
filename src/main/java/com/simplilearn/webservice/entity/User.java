package com.simplilearn.webservice.entity;

public class User {
	
	//Writing multiple properties
	
	private int id;
	
	private String name;
	
	private String city;
	
	private String state;

	
	//Parameterised constructor
	public User(int id, String name, String city, String state) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
		this.state = state;
	}


	//Non-parametrised constructor
	public User() {
		
	}

	//Generate Getter and Setter
	
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


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}

//generate To String 
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", city=" + city + ", state=" + state + "]";
	}
	

 
	

}

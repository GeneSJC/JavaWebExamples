package com.demo.bean;

public class User {

    public String name;
    public String address;

    public User() {
    }

    public User(String name, String address) {
        this.name = name;
        this.address = address;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

    
}

package com.demo.deepanshu.model;

public class User {
    private int userId;
    public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	private String name;
    
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public User() {}

    public User(int userId, String name) {
        this.userId = userId;
        this.name = name;
    }

    
   
}

package com.clearconcepts.pojo;

public class User {
	
	private String username;
	private String paswword;
	
	
	
	
	public User(String username, String paswword) {
		super();
		this.username = username;
		this.paswword = paswword;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPaswword() {
		return paswword;
	}
	public void setPaswword(String paswword) {
		this.paswword = paswword;
	}
	@Override
	public String toString() {
		return "User [username=" + username + ", paswword=" + paswword + "]";
	}
	
	
	

}

package com.cg.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
//@Document is an annotation provided by Spring data project. It is used to identify a domain object, which is persisted to MongoDB.
@Document(collection="users")
public class Users {

	//@Id annotation specifies the primary key of an entity
	@Id
	private String userName; //Attributes
	private String passWord;
	
	
	//Default Constructor
	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	//Parameterized Constructor
	public Users(String id, String userName, String passWord) {
		super();

		this.userName = userName;
		this.passWord = passWord;
	}
	


	//Setters and Getters
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}	


	//ToString 
	@Override
	public String toString() {
		return "User [userName=" + userName + ", passWord=" + passWord + "]";
	}
	
	
}

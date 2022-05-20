package com.cg.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

//@Document is an annotation provided by Spring data project. It is used to identify a domain object, which is persisted to MongoDB.
@Document(collection="Admin")

public class LibraryAdmin {
	
//@Id annotation specifies the primary key of an entity
@Id
private int adminId;  //attribute
private String adminname;
private String  bookno;

//default constructor
public LibraryAdmin() {
	super();
	// TODO Auto-generated constructor stub
}

//parameter constructor
public LibraryAdmin(int adminId, String adminname, String bookno) {
	super();
	this.adminId = adminId;
	this.adminname = adminname;
	this.bookno = bookno;
}

// getter and setter
public int getAdminId() {
	return adminId;
}
public void setAdminId(int adminId) {
	this.adminId = adminId;
}
public String getAdminname() {
	return adminname;
}
public void setAdminname(String adminname) {
	this.adminname = adminname;
}
public String getBookno() {
	return bookno;
}
public void setBookno(String bookno) {
	this.bookno = bookno;
}

//to string
@Override
public String toString() {
	return "LibraryAdmin [adminId=" + adminId + ", adminname=" + adminname + ", book=" + bookno + "]";
}


}

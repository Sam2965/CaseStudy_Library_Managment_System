package com.cg.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
//@Document is an annotation provided by Spring data project. It is used to identify a domain object, which is persisted to MongoDB.
@Document(collection="Book")
public class LibraryUser {
	
	//@Id annotation specifies the primary key of an entity
	@Id
	private int Bookid; //attribute
	private String Bookname;
	private String Author;
	private String Publisher;
	//default constructor
	public LibraryUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	//parameter constructor
	public LibraryUser(int bookid, String bookname, String author, String publisher) {
		super();
		this.Bookid = bookid;
		this.Bookname = bookname;
		this.Author = author;
		this.Publisher = publisher;
	}
	// getter and setter
	public int getBookid() {
		return Bookid;
	}
	public void setBookid(int bookid) {
		Bookid = bookid;
	}
	public String getBookname() {
		return Bookname;
	}
	public void setBookname(String bookname) {
		Bookname = bookname;
	}
	public String getAuthor() {
		return Author;
	}
	public void setAuthor(String author) {
		Author = author;
	}
	public String getPublisher() {
		return Publisher;
	}
	public void setPublisher(String publisher) {
		Publisher = publisher;
	}
	//to string
	@Override
	public String toString() {
		return "LibraryUser [Bookid=" + Bookid + ", Bookname=" + Bookname + ", Author=" + Author + ", Publisher="
				+ Publisher + "]";
	}
	
	
	

	

}

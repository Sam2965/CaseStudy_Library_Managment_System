package com.cg.service;

import java.util.List;

import com.cg.model.LibraryUser;

public interface UserService {
	
	// it is used to get data into database
	public List<LibraryUser> getAllLibrary();
	
}

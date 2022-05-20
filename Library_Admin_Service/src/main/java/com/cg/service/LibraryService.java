package com.cg.service;

import java.util.List;

import com.cg.exception.BooknoAlreadyDeletedException;
import com.cg.exception.BooknoAlreadyExistsException;
import com.cg.model.LibraryAdmin;

public interface LibraryService {
	// it is used to add data into database
	public LibraryAdmin addLibrary(LibraryAdmin ad) throws BooknoAlreadyExistsException;
	
	// it is used to get data into database
	public List<LibraryAdmin> getAllLibrary();
	
	// it is used to delete data into database
	public void deleteLibraryBydeptno(int bookno) throws BooknoAlreadyDeletedException;
	
	// it is used to update data into database
	public LibraryAdmin updateLibrary(LibraryAdmin ud);
	
}
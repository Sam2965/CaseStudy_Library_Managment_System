package com.cg.service;

import java.util.List;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.exception.BooknoAlreadyDeletedException;
import com.cg.exception.BooknoAlreadyExistsException;
import com.cg.model.LibraryAdmin;
import com.cg.repository.LibraryRepository;

//It is used to mark the class as a service provider. So overall 
//@Service annotation is used with classes that provide some business functionalities.
@Service
public class LibraryServiceImpl implements LibraryService{

private LibraryRepository libRepo;

    // it is used inject dependency
    @Autowired
	public LibraryServiceImpl(LibraryRepository libRepo) {
	super();
	this.libRepo = libRepo;
    }
    // it is used inject dependency
	@Override
	public LibraryAdmin addLibrary(LibraryAdmin ad) throws BooknoAlreadyExistsException {
		if(libRepo.existsById(ad.getAdminId())) {
			throw new BooknoAlreadyExistsException();
			}
	   LibraryAdmin saveli= libRepo.save(ad);
		return saveli;
	}
	// it is used inject dependency
	@Override
	public List<LibraryAdmin> getAllLibrary() {
		return (List<LibraryAdmin>) libRepo.findAll();
	}
	// it is used inject dependency
	@Override
	public void deleteLibraryBydeptno(int bookno) throws BooknoAlreadyDeletedException{
		libRepo.deleteById(bookno);	
	}
	// it is used inject dependency
	@Override
	public LibraryAdmin updateLibrary(LibraryAdmin ud) {
		LibraryAdmin record;
		Optional<LibraryAdmin> opt= libRepo.findById(ud.getAdminId());
		if(opt.isPresent()) {
		record=opt.get();
		record.setAdminname(ud.getAdminname());
		record.setBookno(ud.getBookno());
		libRepo.save(record);
		}else {
		return new LibraryAdmin();
		}
		return record;
	}

	
}

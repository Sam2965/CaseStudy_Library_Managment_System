package com.cg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.model.LibraryUser;
import com.cg.repository.UserRepository;
//@Service annotation is used with classes that provide some business functionalities.
@Service
public class UserServiceImpl implements UserService {

	private UserRepository libRepo;
	// it is used inject dependency
	@Autowired
	public UserServiceImpl(UserRepository libRepo) {
		super();
		this.libRepo = libRepo;
	    }
	// it is used inject dependency
	@Override
	public List<LibraryUser> getAllLibrary() {
		
		return (List<LibraryUser>) libRepo.findAll();
		
	}
	
}

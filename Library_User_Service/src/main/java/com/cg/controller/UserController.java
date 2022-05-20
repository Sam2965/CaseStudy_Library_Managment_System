package com.cg.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cg.model.LibraryUser;
import com.cg.service.UserService;
// RestController is a Spring annotation that is used to build REST API in a declarative way.
@RestController
//It is used to map web requests onto specific handler classes and/or handler methods.
@RequestMapping("/api/v1")
public class UserController {

	private UserService liserv;
	// it is used to inject dependency
    @Autowired
	public UserController(UserService liserv) {
		this.liserv=liserv;
		// TODO Auto-generated constructor stub
	}
//  it is used to get data into database
	@GetMapping("/getall")
	public ResponseEntity<List<LibraryUser>> getAllLibrary(){
    return new ResponseEntity<List<LibraryUser>>((List<LibraryUser>)liserv.getAllLibrary(),HttpStatus.OK);
	}

}

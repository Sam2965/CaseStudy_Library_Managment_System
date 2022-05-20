package com.cg.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cg.model.LibraryUser;
//Spring Boot provides the @SpringBootTest annotation which we can use to create an application context containing all the objects we need for all of the above test types.
@SpringBootTest
//@ExtendWith is a repeatable annotation that is used to register extensions for the annotated test class, test interface, test method, parameter, or field.
@ExtendWith(SpringExtension.class)
class UserRepositoryTest {
//it is used to inject dependency
	@Autowired
	private UserRepository isRepo;
	 //Test annotation tells JUnit that the public void method to which it is attached can be run as a test case.
	@Test
	public void givenLibraryAdminShouldReturnLibraryAdminObject() 
	{
    LibraryUser l1 = new LibraryUser (7, "vasu","phy", "sam"); //// Input Given By User.
	isRepo.save(l1); // Given Data is Saved in DataBase.
	LibraryUser l2=isRepo.findById(l1.getBookid()).get();
	assertNotNull(l2); // check for returning Library object.
	assertEquals(l1.getBookname(), l2.getBookname());
	}


	 //Test annotation tells JUnit that the public void method to which it is attached can be run as a test case.
	@Test
	public void getAllmustReturnAllLibraryAdmin()
	{
		LibraryUser l3 = new LibraryUser(3, "sam","bio", "sanju");
		LibraryUser l4 = new LibraryUser(5, "sanju","chme", "ashi");
	isRepo.save(l3);
	isRepo.save(l4);
	List<LibraryUser>stdList = (List<LibraryUser>) isRepo.findAll();
	assertEquals("sanju",stdList.get(1).getBookname());
	//assertEquals(2, stdList.size()); // CHECKING SIZE
	}
}

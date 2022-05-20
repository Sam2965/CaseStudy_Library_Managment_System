package com.cg.repository;

import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import com.cg.model.LibraryAdmin;
//
@SpringBootTest
//@ExtendWith is a repeatable annotation that is used to register extensions for the annotated test class, test interface, test method, parameter, or field.
@ExtendWith(SpringExtension.class)
public class LibraryRepositoryTest {
	
	// it is used to inject dependency
	@Autowired
	private LibraryRepository isRepo;
//Test annotation tells JUnit that the public void method to which it is attached can be run as a test case.
	@Test
	public void givenLibraryAdminShouldReturnLibraryAdminObject() 
	{
    LibraryAdmin l1 = new LibraryAdmin (7, "vasu","phy"); //// Input Given By User.
	isRepo.save(l1); // Given Data is Saved in DataBase.
	LibraryAdmin l2=isRepo.findById(l1.getAdminId()).get();
	assertNotNull(l2); // check for returning Library object.
	assertEquals(l1.getBookno(), l2.getBookno());
	}


	//Test annotation tells JUnit that the public void method to which it is attached can be run as a test case.
	@Test
	public void getAllmustReturnAllLibraryAdmin()
	{
		LibraryAdmin l3 = new LibraryAdmin(3, "sam","bio");
		LibraryAdmin l4 = new LibraryAdmin(5, "sanju","chme");
	isRepo.save(l3);
	isRepo.save(l4);
	List<LibraryAdmin>stdList = (List<LibraryAdmin>) isRepo.findAll();
	assertEquals(6,stdList.get(1).getAdminId());
	//assertEquals(2, stdList.size()); // CHECKING SIZE
	}
}


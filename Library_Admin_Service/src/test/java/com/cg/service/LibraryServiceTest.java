package com.cg.service;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import com.cg.exception.BooknoAlreadyExistsException;
import com.cg.model.LibraryAdmin;
import com.cg.repository.LibraryRepository;
// 
@SpringBootTest
//@ExtendWith is a repeatable annotation that is used to register extensions for the annotated test class, test interface, test method, parameter, or field.
@ExtendWith(MockitoExtension.class)
class LibraryServiceTest {

//	It is used to mock the objects that helps in minimizing the repetitive mock objects.
	    @Mock
	    private LibraryRepository pr;
	    //used in implementation layer
	    @InjectMocks             
	    private LibraryServiceImpl asl;
//Test annotation tells JUnit that the public void method to which it is attached can be run as a test case.
	    @Test
	    public void TestAddLibrary() throws BooknoAlreadyExistsException 
	    {
	        LibraryAdmin p1=new LibraryAdmin(10,"sanjeev","magical"); // user input
	        when(pr.save(any())).thenReturn(p1); //save any object to repository
	        asl.addLibrary(p1); //data saved in database
	        verify(pr,times(1)).save(any()); //calling any method once
	    }

//Test annotation tells JUnit that the public void method to which it is attached can be run as a test case.
	    @Test
	    public void testGetAllLibrary()
	    {
	    	LibraryAdmin p1=new LibraryAdmin(10,"Sanjeev","magical"); // user input
	    	LibraryAdmin p2=new LibraryAdmin(18,"Virat","networking"); //user input
	    	LibraryAdmin p3=new LibraryAdmin(45,"Rohit","Art"); //user input
	        pr.save(p1); //data saved to database
	        pr.save(p2); //data saved to database
	        pr.save(p3); //data saved to database
	        List<LibraryAdmin> plist=new ArrayList<>(); // crating list object
	        plist.add(p1);
	        plist.add(p2);
	        plist.add(p3);
	        when(pr.findAll()).thenReturn(plist); // return student list
	        List<LibraryAdmin> plist1 = asl.getAllLibrary();
	        assertEquals(plist, plist1); //checking both objects are equal
	        verify(pr,times(1)).save(p1);
	        verify(pr,times(1)).findAll();


	}
	}


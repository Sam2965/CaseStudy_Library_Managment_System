package com.cg.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import com.cg.model.LibraryUser;
import com.cg.repository.UserRepository;

//Spring Boot provides the @SpringBootTest annotation which we can use to create an application context containing all the objects we need for all of the above test types.
@SpringBootTest
//@ExtendWith is a repeatable annotation that is used to register extensions for the annotated test class, test interface, test method, parameter, or field.
@ExtendWith(MockitoExtension.class)
class UserServiceTest {

//	It is used to mock the objects that helps in minimizing the repetitive mock objects.
    @Mock
    private UserRepository pr;
    //used in implementation layer
    @InjectMocks             //used in implementation layer
    private UserServiceImpl asl;
  //Test annotation tells JUnit that the public void method to which it is attached can be run as a test case.
    @Test
    public void testGetAllLibrary()
    {
    	LibraryUser p1=new LibraryUser(10,"Sanjeev","magical", "sam"); // user input
    	LibraryUser p2=new LibraryUser(18,"Virat","networking", "sanju"); //user input
    	LibraryUser p3=new LibraryUser(45,"Rohit","Art", "rock"); //user input
        pr.save(p1); //data saved to database
        pr.save(p2); //data saved to database
        pr.save(p3); //data saved to database


        List<LibraryUser> plist=new ArrayList<>(); // crating list object
        plist.add(p1);
        plist.add(p2);
        plist.add(p3);


        when(pr.findAll()).thenReturn(plist); // return student list
        List<LibraryUser> plist1 = asl.getAllLibrary();
        assertEquals(plist, plist1); //checking both objects are equal
        verify(pr,times(1)).save(p1);
        verify(pr,times(1)).findAll();


}	
}

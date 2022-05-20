package com.cg.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import com.cg.model.LibraryAdmin;
import com.cg.service.LibraryService;
import com.fasterxml.jackson.databind.ObjectMapper;
//@ExtendWith is a repeatable annotation that is used to register extensions for the annotated test class, test interface, test method, parameter, or field.
@ExtendWith(MockitoExtension.class)
class LibraryControllerTest {
//it is used to inject dependency
	@Autowired
	private MockMvc mockMvc;
//It is used to mock the objects that helps in minimizing the repetitive mock objects.
	@Mock
	private LibraryService ss;
	private LibraryAdmin st;
	private List<LibraryAdmin> stdList;
//
	@InjectMocks
	private LibraryController sc;
//
	@BeforeEach
	public void setUp()//initailized object
	{
		st = new LibraryAdmin(1, "sanjeev", "magical");
		mockMvc = MockMvcBuilders.standaloneSetup(sc).build();
	}
	//Test annotation tells JUnit that the public void method to which it is attached can be run as a test case.
	@Test
	public void addLibraryControllerTest() throws Exception {
		when(ss.addLibrary(any())).thenReturn(st);
		mockMvc.perform(post("/api/v1/add")
				.contentType(MediaType.APPLICATION_JSON)
				.content(asJSONString(st)))
				.andExpect(status().isCreated());
		verify(ss,times(1)).addLibrary(any());
	}
	//Test annotation tells JUnit that the public void method to which it is attached can be run as a test case.
	@Test
	public void getAllLibraryControllerTest() throws Exception {
		when(ss.getAllLibrary()).thenReturn(stdList);
		mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/getall")
				.contentType(MediaType.APPLICATION_JSON)
				.content(asJSONString(st)))
		        .andDo(MockMvcResultHandlers.print());
		 verify(ss, times(1)).getAllLibrary();
	}

	public static String asJSONString(final Object obj) {
		// TODO Auto-generated method stub
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}

package com.cg.controller;

	import java.util.List;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.http.HttpStatus;
	import org.springframework.http.ResponseEntity;
	import org.springframework.web.bind.annotation.DeleteMapping;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.PostMapping;
	import org.springframework.web.bind.annotation.PutMapping;
	import org.springframework.web.bind.annotation.RequestBody;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RestController;

import com.cg.exception.BooknoAlreadyDeletedException;
import com.cg.exception.BooknoAlreadyExistsException;
import com.cg.model.LibraryAdmin;
    import com.cg.service.LibraryService;
    // RestController is a Spring annotation that is used to build REST API in a declarative way.
	@RestController
	// It is used to map web requests onto specific handler classes and/or handler methods.
	@RequestMapping("/api/v1")
	public class LibraryController {		
			private LibraryService liserv;
			// it is used to inject dependency
			@Autowired
			public LibraryController(LibraryService isroserv) {
				super();
				this.liserv =isroserv;
			}
		@PostMapping("/add") // it is used to add data into database
		public ResponseEntity<LibraryAdmin>addLibraryAdmin(@RequestBody LibraryAdmin dept) throws BooknoAlreadyExistsException{
			LibraryAdmin  savedDept = liserv.addLibrary(dept);
			 return new ResponseEntity<>(savedDept, HttpStatus.CREATED);
		}
		
		@GetMapping("/getall") //  it is used to get data into database
		public ResponseEntity<List<LibraryAdmin>> getAllLibraryAdmin(){
	    return new ResponseEntity<List<LibraryAdmin>>((List<LibraryAdmin>)liserv.getAllLibrary(),HttpStatus.OK);
		}

	    @DeleteMapping("/delete/{bookno}") // it is used to delete data into database
	    public ResponseEntity<Void> deletebookById(@PathVariable int bookno) throws BooknoAlreadyDeletedException{
	    liserv.deleteLibraryBydeptno(bookno);
	    return ResponseEntity.noContent().build();
	    }

	    @PutMapping("/update") //  it is used to update data into database
		public LibraryAdmin updateLibraryAdmin(@RequestBody LibraryAdmin dname) {  
		return liserv.updateLibrary(dname);
		}

}

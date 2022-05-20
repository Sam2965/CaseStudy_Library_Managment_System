package com.cg.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.cg.model.LibraryAdmin;

public interface LibraryRepository extends MongoRepository<LibraryAdmin, Integer>  {

}

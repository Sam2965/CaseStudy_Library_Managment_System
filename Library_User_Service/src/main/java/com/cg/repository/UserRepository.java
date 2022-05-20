package com.cg.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.cg.model.LibraryUser;

public interface UserRepository extends MongoRepository<LibraryUser, Integer> {

}

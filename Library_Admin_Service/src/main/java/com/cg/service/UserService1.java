package com.cg.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cg.model.Users;
import com.cg.repository.UserRepositiory;
//It is used to mark the class as a service provider. So overall 
//@Service annotation is used with classes that provide some business functionalities.
@Service
public class UserService1 implements UserDetailsService {
   
	// it is used inject dependency
	@Autowired
	private UserRepositiory userRepository;
	
	// it is used inject dependency
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users user = userRepository.findByuserName(username);
		if(user==null)
			throw new UsernameNotFoundException(username, null);
		String usern=user.getUserName();
		String passwrd=user.getPassWord();
		return new User(usern,passwrd,new ArrayList<>());

}
}
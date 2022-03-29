package com.udemynl.workshopmongo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udemynl.workshopmongo.domain.User;
import com.udemynl.workshopmongo.repository.UserRepository;
import com.udemynl.workshopmongo.service.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAll(){
		return userRepository.findAll();
	}
	
	public User findById(String id){
		Optional<User> found = userRepository.findById(id);
		return found.orElseThrow(() -> new ObjectNotFoundException(id));
		
		
	}
}

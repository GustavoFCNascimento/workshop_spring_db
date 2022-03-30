package com.udemynl.workshopmongo.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udemynl.workshopmongo.domain.User;
import com.udemynl.workshopmongo.dto.UserDTO;
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
	
	public User insert(User user) {
		return userRepository.insert(user);
	}
	
	public void delete(String id) {
		
		
		try {
			Optional<User> found = userRepository.findById(id);
			userRepository.delete(found.get());
		}catch(NoSuchElementException e) {
			throw new ObjectNotFoundException(e.getMessage());
		}
	}
	
	public User fromDTO(UserDTO userDto) {
		return new User(userDto.getId(), userDto.getName(), userDto.getEmail());
	}
}

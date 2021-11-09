package com.simplilearn.webservice.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.simplilearn.webservice.entity.User;
import com.simplilearn.webservice.exception.InvalidUserException;
import com.simplilearn.webservice.exception.UserNotFoundException;

@RestController
public class UserController {

	//TODO :: WAP with CRUD Operation
	
	List<User> users = new ArrayList<User>();
	
	//Create User List 
	private List<User>getDefaultUser(){
		
		users.add(new User(101,"Devika Patel","Surat","Gujarat"));
		users.add(new User(102,"Jake Sahu","Junagarh","Odisha"));
		users.add(new User(103,"Raj Sahu","Baripada","Odisha"));
		users.add(new User(104,"Chitra Patel","Jaipur","Rajasthan"));
		users.add(new User(105,"Sofia Nayak","Sambalpur","Odisha"));
		
		return users;
	}
	 
	//Get List of Users
	@GetMapping("/users")
	public List<User>getAllUsers(){
		
		return getDefaultUser();
	}
	
	
	
	//Get One User By Id
	@GetMapping("/users/{id}")
	public User getOneUserById(@PathVariable("id") int id){
		
		for(User user : users) {
			if(user.getId()==id) {
				return user;
			}
		}
		
		throw new UserNotFoundException();
	}
	
	
	//Add User 
	@PostMapping("/users")
	public List<User> addUser(@RequestBody User user){
		
		if(user.getId() > 0 && user.getName() != null && user.getCity() !=null && user.getState() !=null) {
			
			users.add(user);
			return users;
		}
		
		
		throw new InvalidUserException();
	}
	
	//Delete One User By Id
	@DeleteMapping("/users/{id}")
	public List<User> deleteOneUser(@PathVariable("id") int id) {
		// counter for loop
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getId() == id) {
				users.remove(i);
				return users;
			}
		}

		throw new UserNotFoundException();

	}
	
	
}

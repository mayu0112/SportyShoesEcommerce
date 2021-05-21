package com.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beans.Users;
import com.repository.UserDao;


@Service
public class UserValidity {
	
	@Autowired
	private UserDao userDao;

	
	public boolean validateusers(String username, String pass) {
		System.out.println("User Validity Service Reached");
		
		Optional<Users> find = userDao.findById(username);
		
	         if (find.isPresent() && find.get().getPass().equals(pass)){
	        	 System.out.println("User is Valid: " +  find.get().getName());
	               return true;
	         }
	         else {
	        	 return false; 
	         }
	         
	}
	
	public void addusers(String username, String pass, String email, String city) {
		System.out.println("User Sign up Service Reached");
		userDao.save(new Users(username, pass, email, city));
	}

	
	public List<Users> listUsers(){
		List al = (ArrayList<Users>) userDao.findAll();
		System.out.println("List of Users: " + al);
		return al;
	}
	
	public Optional<Users> searchusers(String name) {
		Optional<Users> find = userDao.findById(name);
		System.out.println("Searched Users: " + find);
		return find;
	         
	}
}

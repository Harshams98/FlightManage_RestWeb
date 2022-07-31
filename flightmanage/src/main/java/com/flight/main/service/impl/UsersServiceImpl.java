package com.flight.main.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flight.main.exception.ResourceNotFoundException;
import com.flight.main.model.Users;
import com.flight.main.repository.UsersRepo;
import com.flight.main.service.UsersService;


@Service
public class UsersServiceImpl implements UsersService{
	
	@Autowired
	UsersRepo userrepo;

	public UsersServiceImpl() {
		super();
	}

	public UsersServiceImpl(UsersRepo userrepo) {
		super();
		this.userrepo = userrepo;
	}

	@Override
	public Users saveUsers(Users users) {
		return userrepo.save(users);
		
	}

	@Override
	public List<Users> getAllUsers() {
		return userrepo.findAll();
		
	}

	@Override
	public Users getById(int userId) {
		Optional<Users> users=userrepo.findById(userId);
		
		return userrepo.findById(userId).orElseThrow(()->		//USING LAMBDA
				new ResourceNotFoundException("Users","USersID",users));
	
	}

	@Override
	public Users updateUser(Users users, int userID) {
		Users user=userrepo.findById(userID).orElseThrow(() ->
				new ResourceNotFoundException("Airport","code",userID));
		
		user.setUsername(users.getUsername());
		user.setEmail(users.getEmail());
		
	user.setUserphone(users.getUserphone());
	user.setUserpassword(users.getUserpassword());
	user.setUsertype(users.getUsertype());
		
		
		//saving existion employee in db
		userrepo.save(user);
		return user;
	}

	@Override
	public void deleteUsers(int userId) {
		userrepo.findById(userId).orElseThrow( ()->
		new com.flight.main.exception.ResourceNotFoundException("Airport","code",userId));
		userrepo.deleteById(userId);
	}

}
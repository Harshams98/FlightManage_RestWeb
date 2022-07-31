package com.flight.main.service;

import java.util.List;

import com.flight.main.model.Users;

public interface UsersService {
Users saveUsers (Users users);
	
	List<Users> getAllUsers();
	
	Users getById (int  userId);
	
	Users updateUser(Users users,int userId);
	
	void deleteUsers(int userId);
}
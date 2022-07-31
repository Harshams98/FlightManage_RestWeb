package com.flight.main.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.flight.main.model.Users;
import com.flight.main.service.UsersService;

@RestController
@RequestMapping("/api/users")
public class UsersController {
	
	@Autowired
	private UsersService usersservice;

		public UsersController() {
			super();
		}

		public UsersController(UsersService usersservice) {
			super();
			this.usersservice = usersservice;
		}

		
		@PostMapping()
		public ResponseEntity<Users> saveUsers(@RequestBody Users users){
			return new ResponseEntity<Users>(usersservice.saveUsers(users), HttpStatus.CREATED);
		}
		@GetMapping()
		public List<Users> getAllEmployees(){
			return usersservice.getAllUsers();
		}
		@GetMapping("{id}")
		public ResponseEntity<Users> getById(@PathVariable ("id")int user){
		return new ResponseEntity<Users>(usersservice.getById(user),
				HttpStatus.OK);//status -- 200
		}
		
		@PutMapping("{id}")
		public ResponseEntity<Users> updateUser(@PathVariable ("id") int  user,
				@RequestBody Users users){
		return new ResponseEntity<Users>(usersservice.updateUser(users,user),
				HttpStatus.OK);
		}
		
//		@DeleteMapping("{id}")
//		public ResponseEntity<String> deleteUsers(@PathVariable ("id") int user){
//			//delete employee db
//			usersservice.deleteUsers(user);
//			return new ResponseEntity<String>("User record deleted successfully!",HttpStatus.OK);
//		}
		
}
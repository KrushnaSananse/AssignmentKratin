package com.app.controller;

import java.time.LocalTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojo.User;
import com.app.service.UserService;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	public UserController() {
		System.out.println("In user controller "+getClass().getName());
		System.out.println(LocalTime.of(17,35));
	}

	@GetMapping("/login")
	public ResponseEntity<?> login(@RequestParam String email, @RequestParam String pass){
		Optional<User> user = userService.fetchUser(email,pass);

		if (user.isPresent()) {
			return new ResponseEntity<>(user.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/getAllUserDetails")
	public ResponseEntity<?> GetAllUserDetails(){
		return new ResponseEntity<>(userService.fetchAllUsers(),HttpStatus.OK);
	}

	@PostMapping("/register")
	public ResponseEntity<?> Register(@RequestBody User user){
		User userNew = userService.addUser(user);
		return new ResponseEntity<>(userNew,HttpStatus.CREATED);
	}

}

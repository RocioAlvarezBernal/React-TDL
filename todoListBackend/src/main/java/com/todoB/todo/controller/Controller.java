package com.todoB.todo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.todoB.todo.model.User;
import com.todoB.todo.model.Login;
import com.todoB.todo.service.UserServiceInt;
import com.todoB.todo.service.LoginServiceInt;

@RestController
public class Controller {

	@Autowired
	private LoginServiceInt logServ;
	
	@Autowired @Lazy
	private UserServiceInt usrServInt;

	@GetMapping(value = "api/employeedirectory")
	public ResponseEntity<?> dispAll() {
		return ResponseEntity.ok(logServ.findAll());
	}

	@PostMapping
	@RequestMapping(method = RequestMethod.POST, value = "/api/login")
	public ResponseEntity<?> findByUsername(@RequestBody Login bodyInput) {
		if ((logServ.findByUsername(bodyInput.getUsername())) != null
				&& (logServ.findByUsername(bodyInput.getUsername()).getPassword().equals(bodyInput.getPassword())))

		{
			return new ResponseEntity<>("Logged in Username : " + bodyInput.getUsername(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Username or password incorrect", HttpStatus.FORBIDDEN);
		}

	}

	@PostMapping
	@RequestMapping(method = RequestMethod.POST, value = "/api/signup")
	public ResponseEntity<?> create(@RequestBody Login loginBod) {
		if (logServ.findByUsername(loginBod.getUsername()) != null) {
			return new ResponseEntity<>("User already exists", HttpStatus.FORBIDDEN);
		} else {
			return new ResponseEntity<>(logServ.create(loginBod), HttpStatus.CREATED);
		}
	}
//////////////////////////////////////Details//////////////////////////////////////

	@PostMapping
	@RequestMapping(value = "/api/empDetails", method = RequestMethod.POST)
	public  User displayInfo( @RequestBody User detBody) {
		if (usrServInt.findById(detBody.getId()) == null) {
			return usrServInt.displayInfo(detBody);
		} else {
			return null;
		}
	}
}

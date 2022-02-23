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
import com.todoB.todo.model.ListItem;
import com.todoB.todo.model.Login;
import com.todoB.todo.service.UserServiceInt;
import com.todoB.todo.service.ListItemServiceInt;
import com.todoB.todo.service.LoginServiceInt;

@RestController
public class Controller {

	@Autowired
	private LoginServiceInt logServInt;

	@Autowired
	@Lazy
	private UserServiceInt usrServInt;

	@Autowired
	@Lazy
	private ListItemServiceInt LIServInt;

	@GetMapping(value = "api/employeedirectory")
	public ResponseEntity<?> dispAll() {
		return ResponseEntity.ok(logServInt.findAll());
	}

	@PostMapping
	@RequestMapping(method = RequestMethod.POST, value = "/api/login")
	public ResponseEntity<?> findByUsername(@RequestBody Login bodyInput) {
		if ((logServInt.findByUsername(bodyInput.getUsername())) != null
				&& (logServInt.findByUsername(bodyInput.getUsername()).getPassword().equals(bodyInput.getPassword())))

		{
			return new ResponseEntity<>("Logged in Username : " + bodyInput.getUsername(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Username or password incorrect", HttpStatus.FORBIDDEN);
		}

	}

	@PostMapping
	@RequestMapping(method = RequestMethod.POST, value = "/api/signup")
	public ResponseEntity<?> create(@RequestBody Login loginBod) {
		if (logServInt.findByUsername(loginBod.getUsername()) != null) {
			return new ResponseEntity<>("User already exists", HttpStatus.FORBIDDEN);
		} else {
			return new ResponseEntity<>(logServInt.create(loginBod), HttpStatus.CREATED);
		}
	}
//////////////////////////////////////Details//////////////////////////////////////

	@PostMapping
	@RequestMapping(value = "/api/empDetails", method = RequestMethod.POST)
	public User displayInfo(@RequestBody User detBody) {
		if (usrServInt.findById(detBody.getId()) == null) {
			return usrServInt.displayInfo(detBody);
		} else {
			return null;
		}
	}
/////////////////////////////////////Items//////////////////////////////////////

	@PostMapping
	@RequestMapping(method = RequestMethod.POST, value = "/api/createLI")
	public ResponseEntity<?> displayLI(@RequestBody ListItem LIContent) {	
//			System.out.println( "test print " + LIContent.getListItemContent() );
			return new ResponseEntity<>(LIServInt.createLI(LIContent), HttpStatus.OK);

	}
}

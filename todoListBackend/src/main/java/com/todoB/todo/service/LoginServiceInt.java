package com.todoB.todo.service;

import java.util.ArrayList;

import com.todoB.todo.model.Login;

public interface LoginServiceInt {
	
	ArrayList <Login> findAll();  

	Login create (Login log);
	
	Login loginCred(Login log);
	
	Login findByUsername(String username);
}

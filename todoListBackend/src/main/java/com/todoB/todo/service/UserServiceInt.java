package com.todoB.todo.service;

import java.util.List;

import com.todoB.todo.model.User;

public interface UserServiceInt {
	
	User displayInfo (User dets);
	
	List<User> findById (int id); 
}    
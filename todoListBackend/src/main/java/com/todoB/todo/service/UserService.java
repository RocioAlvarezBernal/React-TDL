package com.todoB.todo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.todoB.todo.model.User;
import com.todoB.todo.repository.UserRepo;

@Service
public class UserService implements UserServiceInt{
	ArrayList<User> userList = new ArrayList<User>();

	
	@Autowired @Lazy
	public UserServiceInt usrServInt;
	@Autowired
	public UserRepo usrRepo;
	@Autowired
	public User user;

	@Override
	public User displayInfo(User dets){
		userList.add(dets);
		usrRepo.save(dets);
		return dets;
	}
	
	@Override
	public List<User> findById(int id) {
		return usrRepo.findById(id);
	}
}

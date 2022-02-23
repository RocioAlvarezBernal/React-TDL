package com.todoB.todo.service;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.todoB.todo.model.Login;
import com.todoB.todo.repository.LoginRepo;

@Service
public  class LoginService implements LoginServiceInt {
	
	public ArrayList<Login> logins = new ArrayList<Login>();
	
	@Autowired
	public LoginRepo logRepo;
//	public Login employeeClass;
	
	@Override
	public Login create(Login emp) {
		logins.add(emp);
		logRepo.save(emp);
		return emp;
	}

	@Override
	public Login loginCred(Login emp) {
		emp.getPassword();
		return emp;
	}
	
	@Override
	public Login findByUsername(String username) {
		return logRepo.findByUsername(username);
	}

	@Override
	public ArrayList<Login> findAll() {
		return logins;
	}

}

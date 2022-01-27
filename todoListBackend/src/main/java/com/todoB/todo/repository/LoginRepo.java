package com.todoB.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.todoB.todo.model.Login;

@Repository
public interface LoginRepo extends JpaRepository<Login, Integer> {
	Login findByUsername(String username);
}


package com.todoB.todo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.todoB.todo.model.ListItem;

@Repository
public interface ListItemRepo extends JpaRepository <ListItem, Integer> {
	public ListItem findById(int LIid);
}

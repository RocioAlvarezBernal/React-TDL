package com.todoB.todo.service;

import java.util.ArrayList;

import com.todoB.todo.model.ListItem;

public interface ListItemServiceInt {
	ArrayList <ListItem> findAll();  

	ListItem findById(int LIid);
	ListItem createLI (ListItem Li);
}

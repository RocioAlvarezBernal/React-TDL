package com.todoB.todo.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todoB.todo.model.ListItem;
import com.todoB.todo.repository.ListItemRepo;

@Service
public class ListItemService implements ListItemServiceInt{
	
	public ArrayList<ListItem> LIList= new ArrayList<ListItem>();
	
	@Autowired
	public ListItemRepo LIRepo;
	
	public ListItem createLI(ListItem LI) {
		LIList.add(LI);
		LIRepo.save(LI);
		return LI;
	}


	@Override
	public ListItem findById(int LIid) {
		return LIRepo.findById(LIid);
	}


	@Override
	public ArrayList<ListItem> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
}

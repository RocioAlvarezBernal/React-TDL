package com.todoB.todo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="listItem")

public class ListItem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int LIid;
	
	@Column(name="content")
	private String listItemContent;
	
	public ListItem() {
		super();
	}

	public ListItem(Integer LIid, String listItemContent) {
		this.LIid = LIid;
		this.listItemContent = listItemContent;
	}
	
	public int getLIid() {
		return LIid;
	}

	public void setLIid(int LIid) {
		this.LIid = LIid;
	}
	
	public String getListItemContent() {
		return listItemContent;
	}
	public void setListItemContent( String listItemContent) {
		this.listItemContent=listItemContent;
	}

	
}

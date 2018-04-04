package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TO_DO_ITEMS")
public class ToDoItems {
	
	@Id
	@GeneratedValue
	private long Id;
	
	private String taskName;
	private  boolean isCompleted ;
	
	public ToDoItems() {
		// TODO Auto-generated constructor stub
	}
	
	public ToDoItems(String taskName) {
		this.taskName=taskName;
		isCompleted=false;
	}
	public long getId() {
		return Id;
	}
	public void setId(long id) {
		Id = id;
	}
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	public boolean isCompleted() {
		return isCompleted;
	}
	public void setCompleted(boolean isCompleted) {
		this.isCompleted = isCompleted;
	}
	
	

}

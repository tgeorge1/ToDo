package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.ToDoItems;

public interface ToDoRepository extends CrudRepository<ToDoItems, Long> {
	Iterable<ToDoItems> findAll();
	ToDoItems findById(long id);
}

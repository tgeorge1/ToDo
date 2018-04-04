package com.example.demo.controllers;

import org.springframework.http.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.ToDoItems;
import com.example.demo.repository.ToDoRepository;

@RestController
@RequestMapping("todo")
public class ToDoController {
 
	@Autowired
	ToDoRepository toDoRepository;

	@RequestMapping("/")
	public String welcome() {
		return "Welcome to RestTemplate Example.";
	}

	@RequestMapping(value = "/findall", method = RequestMethod.GET)
	public Iterable<ToDoItems> findAll() { 
		return toDoRepository.findAll();
	}

	@RequestMapping(value = "/findbyid/{id}", method = RequestMethod.GET)
	public ToDoItems findById(@PathVariable("id") long id) {
		return toDoRepository.findById(id);
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public void save(@RequestBody ToDoItems task) {
		toDoRepository.save(task);

	}

}

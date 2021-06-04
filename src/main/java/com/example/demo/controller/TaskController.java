package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.Task;
import com.example.demo.service.TaskService;

@RestController
@RequestMapping("/tasks")
public class TaskController {
	@Autowired
	TaskService ts;

	@PostMapping("/")
	public void add(@RequestBody Task t) {
		ts.addTask(t);
	}

	@GetMapping
	public List<Task> listTasks() {
		return ts.getAllTask();
	}

	@GetMapping("/{id}")
	public Task get(@PathVariable("id") Integer id) {
		return ts.getTask(id);
	}
}

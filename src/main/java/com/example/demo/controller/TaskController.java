package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
}

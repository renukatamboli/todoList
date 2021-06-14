package com.example.demo.controller;

import java.util.List;
import java.util.NoSuchElementException;

import com.example.demo.DTO.TaskRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Converter.TaskPresenter;
import com.example.demo.DTO.TaskDTO;
import com.example.demo.model.Task;
import com.example.demo.service.TaskService;

@RestController
@RequestMapping("/tasks")
public class TaskController {
	@Autowired
	private TaskService taskservice;

	@Autowired
	private TaskPresenter taskPresenter;
	
	@PostMapping("/")
	public Task add(@RequestBody TaskRequest taskRequest) {
		return taskservice.addTask(taskRequest);
	}

	@GetMapping
	public List<TaskDTO> listTasks() {
		return taskPresenter.entityToDto(taskservice.getAllTask());
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> get(@PathVariable("id") Integer id) {
		  try {
	            TaskDTO taskDTO = taskPresenter.entityToDto(taskservice.getTask(id));
	            return new ResponseEntity<>(taskDTO, HttpStatus.OK);
	        } catch (NoSuchElementException e) {
	            return new ResponseEntity<>("Task not found",HttpStatus.NOT_FOUND);
	        }
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id) {
        try {
		taskservice.deleteTask(id);
		return new ResponseEntity<>("Task Deleted", HttpStatus.OK);
        }
        catch(Exception e) {
        	return new ResponseEntity<>("Task is not present or already deleted",HttpStatus.NOT_FOUND);
        }
	}
	
	@PutMapping("/{id}/description")
	public void updateDescription(@PathVariable("id") Integer id,@RequestBody String description)
	{
		taskservice.addDescription(id, description);
	}
	@PutMapping("/{id}/name")
	public void updateName(@PathVariable("id") Integer id,@RequestBody String name)
	{
		taskservice.addName(id, name);
	}
	@PutMapping("/{id}/complete")
	public String updateTaskStatus(@PathVariable("id") Integer id)
	{
		taskservice.completeTask(id);
		return "Task Completed";
	}
}

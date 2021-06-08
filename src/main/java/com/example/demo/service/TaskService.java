package com.example.demo.service;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Task;
import com.example.demo.repository.TaskRepo;

@Service
@Transactional
public class TaskService {
	
	@Autowired
    TaskRepo repo;
	
	public Task addTask(Task t) {
        repo.save(t);
        return t;
    }
	
	public Task getTask(Integer id) {
		return repo.findById(id).get();
	}
	public List<Task> getAllTask() {
        return repo.findAll();
    }
	public void deleteTask(Integer id) {
        repo.deleteById(id);
    }
	public void addDescription(Integer id,String description) {
		Task task = repo.getById(id);
		task.setDescription(description);
		repo.save(task);
	}
	public void addName(Integer id,String Name) {
		Task task = repo.getById(id);
		task.setName(Name);
		repo.save(task);
	}
	public void completeTask(Integer id) {
		Task task = repo.getById(id);
		task.setIsComplete(true);
		repo.save(task);
	}
}

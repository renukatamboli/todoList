package com.example.demo.service;



import java.util.List;

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
	
	public void addTask(Task t) {
        repo.save(t);
    }
	
	public Task getTask(Integer id) {
		return repo.getById(id);
	}
	public List<Task> getAllTask() {
        return repo.findAll();
    }
}

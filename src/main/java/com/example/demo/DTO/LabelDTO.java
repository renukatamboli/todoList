package com.example.demo.DTO;

import java.util.List;
import java.util.stream.Collectors;

import com.example.demo.model.Label;
import com.example.demo.model.Task;

public class LabelDTO {
	private String name;
	private List<String> tasks;

	public LabelDTO(Label label) {
		this.name = label.getName();
		this.tasks = label.getTask().stream().map(Task::getName).collect(Collectors.toList());
	}

	public String getName() { return name; }

	public List<String> getTasks() { return tasks;}
}

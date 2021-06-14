package com.example.demo.DTO;

import java.util.List;
import java.util.stream.Collectors;

import com.example.demo.model.Label;
import com.example.demo.model.Task;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TaskDTO {

	private String name;
	private String description;
	private List<String> labels;

	public TaskDTO(Task task) {
		this.name = task.getName();
		this.description = task.getDescription();
		this.labels = task.getLabels().stream().map(Label::getName).collect(Collectors.toList());
	}

	public String getName() { return name; }

	public String getDescription() { return description; }

	public List<String> getLabels() { return labels;}
}

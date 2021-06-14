package com.example.demo.DTO;

import java.util.List;

import com.example.demo.model.Label;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TaskDTO {

	private String name;
	private String description;
	@JsonProperty("label")
	private List<LabelDTO> labeldto;

	public List<LabelDTO> getLabeldto() {
		return labeldto;
	}


	public void setLabeldto(List<LabelDTO> labeldto) {
		this.labeldto = labeldto;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}

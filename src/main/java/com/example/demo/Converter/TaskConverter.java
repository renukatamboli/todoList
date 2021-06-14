package com.example.demo.Converter;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.example.demo.DTO.TaskDTO;
import com.example.demo.model.Task;

@Component
public class TaskConverter {

	public TaskDTO entityToDto(Task task) {
		ModelMapper mapper = new ModelMapper();
		TaskDTO map = mapper.map(task, TaskDTO.class);
		System.out.println(map);
		return map;
	} 
	
	public List<TaskDTO> entityToDto(List<Task> task){
		return task.stream().map(x -> entityToDto(x)).collect(Collectors.toList());
	}
	public Task dtoToEntity(TaskDTO dto) {
		ModelMapper mapper = new ModelMapper();
		Task map = mapper.map(dto, Task.class);
		return map;
	}
	public List<Task> dtoToEntity(List<TaskDTO> dto){
		return dto.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());
	}
}

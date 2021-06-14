package com.example.demo.Converter;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.example.demo.DTO.LabelDTO;
import com.example.demo.DTO.TaskDTO;
import com.example.demo.model.Label;
@Component
public class LabelPresenter {

	public LabelDTO entityToDto(Label label) {
		return new LabelDTO(label);
	} 
	
	public List<LabelDTO> entityToDto(List<Label> label){
		return label.stream().map(x -> entityToDto(x)).collect(Collectors.toList());
	}
	public Label dtoToEntity(LabelDTO dto) {
		ModelMapper mapper = new ModelMapper();
		Label map = mapper.map(dto, Label.class);
		return map;
	}
	public List<Label> dtoToEntity(List<LabelDTO> dto){
		return dto.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());
	}
}

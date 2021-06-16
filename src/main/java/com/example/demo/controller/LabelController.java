package com.example.demo.controller;

import java.util.List;
import java.util.NoSuchElementException;

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

import com.example.demo.Converter.LabelPresenter;
import com.example.demo.Converter.TaskPresenter;
import com.example.demo.DTO.LabelDTO;
import com.example.demo.model.Label;
import com.example.demo.service.LabelService;

@RestController
@RequestMapping("/label")
public class LabelController {
	@Autowired
	private LabelService labelservice;
	@Autowired
	private LabelPresenter labelpresenter;

	@PostMapping("/")
	public Label add(@RequestBody Label label) {
		return labelservice.addLabel(label);
	}

	@GetMapping
	public List<LabelDTO> listLabels() {
		return labelpresenter.entityToDto(labelservice.getAllLabel());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> get(@PathVariable("id") Integer id) {
		  try {
	            Label label = labelservice.getLabel(id);
	            return new ResponseEntity<>(labelpresenter.entityToDto(label), HttpStatus.OK);
	        } catch (NoSuchElementException e) {
	            return new ResponseEntity<>("Label not found",HttpStatus.NOT_FOUND);
	        }
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id) {
        try {
		labelservice.deleteLabel(id);
		return new ResponseEntity<>("Label Deleted", HttpStatus.OK);
        }
        catch(Exception e) {
        	return new ResponseEntity<>("Label is not present or already deleted",HttpStatus.NOT_FOUND);
        }
	}
	
	@PutMapping("/{id}")
	public void updateLabelName(@PathVariable("id") Integer id,@RequestBody String name)
	{
		labelservice.updateLabel(id, name);
	}   
}

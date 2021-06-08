package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.demo.model.Label;
import com.example.demo.repository.LabelRepo;

@Service
@Transactional
public class LabelService {
	@Autowired
	LabelRepo repo;

	public Label addLabel(Label l) {
		repo.save(l);
		return l;
	}

	public Label getLabel(Integer id) {
		return repo.findById(id).get();
	}

	public List<Label> getAllLabel() {
		return repo.findAll();
	}

	public void deleteLabel(Integer id) {
		repo.deleteById(id);
	}

	public void updateLabel(Integer id, String name) {
		Label label = repo.getById(id);
		label.setName(name);
		repo.save(label);
	}

}

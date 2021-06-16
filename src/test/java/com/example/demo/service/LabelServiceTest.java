package com.example.demo.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import com.example.demo.model.Label;
import com.example.demo.repository.LabelRepo;

public class LabelServiceTest {

	@InjectMocks
	LabelService labelservice;
	
	@Mock
	LabelRepo repo;
	
	@Rule
	public MockitoRule rule= MockitoJUnit.rule();
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getLabelTest() {
		Optional<Label> label = Optional.ofNullable(new Label());
		label.get().setName("bug");
		when(repo.findById(anyInt())).thenReturn(label);
		Label l = labelservice.getLabel(2);
		assertNotNull(l);
		assertEquals("bug", l.getName());
		
	}
	@Test
	public void getAllLabelTest() {
		List<Label> labels =new ArrayList<Label>();
		Label label = new Label();
		label.setName("bug");
		labels.add(label);
		Label label2 = new Label();
		label2.setName("task");
		labels.add(label2);
		when(repo.findAll()).thenReturn(labels);
		List<Label> l = labelservice.getAllLabel();
		assertNotNull(l);
		assertEquals("bug", l.get(0).getName());
		
	}
	@Test
	public void addLabelTest() {
		Label label = new Label();
		label.setName("bug");
		when(repo.save(label)).thenReturn(label);
		Label l = labelservice.addLabel(label);
		assertNotNull(l);
		assertEquals("bug", l.getName());
		
	}
	@Test
	public void deleteLabelTest() {
		Label label = new Label();
		label.setName("bug");
		label.setId(2);
		labelservice.deleteLabel(2);
		verify(repo).deleteById(any());
		
	}
	
	@Test
	public void updateLabelTest() {
		Label label = new Label();
	    label.setName("bug");
	    label.setId(1);
	    when(repo.getById(anyInt())).thenReturn(label);
	    Label l = repo.getById(anyInt());
	    l.setName("task");
	    Label updatedLabel = repo.getById(anyInt());
	    assertThat(updatedLabel.getName()).isEqualTo("task");
	}

}
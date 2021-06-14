package com.example.demo.controller;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.demo.model.Label;

@RunWith(SpringJUnit4ClassRunner.class)
public class LabelControllerTest {
	
	@InjectMocks
	private Label label;

	private MockMvc mockMvc;
	
	@Test
	public void testAdd() throws Exception {
		throw new RuntimeException("not yet implemented");
	}
	
	@Before
	private void Setup() throws Exception{
		mockMvc = MockMvcBuilders.standaloneSetup(label).build();

	}

//	@Test
//	public void testListLabels() throws Exception {
//		throw new RuntimeException("not yet implemented");
//	}

	@Test
	public void testGet() throws Exception {
		//throw new RuntimeException("not yet implemented");
	    mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:8080/label")).andExpect(MockMvcResultMatchers.status().isOk()); 
	}

//	@Test
//	public void testDelete() throws Exception {
//		throw new RuntimeException("not yet implemented"); 
//	}
//
//	@Test
//	public void testUpdateLabelName() throws Exception {
//		throw new RuntimeException("not yet implemented");
//	}

}

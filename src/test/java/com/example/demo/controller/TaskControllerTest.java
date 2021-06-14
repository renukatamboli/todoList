package com.example.demo.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import com.example.demo.model.Task;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringJUnit4ClassRunner.class)
public class TaskControllerTest {

	@InjectMocks
	private Task task;

	private MockMvc mockMvc;
	
	@Before
	private void Setup() throws Exception{
		mockMvc = MockMvcBuilders.standaloneSetup(task).build();

	}
	
	@Test
	public void testGet() throws Exception {
		//throw new RuntimeException("not yet implemented");
		 mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:8080/tasks/8")).andExpect(MockMvcResultMatchers.status().isOk());
	}

}

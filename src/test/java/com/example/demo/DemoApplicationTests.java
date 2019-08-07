package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class DemoApplicationTests {
	@Autowired
	private MockMvc mvc;

	@Test
	public void contextLoads() throws Exception {
		this.mvc.perform(get("/timestamp")).andExpect(status().isOk())
					.andExpect(content().contentType(MediaType.APPLICATION_JSON))

				.andExpect(content().string("{\"timestamp\":\"2019-08-07T08:49:40.567+0000\",\"status\":404,\"error\":\"Not Found\",\"message\":\"No message available\",\"path\":\"/hello\"}\n"))
				.andDo(MockMvcResultHandlers.print());
	}

	@Test
	public void say() throws Exception{
		this.mvc.perform(get("/saytimestamp"))
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(content().string("AAA")).andDo(MockMvcResultHandlers.print());
	}



}

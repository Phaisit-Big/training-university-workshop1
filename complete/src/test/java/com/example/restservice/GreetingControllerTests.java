package com.example.restservice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

@AutoConfigureMockMvc
@SpringBootTest(classes=MainApplication.class)
public class GreetingControllerTests {

	@Autowired
	private MockMvc mockMvc;


	@Test
	public void hiWithNickname_shouldReturnJSONWithNicknameField() throws Exception {


		MvcResult result = this.mockMvc.perform(get("/greeting/hi").param("nickname", "Spring Test"))//.andDo(print())
				.andExpect(status().isOk()).andExpect(jsonPath("$.nickname").value("Spring Test"))
				.andReturn();

		String content = result.getResponse().getContentAsString();
		JSONObject jsonObject = new JSONObject(content);
		
		assertEquals("Spring Test", jsonObject.getString("nickname"));
		assertTrue(jsonObject.getString("id").matches("[0-9]+"));

	}


	@Test
	public void hello_shouldReturnDefaultMessage() throws Exception {

		MvcResult result = this.mockMvc.perform(get("/greeting/hello"))//.andDo(print())
				.andExpect(status().isOk())//.andExpect(jsonPath("$.message").value("Hello, World!"))
				.andReturn();

		String content = result.getResponse().getContentAsString();
		JSONObject jsonObject = new JSONObject(content);

		assertEquals("Hello, World!", jsonObject.getString("message"));
		assertTrue(jsonObject.getString("id").matches("[0-9]+"));

	}

	@Test
	public void helloWithNickname_shouldReturnFormattedMessage() throws Exception {


		MvcResult result = this.mockMvc.perform(get("/greeting/hello").param("nickname", "Spring Test"))//.andDo(print())
				.andExpect(status().isOk())
				.andReturn();

		String content = result.getResponse().getContentAsString();
		JSONObject jsonObject = new JSONObject(content);
		
		assertEquals("Hello, Spring Test!", jsonObject.getString("message"));
		assertTrue(jsonObject.getString("id").matches("[0-9]+"));

	}

}

/*
 * Copyright 2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *	  https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
	public void bye_shouldReturnByeBye() throws Exception {

		MvcResult result = this.mockMvc.perform(get("/bye"))//.andDo(print())
				.andExpect(status().isOk())
				.andReturn();

		String content = result.getResponse().getContentAsString();

		assertEquals("<H1>Bye Bye</H1>", content);


	}

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

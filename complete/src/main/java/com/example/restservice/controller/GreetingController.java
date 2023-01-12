package com.example.restservice.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.restservice.model.Greeting;


@Controller
public class GreetingController {

	private final AtomicLong COUNTER = new AtomicLong();

	private final String MESSAGE_TEMPLATE = "Hello, %s!";


	@RequestMapping(path="/greeting/hi", method=RequestMethod.GET)
	public @ResponseBody Map<String, Object> hi(@RequestParam(value="nickname") String name) {

		Map<String, Object> map = new TreeMap<String, Object>();
		map.put("id", 1);
		map.put("nickname", name);

		return map;
	}

	
	@RequestMapping(path="/greeting/hello", method=RequestMethod.GET)
	public @ResponseBody Greeting hello(@RequestParam(value="nickname", defaultValue="World") String name) {
		System.out.println("Processing /greeting/hello ....");

		String message = String.format(MESSAGE_TEMPLATE, name);
		return new Greeting(COUNTER.incrementAndGet(), message);
		
		//return new Greeting(counter.incrementAndGet(), "Hello, World!");
	}	

}

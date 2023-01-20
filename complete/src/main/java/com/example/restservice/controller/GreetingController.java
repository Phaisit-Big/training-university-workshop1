package com.example.restservice.controller;

import java.util.Map;
import java.util.TreeMap;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class GreetingController {


	/*
	 * handle GET request for the url /greeting/hi
	 * 
	 * @param nickname - a query string parameter to show in the JSON response
	 * @return a JSON with id field and nickname field corresponding to the parameter
	 */
	@RequestMapping(path="/greeting/hi", method=RequestMethod.GET)
	public @ResponseBody String hi(@RequestParam(value="nickname", defaultValue="") String name) {

		return "Hi " + name;
	}

	/*
	 * handle GET request for the url /greeting/hello
	 * 
	 * @param nickname - a query string parameter to show in the JSON response. the default value is "World".
	 * @return a JSON from a Greeting object with a running id field and message "Hello " following with the nickname parameter
	 */
	// @...  TODO: Add your code here

}

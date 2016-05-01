package com.arvind.home.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DemoController {

	@RequestMapping(value="/login1")
	public String home() {
		return "working.html";
	}
	
}

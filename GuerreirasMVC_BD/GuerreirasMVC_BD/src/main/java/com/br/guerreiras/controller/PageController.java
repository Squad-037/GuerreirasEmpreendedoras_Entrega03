package com.br.guerreiras.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class PageController {
	
//	@RequestMapping("/home")
//	public String home(){
//		return "index";
//	}
	
	@RequestMapping("/inspire")
	public String inspire(){
		return "inspired";
	}
	
	@RequestMapping("/curso")
	public String curso(){
		return "course";
	}

}

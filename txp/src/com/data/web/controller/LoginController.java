package com.data.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="login")
public class LoginController {

	@RequestMapping(value="login")
	public ModelAndView login(){
		ModelAndView mView = new ModelAndView("login");
		return mView;
	}
}

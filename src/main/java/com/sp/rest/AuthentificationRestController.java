package com.sp.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sp.model.UserDB;
//import com.sp.model.Auth;
import com.sp.service.AuthentificationService;

@RestController
public class AuthentificationRestController {
	
	@Autowired
	AuthentificationService aService;
	
	@RequestMapping(method=RequestMethod.POST, value="/login")
	public int login(@RequestBody UserDB user) {
		return aService.login(user);
	}

}

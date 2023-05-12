package com.sp.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sp.model.UserDB;
import com.sp.service.UserService;

@RestController
public class UserRestControlleur {

    @Autowired
    UserService uService;
	
	@RequestMapping(method=RequestMethod.POST,value="/register")
	public void addUser(@RequestBody UserDB user) {
		uService.addUser(user);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/user")
	public void getUser(@RequestBody UserDB user) {
		uService.getUserId(user);
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/wallet/{id}")
	public void getWallet(@PathVariable String id) {
		UserDB user = uService.getUser(Integer.valueOf(id));
		uService.getWallet(user);
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/wallet")
	public void changeWallet(@RequestBody UserDB user, int amount) {
		uService.changeWallet(user, amount);
	}

}

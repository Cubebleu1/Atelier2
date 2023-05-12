package com.sp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.sp.model.UserDB;

import com.sp.service.UserService;

@Service
public class AuthentificationService {
	
	@Autowired
	UserService uService;
	
	public int login(UserDB user) {
		return uService.getUserId(user);
	}

}

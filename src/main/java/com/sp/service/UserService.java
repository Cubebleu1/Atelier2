package com.sp.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sp.model.UserDB;
import com.sp.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository uRepository;
	@Autowired
	CardService cServ;

	public void addUser(UserDB u) {
		Set<Integer> maliste = (Set<Integer>) u.getIdList();
		//maliste = cServ.create5RandCard(u.getId());
		//u.setIdList(maliste);
		UserDB createdUser=uRepository.save(u);
		// Liste de 5 entiers = CardService.gene5cartes()
		// Set l'attribut idList de User (vide de base)
		System.out.println(createdUser);
	}

	public int getUserId(UserDB u) {
		String username = u.getUsername();
		UserDB myuser = uRepository.findByUsername(username);
		if (myuser != null) {
			return myuser.getId();
		}
		else {
			return -1;
		}
	}
	
	
	public UserDB getUser(int id) {
		Optional<UserDB> cOpt = uRepository.findById(id);
		if (cOpt.isPresent()) {
			return cOpt.get();
		}
		else {
			return null;
		}
	}
	

	public int getWallet(UserDB u) {
		String username = u.getUsername();
		UserDB myuser = uRepository.findByUsername(username);
		return myuser.getWallet();
	}

	public void changeWallet(UserDB u, int amount) {
		String username = u.getUsername();
		UserDB myuser = uRepository.findByUsername(username);
		myuser.setWallet(amount);
	}

}

package com.app.main.serviceImplement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.main.model.Users;
import com.app.main.repository.ProfileRepository;
import com.app.main.service.ProfileService;

@Service
public class ProfileServiceImpl implements ProfileService{

	@Autowired
	ProfileRepository profileRepository;
	
	@Override
	public void saveUserDetails(Users userDetails) {
		
		profileRepository.save(userDetails);		
	}
	
	@Override
	public Users loginCheck(String phonenumber, String password) {
		
		Users user = profileRepository.findAllByPhonenumberAndPassword(phonenumber, password);
		return user;
	}

	@Override
	public Users editUserDetails(int userid) {
		
		Users user = profileRepository.findById(userid);
		return user;
	}
}

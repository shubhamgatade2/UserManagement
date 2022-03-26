package com.app.main.service;

import com.app.main.model.Users;

public interface ProfileService {

	void saveUserDetails(Users s);
	
	Users loginCheck(String phonenumber, String password);
	
	Users editUserDetails(int userid);
}

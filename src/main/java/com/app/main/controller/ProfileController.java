package com.app.main.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.main.model.Users;
import com.app.main.service.ProfileService;

@RestController
public class ProfileController {
    
	@Autowired
	ProfileService profileService;
	
	/* The method register(user) is defined to register new user. This method has Users object argument. 
	 * ModelAttribute annotation collects the input data from Rest API calls. */
	
	@PostMapping(value = "/register")
	public String register(@ModelAttribute("userdetails")Users users) throws SQLException
	{ 
		String inputEmail=users.getEmailaddress();
		String inputNumber=users.getPhonenumber();
		String inputPassword=users.getPassword();
		
		final String emailregex = "^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$";
		final String phoneregex = "[7-9]{1}[0-9]{9}";
		final String passwordregex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,15}$";
		
		if(inputEmail.matches(emailregex))
		{
			if(inputNumber.matches(phoneregex))
			{
				if(inputPassword.matches(passwordregex))
				{
					Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/usermanagement", "root", "root");
					Statement statement = connection.createStatement();

			        String query = "select * from users where emailaddress='"+inputEmail+"' OR phonenumber='"+inputNumber+"'";
			        ResultSet resultSet = statement.executeQuery(query);

			        if(resultSet.next()) 
			        {        	
			        	return "Email Address or Phone Number already exists";
			        }
			        
			        else 
			        {        	
				    	users.setPassword(Base64.getEncoder().encodeToString(inputPassword.getBytes()));
						profileService.saveUserDetails(users);
						
						return "User Details saved successfully";
			        }	
				}
				else
				{
					return "Password pattern is incorrect";
				}
			}
			else
			{
				return "Phone Number must be 10 digits starting with 7/8/9";
			}
		}
		else
		{
			return "Invalid Email address. Should be in the form of abc@domain.com";
		}
	}
	
	/* loginCheck Method defined to allow user to login and access their profile. 
	 * It takes phone number and password as inputs.
	 * Password has been encrypted using base64 encoder. */
	
	@GetMapping(value = "/login")
	public Users loginCheck(@RequestParam("phonenumber")String phonenumber,@RequestParam("password")String password)
	{
		password=Base64.getEncoder().encodeToString(password.getBytes());
		Users user=profileService.loginCheck(phonenumber, password);
		return user;		
	}
	
	/* Method to allow user to make changes and update their profile. */
	
	@PatchMapping(value = "/updateuser/{userid}")
	public Users updateUser(@PathVariable("userid")int userid, @ModelAttribute("userdetails")Users user)
	{
		Users oldUser=profileService.editUserDetails(userid);
		oldUser.setFirstname(user.getFirstname());
		oldUser.setLastname(user.getLastname());
		oldUser.setEmailaddress(user.getEmailaddress());
		oldUser.setPhonenumber(user.getPhonenumber());
		oldUser.setPassword(user.getPassword());
		profileService.saveUserDetails(oldUser);
		
		return oldUser;
	}
}

package com.app.main.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class Users {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "userid", nullable = false)
	private int userid;
	
	@Column(length = 15, nullable = false)
	private String firstname;
	
	@Column(length = 15, nullable = false)
	private String lastname;
	
	/* Email REGEX  = ^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$ */
	@Column(length = 25, unique=true, nullable = false)
	private String emailaddress;
	
	/* Phone Number REGEX = [7-9]{1}[0-9]{9} 
	 Requirements - Exact 10 digits starting with 7/8/9. 
	 */
	
	@Column(length = 10, unique=true, nullable = false)
	private String phonenumber;
	
	/* Password REGEX = ^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,15}$
	Password Requirements - 
		At least one upper case English letter
		At least one lower case English letter
		At least one digit
		At least one special character
		Minimum 8 and maximum 15 in length
	 */
	
	@Column(length = 15, nullable = false)
	private String password;
	
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmailaddress() {
		return emailaddress;
	}
	public void setEmailaddress(String emailaddress) {
		this.emailaddress = emailaddress;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}

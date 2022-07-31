package com.flight.main.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Users {

	private String usertype;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int userid;
	
	private String username;
	
	private String userpassword;
	
	private int userphone;
	
	private String email;
	
	

	public Users() {
		super();
	}

	public Users(String usertype, int userid, String username, String userpassword, int userphone, String email) {
		super();
		this.usertype = usertype;
		this.userid = userid;
		this.username = username;
		this.userpassword = userpassword;
		this.userphone = userphone;
		this.email = email;
	}

	public String getUsertype() {
		return usertype;
	}

	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserpassword() {
		return userpassword;
	}

	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
	}

	public int getUserphone() {
		return userphone;
	}

	public void setUserphone(int userphone) {
		this.userphone = userphone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Users [usertype=" + usertype + ", userid=" + userid + ", username=" + username + ", userpassword="
				+ userpassword + ", userphone=" + userphone + ", email=" + email + "]";
	}
	
	
}

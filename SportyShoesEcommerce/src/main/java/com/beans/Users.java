package com.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class Users {
	@Id
	@Column(name="name")
	private String name;
	
	@Column(name="pass")
	private String pass;
	
	@Column(name="email")
	private String email;
	
	@Column(name="city")
	private String city;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Users(String name, String pass, String email, String city) {
		super();
		this.name = name;
		this.pass = pass;
		this.email = email;
		this.city = city;
	}

	@Override
	public String toString() {
		return "Users [name=" + name + ", pass=" + pass + ", email=" + email + ", city=" + city + "]";
	}

	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}

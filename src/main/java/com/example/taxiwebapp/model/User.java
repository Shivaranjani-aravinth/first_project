package com.example.taxiwebapp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Column(name = "first_name")
    private String first_name;
	
	@Column(name = "last_name")
    private String last_name;
	
	@Id
    @Column(name = "username")
    private String username;
	
	@Column(name = "password")
    private String password;
	
	@Column(name = "mailid")
    private String mailid;
	
	@Column(name = "phoneno")
    private long phoneno;
	
	public User()
	{
		
	}

	public User(String first_name, String last_name, String username, String password, String mailid, long phoneno) {
		super();
		this.username = username;
		this.first_name = first_name;
		this.last_name = last_name;
		this.password = password;
		this.mailid = mailid;
		this.phoneno = phoneno;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMailid() {
		return mailid;
	}

	public void setMailid(String mailid) {
		this.mailid = mailid;
	}

	public long getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(long phoneno) {
		this.phoneno = phoneno;
	}
	

}

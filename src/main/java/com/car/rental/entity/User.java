package com.car.rental.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="user")
public class User {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int _id;
	
	@Column(name="fname")
	private String fname;
	@Column(name="lname")
	private String lname;
	@Column(name="dob")
	private LocalDate dob;
	@Column(unique = true, name="email")
	private String email;
	@Column(name="password")
	private String password;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(int _id, String fname, String lname, LocalDate dob, String email, String password) {
		super();
		this._id = _id;
		this.fname = fname;
		this.lname = lname;
		this.dob = dob;
		this.email = email;
		this.password = password;
	}

	public int get_id() {
		return _id;
	}

	public void set_id(int _id) {
		this._id = _id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [_id=" + _id + ", fname=" + fname + ", lname=" + lname + ", dob=" + dob + ", email=" + email
				+ ", password=" + password + "]";
	}

	
}
	
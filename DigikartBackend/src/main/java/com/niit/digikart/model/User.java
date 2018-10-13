package com.niit.digikart.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {
@Id
@GeneratedValue
private int userid;
private String username;
private String address;
private String dateOf;
private String email;
private String password;
private String role;
private boolean enabled;
public boolean isEnabled() {
	return enabled;
}
public void setEnabled(boolean enabled) {
	this.enabled = enabled;
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
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}

public String getDateOf() {
	return dateOf;
}
public void setDateOf(String dateOf) {
	this.dateOf = dateOf;
}
public String getEmail() {
	return email;
}
public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
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

}

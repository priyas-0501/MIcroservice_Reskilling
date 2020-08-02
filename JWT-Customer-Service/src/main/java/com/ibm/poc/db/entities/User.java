package com.ibm.poc.db.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ibm.poc.dto.UserResponseDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "user")
@NoArgsConstructor
@AllArgsConstructor
public class User implements DtoConvertor< UserResponseDTO>{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	private String firstName;
	private String lastName;
	private String loginId;
	private String password;
	private boolean active;
	private String role;
	
	
	@Override
	public UserResponseDTO getDto() {
		UserResponseDTO d = new UserResponseDTO();
		d.setActive(this.active);
		d.setFirstName(this.firstName);
		d.setLastName(this.lastName);
		d.setLoginId(this.loginId);
		d.setPassword(this.password);
		d.setRole(this.role);
		d.setUserId(this.userId);
		return d;
	}
	
	public User()
	{
		
	}
	public User(int id, String firstName, String lastName, String loginId, String password,boolean active, String role)
	{
		this.userId=id; 
		this.firstName=firstName;
		this.lastName=firstName; 
		this.loginId=loginId; 
		this.password=password;
		this.active=active;
		this.role=role;
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getLoginId() {
		return loginId;
	}


	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public boolean isActive() {
		return active;
	}


	public void setActive(boolean active) {
		this.active = active;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}
	
}

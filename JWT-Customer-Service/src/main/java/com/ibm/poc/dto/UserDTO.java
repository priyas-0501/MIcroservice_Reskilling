package com.ibm.poc.dto;

import com.ibm.poc.db.entities.EntityConverter;
import com.ibm.poc.db.entities.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO implements EntityConverter<User> {
	
	protected String firstName;
	protected String lastName;
	protected String loginId;
	protected String password;
	protected boolean active;
	protected String role;
	
	@Override
	public User getEntity(int id) {
		return new User(id, this.firstName, this.lastName, this.loginId, this.password,this.active, this.role);
	}
}

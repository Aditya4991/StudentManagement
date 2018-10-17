package com.mindtree.dto;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

@Component
public class StudentDTO {
	@NotNull
	private String firstName;
	private String lastName;
	private String emailId;
	
	public StudentDTO() {
		// TODO Auto-generated constructor stub
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
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
}

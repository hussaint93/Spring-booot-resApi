package com.tcs.springbootdemo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Email
	private String email;
	
	@NotBlank
	private String firstName;

	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", firstName=" + firstName + "]";
	}

	
}

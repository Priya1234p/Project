package com.emss.Dto;

import java.time.LocalDate;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Future;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


public class UserRequestDTO {
	
	@Size(min=2, message = "name should be atleast 2 characters")
	@NotBlank
	private String name;
	@Email
	private String email;
	@Size(min=10,max=10, message="mobile number should be atleast 10 digits")
	private String mobile;
	@Future(message = "Appointment date must be in the future")
	private LocalDate appointmentDate;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public LocalDate getAppointmentDate() {
		return appointmentDate;
	}
	public void setAppointmentDate(LocalDate appointmentDate) {
		this.appointmentDate = appointmentDate;
	}
	
	

}

package com.app.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserDto {
	private int userId;

	private String name;

	private String email;

	private String password;

	private String address;

	private String about;
	private String gender;
	private String phone;

	private Date date;
	private boolean active;
	
	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
}

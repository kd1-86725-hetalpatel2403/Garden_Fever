package com.app.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.dto.UserDto;
import com.app.entities.User;
import com.app.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepo;

	@Autowired
	private ModelMapper mapper;

	//@Autowired
	//private PasswordEncoder passwordEncoder;
	
	
	public UserDto create(UserDto userDto) {
		
		// userdto to user
		User user = this.mapper.map(userDto, User.class);
		
		String pass=user.getPassword();
		//String encodedPassword = this.passwordEncoder.encode(pass);
		//System.out.println("Ende: "+encodedPassword);
		//user.setPassword(encodedPassword);
		
		// save
		User saveUser = this.userRepo.save(user);
		// user to userdto

		// User saveUser=this.userRepository.save(user);
		UserDto saveUserDto = this.mapper.map(saveUser, UserDto.class);
		return saveUserDto;
	}

	public UserDto update(UserDto userDto, int userId) {
		User user = userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found by this id"));

		// Update user fields
		user.setPhone(userDto.getPhone());
		user.setPassword(userDto.getPassword());
		user.setName(userDto.getName());
		user.setGender(userDto.getGender());
		user.setEmail(userDto.getEmail());
		user.setDate(userDto.getDate());
		user.setAddress(userDto.getAddress());
		user.setActive(userDto.isActive());
		user.setAbout(userDto.getAbout());

		User updatedUser = this.userRepo.save(user);
		return this.toDto(updatedUser);
	}

	public void delete(int userId) {
		User user = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found by this id"));
		userRepo.delete(user);
	}

	public List<UserDto> getAll() {
		List<User> allUsers = userRepo.findAll();
		return allUsers.stream().map(this::toDto).collect(Collectors.toList());
	}

	public UserDto getById(int userId) {
		User foundUser = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found by this id: " + userId));

		return this.toDto(foundUser);
	}
	
	public UserDto toDto(User user) {
		return this.mapper.map(user, UserDto.class);
	}

	public UserDto getByEmailId(String emailId) {
		User foundUser = userRepo.findByEmail(emailId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found by email: " + emailId));
		return this.toDto(foundUser);
	}
}

package com.app.controller;

import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.dto.UserDto;
import com.app.service.UserService;

@RestController
@RequestMapping("/users")
@Controller
public class UserController {
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private UserService userService;
	 
	@PostMapping("/create")
	public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){
		//SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date=new Date();
		//formatter.format(date);
		userDto.setDate(date);
		//userDto.setActive(true);
		
		UserDto createUser=this.userService.create(userDto);
		return new ResponseEntity<UserDto>(createUser,HttpStatus.CREATED);
	}
	@GetMapping("findById/{userId}")
    public ResponseEntity<UserDto> findUserById(@PathVariable int userId) {
        UserDto userDto = this.userService.getById(userId);
        if (userDto != null) {
            return new ResponseEntity<>(userDto, HttpStatus.FOUND);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
	
	@DeleteMapping("/delete/{userId}")
	public ResponseEntity<String> deleteUser(@PathVariable int userId) {
	    try {
	        this.userService.delete(userId);
	        return new ResponseEntity<>("User deleted successfully", HttpStatus.OK);
	    } catch (ResourceNotFoundException e) {
	        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
	    }
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<UserDto>> getAllUsers() {
	    List<UserDto> users = this.userService.getAll();
	    if (!users.isEmpty()) {
	        return new ResponseEntity<>(users, HttpStatus.OK);
	    } else {
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }
	}

	@GetMapping("/findByEmail/{email}")
	public ResponseEntity<UserDto> findUserByEmail(@PathVariable String email) {
	    UserDto userDto = this.userService.getByEmailId(email);
	    if (userDto != null) {
	        return new ResponseEntity<>(userDto, HttpStatus.FOUND);
	    } else {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}
	
	@PutMapping("/update/{userId}")
    public ResponseEntity<UserDto> updateUser(@PathVariable int userId, @RequestBody UserDto updatedUserDto) {
        try {
            UserDto updatedUser = this.userService.update(updatedUserDto, userId);
            return new ResponseEntity<>(updatedUser, HttpStatus.OK);
        } catch (ResourceNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}

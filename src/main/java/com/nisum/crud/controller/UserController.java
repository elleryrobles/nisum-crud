package com.nisum.crud.controller;

import java.time.OffsetDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nisum.crud.dto.UserDto;
import com.nisum.crud.model.User;
import com.nisum.crud.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
    	
        List<User> users = userService.getAllUsers();
        
        return new ResponseEntity<>(users, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        
    	User user = userService.getUserById(id);
        
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
    	
    	User user = UserDto.CONVERTER_ENTITY.apply(userDto);
    	user.setActive(true);
    	user.setCreated(OffsetDateTime.now());
		user.setModified(OffsetDateTime.now());
    	
        User createdUser = userService.createUser(user);
        
        UserDto userResponse = UserDto.CONVERTER_DTO.apply(createdUser);
        
        return new ResponseEntity<>(userResponse, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable Long id, @RequestBody User user) {
    	
    	User updatedUser = userService.updateUser(id, user);
    	
    	UserDto userResponse = UserDto.CONVERTER_DTO.apply(updatedUser);
        
    	return new ResponseEntity<>(userResponse, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
    
    @PutMapping("/disable/{id}")
    public ResponseEntity<User> disableUser(@PathVariable Long id) {
    	
    	User userDisable = userService.disableUser(id);
    	
    	return new ResponseEntity<>(userDisable, HttpStatus.CREATED);
    }
    
    @PutMapping("/enable/{id}")
    public ResponseEntity<User> enableUser(@PathVariable Long id) {
    	
    	User userEnable = userService.enableUser(id);
        
    	return new ResponseEntity<>(userEnable, HttpStatus.CREATED);
    }

}

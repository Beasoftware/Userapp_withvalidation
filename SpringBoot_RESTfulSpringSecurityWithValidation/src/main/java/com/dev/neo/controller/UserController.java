package com.dev.neo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dev.neo.entity.UserMaster;
import com.dev.neo.serrvice.UserService;

@RestController
public class UserController {
	 @Autowired
	    private UserService userService;

	    @PostMapping("/adduser")
	    public UserMaster addUserDetails(@Valid @RequestBody UserMaster userMaster){

	        return userService.saveUserWithDetails(userMaster);
	    }

	    @GetMapping("/get/{userMasterId}")
	    public UserMaster fetchUserById(@PathVariable("userMasterId") int userMasterId){

	        return userService.findUserById(userMasterId);
	    }

	    @DeleteMapping("/delete/{userMasterId}")
	    public String deleteUserById(@PathVariable("userMasterId") int userMasterId){
	         userService.deleteUserById(userMasterId);
	         return " Delete successfully!!!";
	    }

	    @PutMapping("/put")
	    public UserMaster updateUserMaster(@RequestBody UserMaster userMaster){
	        return userService.updateUserMaster(userMaster);
	    }

	    @GetMapping("/search")
	    public ResponseEntity<List<UserMaster>> searchUserMaster(@RequestParam("query") String query){
	        return ResponseEntity.ok(userService.searchUserMaster(query));
	    }
}

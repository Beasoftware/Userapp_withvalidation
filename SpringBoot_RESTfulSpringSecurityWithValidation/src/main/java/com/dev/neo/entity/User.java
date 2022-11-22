package com.dev.neo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name= "user_tbl")
public class User {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "user_id")
    private int userId;
    private String username;
    private String password;
    private String role;
    
	public String getPassword() {
		
		return null;
	}
	public String getUsername() {
		
		return null;
	}
	public String getRole() {
		
		return null;
	}
}// end class

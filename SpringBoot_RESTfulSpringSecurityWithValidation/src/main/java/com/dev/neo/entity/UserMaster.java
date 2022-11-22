package com.dev.neo.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "usermaster_tbl")
public class UserMaster {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_master_id")
	private int userMasterId;
	
	@NotEmpty
	@Size(min = 2, message = "user firstname should have at least 2 characters")
	private String firstName;

	@NotEmpty
	@Size(min = 2, message = "user last should have at least 2 characters")
	private String lastName;

	// email should be a valid email format
	// email should not be null or empty
	@NotEmpty
	@Email
	private String emailId;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "contact_id")
	private List<UserContact> contacts;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private User user;

}// end class

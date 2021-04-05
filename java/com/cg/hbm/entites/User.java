package com.cg.hbm.entites;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
/**
 * 
 * @author Navin Kumar
 *
 */

@Entity
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int user_id;
	private String user_name;
	private String email;
	private String password;
	private String role;
	private String mobile;
	private String address;
	
	
	public User() {
		super();
	}
	/**
	 * 
	 * @param user_name
	 * @param email
	 * @param password
	 * @param role
	 * @param mobile
	 * @param address
	 */
	
	
	public User(String user_name, String email, String password, String role, String mobile,
			String address) {
		super();
		//this.user_id=user_id;
		this.user_name = user_name;
		this.email = email;
		this.password = password;
		this.role = role;
		this.mobile = mobile;
		this.address = address;
	}
	/**
	 * 
	 * @return int
	 */


	public int getUser_id() {
		return user_id;
	}
	/**
	 * 
	 * @param user_id
	 */

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	/**
	 * 
	 * @return String
	 */

	public String getUser_name() {
		return user_name;
	}
	/**
	 * 
	 * @param user_name
	 */


	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	/**
	 * 
	 * @return String
	 */

	public String getEmail() {
		return email;
	}
	/**
	 * 
	 * @param email
	 */

	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * 
	 * @return String
	 */


	public String getPassword() {
		return password;
	}
	/**
	 * 
	 * @param password
	 */

	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * 
	 * @return String
	 */

	public String getRole() {
		return role;
	}
	/**
	 * 
	 * @param role
	 */

	public void setRole(String role) {
		this.role = role;
	}
	/**
	 * 
	 * @return String
	 */

	public String getMobile() {
		return mobile;
	}
	/**
	 * 
	 * @param mobile
	 */

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	/**
	 * 
	 * @return String
	 */

	public String getAddress() {
		return address;
	}
	/**
	 * 
	 * @param address
	 */

	public void setAddress(String address) {
		this.address = address;
	}
	
}

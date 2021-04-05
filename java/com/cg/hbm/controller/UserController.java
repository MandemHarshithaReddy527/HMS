package com.cg.hbm.controller;

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
import com.cg.hbm.entites.User;
import com.cg.hbm.exceptions.UserNotFoundException;
import com.cg.hbm.service.IUserService;
/**
 * 
 * @author Navin Kumar
 *
 */

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	IUserService uService;
	/**
	 * 
	 * @param user
	 * @return User
	 * @throws UserNotFoundException
	 */
	
	@PostMapping("/add")
	public ResponseEntity<User> addUser(@RequestBody User user) throws UserNotFoundException  {
		User resultUser=uService.addUser(user);
		return new ResponseEntity<User>(resultUser,HttpStatus.OK) ;
	}
	/**
	 * 
	 * @param user_id
	 * @return User
	 * @throws UserNotFoundException
	 */
	@DeleteMapping("/{user_id}")
	public User removeUser(@PathVariable int user_id) throws UserNotFoundException {
		return uService.removeUser(user_id);
	}
	/**
	 * 
	 * @param user
	 * @return User
	 * @throws UserNotFoundException
	 */
	@PutMapping("/user")
	public ResponseEntity<User> updateUser(@RequestBody User user) throws UserNotFoundException {
		User resultUser = uService.updateUser(user.getUser_id(),user);
		return new ResponseEntity<User>(resultUser, HttpStatus.OK);
	}
	/**
	 * 
	 * @return list of users
	 * @throws UserNotFoundException
	 */
	@GetMapping("/all")
	public ResponseEntity<List<User>> showAllUsers() throws UserNotFoundException{
		List<User> resultUser=uService.showAllUsers();
		return new ResponseEntity<List<User>>(resultUser, HttpStatus.OK);
	}
	/**
	 * 
	 * @param user_id
	 * @return User
	 * @throws UserNotFoundException
	 */
	@GetMapping("/{user_id}")
	public ResponseEntity<User> showUser(@PathVariable int user_id) throws UserNotFoundException {
		User h=uService.showUser(user_id);
		if(h!=null) {
			return new ResponseEntity<User>(h,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
		
	}
}
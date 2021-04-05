package com.cg.hbm.controller;
import com.cg.hbm.entites.Admin;
import com.cg.hbm.util.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * 
 * @author Lasya
 *
 */

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private LoginService ls;
	/**
	 * 
	 * @param admin_id
	 * @param password
	 * @return String
	 */

	@GetMapping("/admin/{admin_id}/{password}")
	public String validateAdmin(@PathVariable("admin_id") int admin_id, @PathVariable("password") String password) {
		Admin admin = new Admin();
		admin.setAdmin_id(admin_id);
		admin.setPassword(password);
		return ls.validateCredintals(admin);
	}
	


}
	



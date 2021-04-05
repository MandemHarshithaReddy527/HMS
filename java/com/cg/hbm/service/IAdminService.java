package com.cg.hbm.service;
import com.cg.hbm.entites.Admin;
/**
 * 
 * @author Lasya
 *
 */
public interface IAdminService {
	public Admin signIn(Admin admin);
	public Admin signOut(Admin admin);
	
}

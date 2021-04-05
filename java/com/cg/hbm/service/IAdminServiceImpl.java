package com.cg.hbm.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.cg.hbm.dao.IAdminRepository;
import com.cg.hbm.entites.*;
/**
 * 
 * @author Lasya
 *
 */

@Service
public class IAdminServiceImpl implements IAdminService {

	@Autowired
	private IAdminRepository loginRepository;
	
	@Override
	public Admin signIn(Admin admin) {
		Admin admin1  = loginRepository.saveAndFlush(admin);
		return admin1;
	}

	@Autowired
	private IAdminRepository logoutRepository;

	@Override
	public Admin signOut(Admin admin) {
		logoutRepository.delete(admin);
		return admin;
	}

	
}

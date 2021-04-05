package com.cg.hbm.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.cg.hbm.entites.Payments;

@Repository
/************************************************************************************
 *@author          	Keerthi
 *Description      	It is a Data Access Object(DAO) Interface which extends Jpa repository 
 					for using CRUD operations.  
 *Version          	1.0
 *Created Date    	31-MAR-2021
 ************************************************************************************/
public interface IPaymentRepository extends JpaRepository<Payments,Integer >{

	
	
	
//	public Payments addPayment(Payments payment);
	
	
}

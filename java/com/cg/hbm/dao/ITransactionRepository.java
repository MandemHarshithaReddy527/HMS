package com.cg.hbm.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import com.cg.hbm.entites.Transactions;
/************************************************************************************
 *@author          	KV Prasad
 *Description      	It is a Data Access Object(DAO) Interface which extends Jpa repository 
 					for using CRUD operations.  
 *Version          	1.0
 *Created Date    	31-MAR-2021
 ************************************************************************************/

public interface ITransactionRepository extends JpaRepository<Transactions,Integer >{
	//public Transactions addTransaction(Transactions transaction);
}

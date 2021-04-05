package com.cg.hbm.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cg.hbm.entites.BookingDetails;

/************************************************************************************
 *@author          	Harshitha
 *Description      	It is a Data Access Object(DAO) Interface which extends the Jpa repository 
 					for using CRUD operations.  
 *Version          	1.0
 *Created Date    	31-MAR-2021
 ************************************************************************************/

@Repository
public interface IBookingDetailsRepository extends JpaRepository<BookingDetails, Integer> {
	
}

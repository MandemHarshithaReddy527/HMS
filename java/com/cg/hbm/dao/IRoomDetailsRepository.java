/*package com.cg.hbm.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.hbm.entites.RoomDetails;

@Repository
public interface IRoomDetailsRepository extends JpaRepository<RoomDetails,Integer >{

	
	
}*/
package com.cg.hbm.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cg.hbm.entites.RoomDetails;
/************************************************************************************
 *@author          	Mahendra
 *Description      	It is a Data Access Object(DAO) Interface which extends Jpa repository 
 					for using CRUD operations.  
 *Version          	1.0
 *Created Date    	31-MAR-2021
 ************************************************************************************/

@Repository
public interface IRoomDetailsRepository extends JpaRepository<RoomDetails, Integer>{

}

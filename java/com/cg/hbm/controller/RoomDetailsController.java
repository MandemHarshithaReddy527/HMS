//package com.cg.hbm.controller;



/*import java.util.List;

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

import com.cg.hbm.entites.RoomDetails;
import com.cg.hbm.exceptions.UserNotFoundException;
import com.cg.hbm.service.IRoomDetailsService;

@RestController
@RequestMapping("/roomdetails")
public class RoomDetailsController {
	
	@Autowired
	IRoomDetailsService rdService;
	
	@PostMapping
	public List<RoomDetails> addRoomDetails(@RequestBody RoomDetails roomDetails) {
		return rdService.addRoomDetails(roomDetails);
		
	}

	@PutMapping
	public RoomDetails updateRoomDetails(@RequestBody RoomDetails roomDetails) {
		
		return rdService.updateRoomDetails(roomDetails);
	}

	@DeleteMapping("/{room_id}")
	public List<RoomDetails> removeRoomDetails(@PathVariable int room_id) {
		return rdService.removeRoomDetails(room_id);
	}

	@GetMapping
	public List<RoomDetails> showAllRoomDetails() {
		
		return rdService.showAllRoomDetails();
	}

	@GetMapping("/{room_id}")
	public ResponseEntity<RoomDetails> viewUser(@PathVariable("room_id")int userid) throws UserNotFoundException {
		RoomDetails rd =  rdService.showRoomDetails(userid);
		if(rd!=null) {
			return new ResponseEntity<RoomDetails>(rd,HttpStatus.OK);
		}
		else {
			return  new ResponseEntity<RoomDetails>(HttpStatus.NOT_FOUND);
		}
	}

}*/
/*package com.cg.hbm.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.hbm.entites.RoomDetails;
import com.cg.hbm.exceptions.RoomDetailsNotFoundException;
import com.cg.hbm.service.IRoomDetailsService;
@RestController
@RequestMapping("/room")
public class RoomDetailsController {
	@Autowired
	IRoomDetailsService iSer;
	
	/**
	 * 
	 * 
	 * @param roomDetails
	 * @return
	 */
	
	/*@PostMapping("/add")
	public RoomDetails addRoomDetails(@RequestBody RoomDetails roomDetails) {
		return iSer.addRoomDetails(roomDetails);
	}
	
	/**
	 * 
	 * 
	 * @param roomDetails
	 * @return
	 */
	
	/*@PutMapping("/update")
	public RoomDetails updateRoomDetails(@RequestBody RoomDetails roomDetails) {
		return iSer.updateRoomDetails(roomDetails);
	}
	
	
	/**
	 * 
	 * 
	 * 
	 * @param roomDetails
	 * @return
	 * @throws RoomDetailsNotFoundException
	 */
	/*@DeleteMapping("/remove")
	public RoomDetails removeRoomDetails(@RequestBody RoomDetails roomDetails)throws RoomDetailsNotFoundException {
	
		try {
		return iSer.removeRoomDetails(roomDetails);
		}catch(Exception e)
     	{
		throw new RoomDetailsNotFoundException("room_id not available please enter a valid number");
	    }
	}
	
	
	/**
	 * 
	 * 
	 * 
	 * @return
	 */
	/*@GetMapping("/all")
	public List<RoomDetails> showAllRoomDetails(){
		return iSer.showAllRoomDetails();
	}
	
	/**
	 * 
	 * 
	 * @param roomDetails_id
	 * @return
	 * @throws RoomDetailsNotFoundException
	 */
	
	/*@GetMapping("/{roomDetails_id}")
	public RoomDetails showRoomDetails(@PathVariable int roomDetails_id)throws RoomDetailsNotFoundException {
		
		try {
		return iSer.showRoomDetails(roomDetails_id);
		}catch(Exception e)
		{
			throw new RoomDetailsNotFoundException("roomid not available.....give valid number");
		}
		}
	
}*/
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
import com.cg.hbm.entites.RoomDetails;
import com.cg.hbm.exceptions.RoomDetailsNotFoundException;
import com.cg.hbm.service.IRoomDetailsService;
/**
 * 
 * @author Mahendra
 *
 */

@RestController
@RequestMapping("/room_details")
public class RoomDetailsController {
	@Autowired
	IRoomDetailsService rService;
	/**
	 * 
	 * @param roomDetails
	 * @return RoomDetails
	 * @throws HotelNotFoundException
	 */
	
	@PostMapping("/add")
	public ResponseEntity<RoomDetails> addHotel(@RequestBody RoomDetails roomDetails) throws RoomDetailsNotFoundException  {
		RoomDetails resultRoomDetails=rService.addRoomDetails(roomDetails);
		return new ResponseEntity<RoomDetails>(resultRoomDetails,HttpStatus.OK) ;
	}
	/**
	 * 
	 * @param room_id
	 * @return RoomDetails
	 * @throws RoomDetailsNotFoundException
	 */
	@DeleteMapping("/{room_id}")
	public RoomDetails removeRoomDetails(@PathVariable int room_id) throws RoomDetailsNotFoundException {
		return rService.removeRoomDetails(room_id);
	}
	/**
	 * 
	 * @param roomDetails
	 * @return RoomDetails
	 * @throws RoomDetailsNotFoundException
	 */
	@PutMapping("/roomDetails")
	public ResponseEntity<RoomDetails> updateRoomDetails(@RequestBody RoomDetails roomDetails) throws RoomDetailsNotFoundException {
		RoomDetails resultRoomDetails = rService.updateRoomDetails(roomDetails.getRoom_id(),roomDetails);
		return new ResponseEntity<RoomDetails>(resultRoomDetails, HttpStatus.OK);
	}
	/**
	 * 
	 * @return list of roomdetails
	 * @throws RoomDetailsNotFoundException
	 */
	@GetMapping("/all")
	public ResponseEntity<List<RoomDetails>> showAllRoomDetails() throws RoomDetailsNotFoundException{
		List<RoomDetails> resultRoomDetails=rService.showAllRoomDetails();
		return new ResponseEntity<List<RoomDetails>>(resultRoomDetails, HttpStatus.OK);
	}
	/**
	 * 
	 * @param room_id
	 * @return RoomDetails
	 * @throws RoomDetailsNotFoundException
	 */
	@GetMapping("/{room_id}")
	public ResponseEntity<RoomDetails>showRoomDetails(@PathVariable int room_id) throws RoomDetailsNotFoundException {
		RoomDetails r=rService.showRoomDetails(room_id);
		if(r!=null) {
			return new ResponseEntity<RoomDetails>(r,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<RoomDetails>(HttpStatus.NOT_FOUND);
		}
		
	}

}
	



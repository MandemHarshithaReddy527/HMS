package com.cg.hbm.entites;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
/**
 * 
 * @author Mahendra
 *
 */
@Entity
@Table(name="room_details")
public class RoomDetails {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int room_id;
	private String room_no;
	private String room_type;
	private double rate_per_day;
	private boolean isAvailable;
	

	@ManyToOne(cascade= {CascadeType.ALL},fetch=FetchType.EAGER) 
	@JoinColumn(name="hotel_id",referencedColumnName="hotel_id")
	private Hotel hotel;
	 
	
	public RoomDetails() {
	}
	/**
	 * 
	 * @param room_no
	 * @param rate_per_day
	 * @param room_type
	 * @param isAvailable
	 * @param hotel
	 */
	
	public RoomDetails(String room_no, double rate_per_day, String room_type,
			boolean isAvailable,Hotel hotel) {
		super();
		this.room_no = room_no;
		this.room_type = room_type;
		this.rate_per_day = rate_per_day;
		this.isAvailable =isAvailable ;
		this.hotel=hotel;
	}
	/**
	 * 
	 * @return int
	 */

	public int getRoom_id() {
		return room_id;
	}
	/**
	 * 
	 * @param room_id
	 */

	public void setRoom_id(int room_id) {
		this.room_id = room_id;
	}
	/**
	 * 
	 * @return String
	 */

	public String getRoom_no() {
		return room_no;
	}
	/**
	 * 
	 * @param room_no
	 */

	public void setRoom_no(String room_no) {
		this.room_no = room_no;
	}
	/**
	 * 
	 * @return String
	 */

	public String getRoom_type() {
		return room_type;
	}
	/**
	 * 
	 * @param room_type
	 */

	public void setRoom_type(String room_type) {
		this.room_type = room_type;
	}
	/**
	 * 
	 * @return double
	 */

	public double getRate_per_day() {
		return rate_per_day;
	}
	/**
	 * 
	 * @param rate_per_day
	 */

	public void setRate_per_day(double rate_per_day) {
		this.rate_per_day = rate_per_day;
	}
	/**
	 * 
	 * @return boolean
	 */

	public boolean isAvailable() {
		return isAvailable;
	}
	/**
	 * 
	 * @param isAvailable
	 */

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	/**
	 * 
	 * @return Hotel
	 */

	
	public Hotel getHotel() {
		return hotel; 
	}
	/**
	 * 
	 * @param hotel
	 */
	  
	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
	 
	
	
}
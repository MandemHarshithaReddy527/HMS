package com.cg.hbm;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


import com.cg.hbm.entites.BookingDetails;
import com.cg.hbm.entites.Hotel;
import com.cg.hbm.entites.RoomDetails;
import com.cg.hbm.entites.User;
import com.cg.hbm.service.IBookingDetailsService;
@SpringBootTest
public class BookingDetailsTest extends AbstractTest {
	@Autowired
	IBookingDetailsService bService;
	
	
	@Override
	@BeforeEach
	public void setUp() {
		super.setUp();
	}
	
	@Test
	public void getShowAllBookingDetails() throws Exception {
		String uri = "/bookingdetails/all";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)).andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		BookingDetails bookingdetails[] = super.mapFromJson(content, BookingDetails[].class);
		assertEquals(50, bookingdetails[0].getNo_of_children());
	}
	/**
	 * 
	 * @throws Exception
	 */

	@Test
	public void addBookingDetails() throws Exception {
		String uri="/bookingdetails/add";
		
		Hotel hotel=new Hotel("Vijayawada","kennara", "gjhjhkjlmll","Best Hotel", 18,"manikonda@gmail.com", "9898986788", "9898984530", "SmartHotelManerva.com"
				);
		RoomDetails roomdetails=new RoomDetails("102",1300, "DoubleDelux",true,hotel);


		User user=new User("Varshitha","hars@gmail.com","varsha","searching", "9876543210","jhbjkhnhjk");
		Date currentdate=new Date();
		Date todate=new Date(currentdate.getTime()+(10000*60*60*24));
		BookingDetails bookingdetails=new BookingDetails(currentdate,todate,480, 100,40000, hotel,roomdetails,user);
		bookingdetails.setAmount(45000);
		bookingdetails.setBooked_from(currentdate);
		bookingdetails.setBooked_from(todate);
		bookingdetails.setNo_of_adults(450);
		bookingdetails.setNo_of_children(80);
		bookingdetails.setBooking_id(3);
		bookingdetails.setHotel(hotel);
		bookingdetails.setRoomdetails(roomdetails);
		bookingdetails.setUser(user);
		String inputJson=super.mapToJson(bookingdetails);
		MvcResult mvcResult=mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType. APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content=mvcResult.getResponse().getContentAsString(); 
		BookingDetails b=super.mapFromJson(content, BookingDetails.class);
		assertEquals(450,b.getNo_of_adults());
	}
	/**
	 * 
	 * @throws Exception
	 */
	@Test
	public void getBookingDetails() throws Exception {
		String uri = "/bookingdetails/26";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)).andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		BookingDetails bookingdetails = super.mapFromJson(content, BookingDetails.class);
		assertEquals(160, bookingdetails.getNo_of_adults());
	}
	
	@Test
	public void updateBookingDetails() throws Exception{
	String uri="/bookingdetails/54";
	String putUri="/bookingdetails/bookingdetails";
	MvcResult mvcResult=mvc.perform(MockMvcRequestBuilders.get(uri)).andReturn();
    int status=mvcResult.getResponse().getStatus();
    assertEquals(200, status);
    String content=mvcResult.getResponse().getContentAsString();
    BookingDetails b=super.mapFromJson(content, BookingDetails.class);
    b.setNo_of_adults(6);;
    b.setNo_of_children(2);;
    String inputJson = super.mapToJson(b);
	MvcResult mvcResult1=mvc.perform(MockMvcRequestBuilders.put(putUri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
    int status1 = mvcResult1.getResponse().getStatus();
    assertEquals(200,status1);
    String content1 = mvcResult1.getResponse().getContentAsString();
    BookingDetails bookingDetails=super.mapFromJson(content1, BookingDetails.class);
    assertEquals(6,bookingDetails.getNo_of_adults());
	assertEquals(2,bookingDetails.getNo_of_children());
	}
		

}

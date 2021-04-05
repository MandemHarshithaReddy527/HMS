package com.cg.hbm;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.cg.hbm.entites.Hotel;
import com.cg.hbm.service.IHotelService;
@SpringBootTest
public class HotelTest extends AbstractTest {
	@Autowired
	IHotelService hService;
	
	
	@Override
	@BeforeEach
	public void setUp() {
		super.setUp();
	}
	
	@Test
	public void getHotel() throws Exception {
		String uri = "/hotel/27";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)).andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		Hotel hotel = super.mapFromJson(content, Hotel.class);
		assertEquals("Delhi", hotel.getCity());
	}
	/**
	 * 
	 * @throws Exception
	 */
	@Test
	public void addHotel() throws Exception{
	Hotel hotel=new Hotel();

	hotel.setAddress("Gandhi Nagar");
	hotel.setCity("Gurgaon");
	hotel.setAvg_rate_per_day((double)1700);
	hotel.setDescription("Awesome Hotel");
	hotel.setEmail("kurr@gmail.com");
	hotel.setHotel_name("Bangar");
	hotel.setPhone1("9393158131");
	hotel.setPhone2("6789567845");
	hotel.setWebsite("udi.com");
	
	String uri="/hotel/add";
	String inputJson=super.mapToJson(hotel);
	MvcResult mvcResult=mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
    int status=mvcResult.getResponse().getStatus();
    assertEquals(200, status);
    String content=mvcResult.getResponse().getContentAsString();
    Hotel hotel1=super.mapFromJson(content, Hotel.class);
    assertEquals("Gurgaon",hotel1.getCity());
	}
	/**
	 * 
	 * @throws Exception
	 */
	@Test
	public void deleteHotel() throws Exception{
		 this.mvc.perform(MockMvcRequestBuilders.delete("/hotel/1").contentType(MediaType.APPLICATION_JSON_VALUE).accept(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isOk());
	}
	

	/*@Test
	public void removeHotel() throws Exception{
		String uri="/hotel/1";
		MvcResult mvcResult=mvc.perform(MockMvcRequestBuilders.get(uri)).andReturn();
	    int status=mvcResult.getResponse().getStatus();
	    assertEquals(200, status);
	    String content=mvcResult.getResponse().getContentAsString();
	    Hotel ho=super.mapFromJson(content, Hotel.class);
	    String delUri="/hotel/remove";
	    String inputJson = super.mapToJson(ho);
	    this.mvc.perform(MockMvcRequestBuilders.delete(delUri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andExpect(MockMvcResultMatchers.status().isOk());
	}
	/**
	 * 
	 * @throws Exception
	 */

	@Test
	public void updateHotel() throws Exception{
	String uri="/hotel/117";
	String putUri="/hotel/hotel";
	MvcResult mvcResult=mvc.perform(MockMvcRequestBuilders.get(uri)).andReturn();
    int status=mvcResult.getResponse().getStatus();
    assertEquals(200, status);
    String content=mvcResult.getResponse().getContentAsString();
    Hotel h=super.mapFromJson(content, Hotel.class);
    h.setHotel_name("Mayuri");
    h.setPhone1("6576578909");
    String inputJson = super.mapToJson(h);
	MvcResult mvcResult1=mvc.perform(MockMvcRequestBuilders.put(putUri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
    int status1 = mvcResult1.getResponse().getStatus();
    assertEquals(200,status1);
    String content1 = mvcResult1.getResponse().getContentAsString();
    Hotel h1=super.mapFromJson(content1, Hotel.class);
    assertEquals("Mayuri",h1.getHotel_name());
	assertEquals("6576578909",h1.getPhone1());
	}

	/**
	 * 
	 * @throws Exception
	 */
	 
	@Test
	public void getShowAllHotels() throws Exception {
		String uri = "/hotel/all";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)).andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		Hotel hotel[] = super.mapFromJson(content, Hotel[].class);
		assertEquals("Anu", hotel[1].getHotel_name());
	}
	
	

}

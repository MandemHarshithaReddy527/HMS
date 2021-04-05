package com.cg.hbm;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
/**
 * 
 * @author Harshitha
 *
 */
@SpringBootApplication

@ComponentScan(basePackages="com.cg.hbm")
public class HotelBookingsManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelBookingsManagementSystemApplication.class, args);
	}

}

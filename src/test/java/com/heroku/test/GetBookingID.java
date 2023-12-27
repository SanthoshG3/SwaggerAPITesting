package com.heroku.test;

import static org.testng.Assert.assertFalse;

import java.util.List;

import org.testng.*;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetBookingID {
	@Test
	public void CheckBookingID()
	{
		

		Response response = RestAssured.get("https://restful-booker.herokuapp.com/booking");
		System.out.println("Response is" + response);
		Assert.assertEquals(response.getStatusCode(), 200, "Status is not 200");
		
		List<Integer> id = response.jsonPath().getList("bookingid");
		System.out.println(id);
		assertFalse(id.isEmpty(),"List is Empty");
		
		Response response2 = RestAssured.get("https://restful-booker.herokuapp.com/booking/5");
		System.out.println("Response is" + response2);
	    Assert.assertEquals(response.getStatusCode(), 200 , "Status is not 200");
	    
	    SoftAssert softAssert2 = new SoftAssert();
	    System.out.println("Response 2 is" +response2.getBody());
		Assert.assertEquals(response2.getBody(), "I'm a Teapot");
	}
}

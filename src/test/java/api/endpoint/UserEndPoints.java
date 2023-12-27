// 2nd 

package api.endpoint;
import org.testng.annotations.Test;    // to use given when then
import static io.restassured.RestAssured.*;
/*
UserEndPoints is created for performing CURD Operation 
C- Create , U - Update , R - Read , D - Delete  */

import com.aventstack.extentreports.gherkin.model.Given;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

@Test
public class UserEndPoints {

	public static Response CreateUser(User payload)
	{
		Response response =						      // storing the response
		given()
				.contentType(ContentType.JSON)         // setting the content type which is in JSON format
				.accept(ContentType.JSON)			   // accept the format
				.body(payload)						// to send the body
		.when()
				.post(api.endpoint.Routes.post_url);    // set the user
		
	return response;
	}
	public static Response GetUser(String Username)
	{
		Response response =						      // storing the response
		given()
				.pathParam("username", Username)      // we have to send the Username to the link , see the link we have to pass the user name inside the {} 
		.when()
				.get(api.endpoint.Routes.get_url);    // set the user
		
	return response;
	}
	public static Response DeletetUser(String Username)
	{
		Response response =						      // storing the response
		given()
				.pathParam("username", Username)      // we have to send the Username to the link , see the link we have to pass the user name inside the {} 
		.when()
				.delete(api.endpoint.Routes.delete_url);    // set the user
		
	return response;
	}
	
	public static Response UpdateUser(User payload ,String Username)  // payload is body
	{
		Response response =						      // storing the response
		given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(payload)
				.pathParam("username", Username)      // we have to send the Username to the link , see the link we have to pass the user name inside the {} 
		.when()
				.put(api.endpoint.Routes.put_url);    // set the user
		
	return response;
	}
}

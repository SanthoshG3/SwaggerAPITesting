package api.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import api.endpoint.UserEndPoints;
import api.payload.User;
import io.restassured.response.Response;

public class UserTest {
	
	Faker faker ;
	User updateEmail;
	User userinfo;
	@BeforeClass
	public void setupData()
	{
		faker = new Faker();
		userinfo = new User();
		updateEmail = new User();
		userinfo.setEmail(faker.internet().safeEmailAddress());
		userinfo.setFirstName(faker.name().firstName());
		userinfo.setId(faker.idNumber().hashCode());
		userinfo.setLastName(faker.name().lastName());
		userinfo.setPassword(faker.internet().password());
		userinfo.setPhone(faker.phoneNumber().cellPhone());
		userinfo.setUsername(faker.name().username());
		updateEmail.setUpdateEmail(faker.internet().safeEmailAddress());
	}
	
	@Test
	public void testPostRequest()
	{
		Response response = UserEndPoints.CreateUser(userinfo);
		System.out.println(response + "This is Post");
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	@Test (dependsOnMethods = {"testPostRequest"})
	public void testGetRequest()
	{
		Response getResponse = UserEndPoints.GetUser(User.username);
		System.out.println(getResponse.contentType()+ "This is Get Request");
		getResponse.then().log().all();
	}
	@Test(dependsOnMethods = {"testGetRequest"})
	public void testUpdateRequest()
	{
		Response updateResponse = UserEndPoints.UpdateUser(updateEmail, User.username);
		System.out.println("Status code update" + updateResponse.statusCode());
		Assert.assertEquals(updateResponse.getStatusCode(),200);
		updateResponse.then().log().all();
	}
	
	@Test (dependsOnMethods = {"testUpdateRequest"})
	public void testDeleteRequest()
	{
	   Response Deleteresponse = UserEndPoints.DeletetUser(User.username);
	   System.out.println("Deleteresponse is" + Deleteresponse);
	   System.out.println("Status Code" + Deleteresponse.getStatusCode());
	   Assert.assertEquals(Deleteresponse.getStatusCode(), 200);
	   Deleteresponse.then().log().all();
	}
	
}

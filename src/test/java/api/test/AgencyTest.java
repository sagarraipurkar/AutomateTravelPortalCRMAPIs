package api.test;

import api.endpoints.AgencyEndPoints;

import api.payload.User;
import com.github.javafaker.Faker;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import api.payload.branch;
import io.restassured.response.Response;

public class AgencyTest {
//
//	User UserPayload;
//	branch Userbranch;
//
//	@BeforeClass
//	public void SetUpData() {
//
//		UserPayload = new User();
//		Userbranch = new branch();
//		Userbranch.setId(101);
//		Userbranch.setCode("1011");
//		Userbranch.setName("Demo Test");
//		Userbranch.setAddressDetails("City Mall");
//		Userbranch.setCity("Pune");
//		Userbranch.setRegion("Kalyani Nagar");
//		Userbranch.setPostalCode("433711");
//		Userbranch.setCountry("India");
//		Userbranch.setAgencies(Collections.singletonList("Null"));
//		Userbranch.setAgencyId(10);
//
//// Create a BranchRequest object
//		User request = new User();
//		UserPayload.setId(10);
//		UserPayload.setCode("1010");
//		UserPayload.setName("Demo Test User");
//		UserPayload.setAddressDetails("City one mall");
//		UserPayload.setCity("Pune");
//		UserPayload.setRegion("Kalyani Nagar");
//		UserPayload.setPostalCode("433711");
//		UserPayload.setCountry("India");
//		UserPayload.setAgencies(Collections.singletonList("Null"));
//		UserPayload.setBranches(Collections.singletonList(Userbranch));
//	}
	

	@Test(priority = 1)
	public void CreateAgency() throws FileNotFoundException {
	
		Response response = AgencyEndPoints.CreateAgency();
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
	}

	@Test(priority = 2)
	public void GetAgencyById() {
//		AgencyEndPoints.GetAgency(this.UserPayload.getId());
		Response response = AgencyEndPoints.GetAgency();
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);

		if (response.statusCode() == 404) {
			System.out.println("Endpoint not found. Check the URI and endpoint path.");
		} else {
			System.out.println("Response: " + response.asString());
		}
	}
}

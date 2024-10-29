package api.test;

import java.io.FileNotFoundException;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.AgencyEndPoints;
import api.endpoints.AgentEndPoints;
import io.restassured.response.Response;

public class AgentTest {

	@Test(priority = 1)
	public void CreateAgent() throws FileNotFoundException {
		Response response = AgentEndPoints.CreateAgent();
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
	}

	@Test(priority = 2)
	public void GetAgentById() {
//		AgencyEndPoints.GetAgency(this.UserPayload.getId());
		Response response = AgentEndPoints.GetAgent();
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);

		if (response.statusCode() == 404) {
			System.out.println("Endpoint not found. Check the URI and endpoint path.");
		} else {
			System.out.println("Response: " + response.asString());
		}
	}
}
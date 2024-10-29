package api.test;

import java.io.FileNotFoundException;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.AgentEndPoints;
import api.endpoints.BranchEndPoints;
import io.restassured.response.Response;

public class BranchTest {
	@Test(priority = 1)
	public void CreateBranch() throws FileNotFoundException {
		Response response = BranchEndPoints.CreateBranch();
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
	}

	@Test(priority = 2)
	public void GetBranchByID() {
		Response response = BranchEndPoints.GetBranch();
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);

		if (response.statusCode() == 404) {
			System.out.println("Endpoint not found. Check the URI and endpoint path.");
		} else {
			System.out.println("Response: " + response.asString());
		}
	}
}

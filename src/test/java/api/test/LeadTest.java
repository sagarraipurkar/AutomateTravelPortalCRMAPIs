package api.test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utilies.dataProvider;
import api.endpoints.BranchEndPoints;
import api.endpoints.LeadEndPoints;
import api.payload.Lead;
import io.restassured.response.Response;

public class LeadTest {

	Lead PayloadLead;

	@Test(dataProvider = "dataLead", dataProviderClass = dataProvider.class)
	public void testpostLead(String destination, String category, String travelFromDate, String travelToDate,
			String source, String totalAdults, String totalInfants, String totalChildren, String isNoteForAgent,
			String description, String addedByAgentCode, String addDate, String status, String budget,
			String clientName, String clientEmail, String primaryContactNumber, String contactNumbers,
			String branchId) {

		PayloadLead = new Lead();
		PayloadLead.setDestination(destination);
		PayloadLead.setCategory(category);
		PayloadLead.setTravelFromDate(travelFromDate);
		PayloadLead.setTravelToDate(travelToDate);
		PayloadLead.setSource(source);
		PayloadLead.setTotalAdults(totalAdults);
		PayloadLead.setTotalInfants(totalInfants);
		PayloadLead.setTotalChildren(totalChildren);
		PayloadLead.setIsNoteForAgent(isNoteForAgent);
		PayloadLead.setDescription(description);
		PayloadLead.setAddedByAgentCode(addedByAgentCode);
		PayloadLead.setAddDate(addDate);
		PayloadLead.setStatus(status);
		PayloadLead.setBudget(budget);
		PayloadLead.setClientName(clientName);
		PayloadLead.setClientEmail(clientEmail);
		PayloadLead.setPrimaryContactNumber(primaryContactNumber);
		PayloadLead.setContactNumbers(contactNumbers);
		PayloadLead.setBranchId(branchId);

		Response response = LeadEndPoints.CreateLead(PayloadLead);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);

	}

	@Test
	public void GetLeadById() {
//		AgencyEndPoints.GetAgency(this.UserPayload.getId());
		Response response = LeadEndPoints.GetLead();
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);

		if (response.statusCode() == 404) {
			System.out.println("Endpoint not found. Check the URI and endpoint path.");
		} else {
			System.out.println("Response: " + response.asString());
		}

	}

	public void GetLeadList() {
//		AgencyEndPoints.GetAgency(this.UserPayload.getId());
		Response response = LeadEndPoints.GetLeadList();
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
	}
}
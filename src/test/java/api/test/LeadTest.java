package api.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import api.Utilities.DataProviderLead;
import api.endpoints.BranchEndPoints;
import api.endpoints.LeadEndPoints;
import api.payload.Lead;
import io.restassured.response.Response;

public class LeadTest {

	@Test(priority = 1, dataProvider = "dataLead", dataProviderClass = DataProviderLead.class)
	public void testpostLead(String destination, String category, String travelFromDate, String travelToDate,
	                         String source, String totalAdults, String totalInfants, String totalChildren,
	                         String isNoteForAgent, String description, String addedByAgentCode, String addDate,
	                         String status, String budget, String clientName, String clientEmail,
	                         String primaryContactNumber, String contactNumbers, String branchId) {

		Lead payloadLead = new Lead();
		payloadLead.setDestination(destination);
		payloadLead.setCategory(category);
		payloadLead.setTravelFromDate(travelFromDate);
		payloadLead.setTravelToDate(travelToDate);
		payloadLead.setSource(source);
		payloadLead.setTotalAdults(totalAdults);
		payloadLead.setTotalInfants(totalInfants);
		payloadLead.setTotalChildren(totalChildren);
		payloadLead.setIsNoteForAgent(isNoteForAgent);
		payloadLead.setDescription(description);
		payloadLead.setAddedByAgentCode(addedByAgentCode);
		payloadLead.setAddDate(addDate);
		payloadLead.setStatus(status);
		payloadLead.setBudget(budget);
		payloadLead.setClientName(clientName);
		payloadLead.setClientEmail(clientEmail);
		payloadLead.setPrimaryContactNumber(primaryContactNumber);
		payloadLead.setContactNumbers(contactNumbers);
		payloadLead.setBranchId(branchId);

		Response response = LeadEndPoints.CreateLead(payloadLead);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	@Test(priority = 2)
	public void GetLeadById() {
		Response response = LeadEndPoints.GetLead();
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
	}
}

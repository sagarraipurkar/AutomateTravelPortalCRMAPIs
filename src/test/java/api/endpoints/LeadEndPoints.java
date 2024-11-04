package api.endpoints;

import static io.restassured.RestAssured.given;

import java.util.ResourceBundle;

import api.payload.Lead;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import token.TokenGenerate;

public class LeadEndPoints {

	static TokenGenerate generate = new TokenGenerate();
	static String Token = generate.Bearertoken();
	
	static ResourceBundle getURL() {
		ResourceBundle routes =  ResourceBundle.getBundle("routes");
		return routes;
		}
	public static Response CreateLead(Lead PayloadLead) {
		String Post_Lead =  getURL().getString("Post_Lead");
		Response response = given().header("Authorization", "Bearer " + Token).contentType(ContentType.JSON)
				.body(PayloadLead).when().post(Post_Lead);
		return response;
	}

	public static Response GetLead() {
		String get_Lead =  getURL().getString("get_Lead");
		Response response = given().header("Authorization", "Bearer " + Token).pathParam("leadId", 4)
				.contentType(ContentType.JSON).when().get(get_Lead);
		return response;

	}
	
//	public static Response updateLeadbyID() {
//		String Put_Lead =  getURL().getString("Put_Lead");
//		Response response = given().header("Authorization", "Bearer " + Token).pathParam("leadId", 4)
//				.contentType(ContentType.JSON).when().get(Put_Lead);
//		return response;
//	}

	public static Response GetLeadList() {
		String Put_Lead_list =  getURL().getString("Put_Lead_list");
		Response response = given().header("Authorization", "Bearer " + Token).pathParam("leadId", 4)
				.contentType(ContentType.JSON).when().get(Put_Lead_list);
		return response;
	}
	
//	public static Response LeadAssignbyId() {
//	String Put_Lead_assign =  getURL().getString("Put_Lead_assign");
//	Response response = given().header("Authorization", "Bearer " + Token).pathParam("leadId", 4)
//			.contentType(ContentType.JSON).when().get(Put_Lead_assign);
//	return response;
//}
	
//	public static Response AddnoteLeadbyId() {
//	String Put_Lead_addnotes =  getURL().getString("Put_Lead_addnotes");
//	Response response = given().header("Authorization", "Bearer " + Token).pathParam("leadId", 4)
//			.contentType(ContentType.JSON).when().get(Put_Lead_addnotes);
//	return response;
//}
	
//	public static Response sendproposalLeadById() {
//	String Post_Lead_sendproposal =  getURL().getString("Post_Lead_sendproposal");
//	Response response = given().header("Authorization", "Bearer " + Token).pathParam("leadId", 4)
//			.contentType(ContentType.JSON).when().get(Post_Lead_sendproposal);
//	return response;
//}
}
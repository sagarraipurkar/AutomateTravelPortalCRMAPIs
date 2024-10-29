package api.endpoints;

import static io.restassured.RestAssured.given;

import api.payload.Lead;
import authorization.GenerateBearerToken;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class LeadEndPoints {

	static GenerateBearerToken generate = new GenerateBearerToken();
	static String Token = generate.Bearertoken();

	public static Response CreateLead(Lead PayloadLead) {

		Response response = given().header("Authorization", "Bearer " + Token).contentType(ContentType.JSON)
				.body(PayloadLead).when().post(Routes.Post_Lead);
		return response;
	}

	public static Response GetLead() {
		Response response = given().header("Authorization", "Bearer " + Token).pathParam("leadId", 4)
				.contentType(ContentType.JSON).when().get(Routes.get_Lead);
		return response;

	}

	public static Response GetLeadList() {
		Response response = given().header("Authorization", "Bearer " + Token).pathParam("leadId", 4)
				.contentType(ContentType.JSON).when().get(Routes.Put_Lead_list);
		return response;
	}
}
package api.endpoints;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.JSONObject;
import org.json.JSONTokener;

import api.payload.User;
import authorization.GenerateBearerToken;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class AgentEndPoints {
	
	static GenerateBearerToken generate = new GenerateBearerToken();
	static String Token = generate.Bearertoken();
	
	public static Response CreateAgent() throws FileNotFoundException {
		
		File f = new File(
				"C:\\Eclipse New\\NewWorkSpace\\TravelCrmApiAutomation\\testdata\\CreateAgentTestData.json");
		FileReader fr = new FileReader(f);
		JSONTokener jsonToken = new JSONTokener(fr);
		JSONObject data = new JSONObject(jsonToken);
		Response AgentResponse = given().header("Authorization", "Bearer " + Token)
				.header("Content-Type", "application/json").body(data.toString()).when()
				.post(Routes.Post_agent);
		return AgentResponse;
	}

	public static Response GetAgent() {
//		Response response = request.header("Authorization", "Bearer " + Token)
//				.header("Content-Type", "application/json").when().get("/api/Agents/1");
//		response.prettyPrint();
		Response response = given().header("Authorization", "Bearer " + Token).pathParam("agentId", 1).contentType(ContentType.JSON).when()
				.get(Routes.get_agent);
		return response;
	}

//	public static Response UpdateAgent(String AgencyId, String Payload) {
//
//		Response response = given().header("Authorization", "Bearer " + Token).pathParam("agencyId", AgencyId).contentType(ContentType.JSON)
//				.accept(ContentType.TEXT).when().put(Routes.Put_agent);
//		return response;
//	}


}
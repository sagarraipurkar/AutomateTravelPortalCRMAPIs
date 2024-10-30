package api.endpoints;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ResourceBundle;

import org.json.JSONObject;
import org.json.JSONTokener;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import token.TokenGenerate;

public class AgentEndPoints {
	
	static TokenGenerate generate = new TokenGenerate();
	static String Token = generate.Bearertoken();
	
	static ResourceBundle getURL() {
		ResourceBundle routes =  ResourceBundle.getBundle("routes");
		return routes;
		}
	public static Response CreateAgent() throws FileNotFoundException {
		String Post_agent =  getURL().getString("Post_agent");
		File f = new File(
				"C:\\Eclipse New\\NewWorkSpace\\TravelCrmApiAutomation\\testdata\\CreateAgentTestData.json");
		FileReader fr = new FileReader(f);
		JSONTokener jsonToken = new JSONTokener(fr);
		JSONObject data = new JSONObject(jsonToken);
		Response AgentResponse = given().header("Authorization", "Bearer " + Token)
				.header("Content-Type", "application/json").body(data.toString()).when()
				.post(Post_agent);
		return AgentResponse;
	}

	public static Response GetAgent() {
		String get_agent =  getURL().getString("get_agent");
		Response response = given().header("Authorization", "Bearer " + Token).pathParam("agentId", 1).contentType(ContentType.JSON).when()
				.get(get_agent);
		return response;
	}

//	public static Response UpdateAgent(String AgencyId, String Payload) {
//String Put_agent =  getURL().getString("Put_agent");
//		Response response = given().header("Authorization", "Bearer " + Token).pathParam("agencyId", AgencyId).contentType(ContentType.JSON)
//				.accept(ContentType.TEXT).when().put(Put_agent);
//		return response;
//	}


}

package api.endpoints;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Path;

import org.json.JSONObject;
import org.json.JSONTokener;

import api.payload.User;
import api.payload.branch;
import authorization.GenerateBearerToken;
import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapper;

import static io.restassured.RestAssured.given;

public class AgencyEndPoints {
	static GenerateBearerToken generate = new GenerateBearerToken();
	static String Token = generate.Bearertoken();
	
	public static Response CreateAgency() throws FileNotFoundException {

		File f = new File(
				"C:\\Eclipse New\\NewWorkSpace\\TravelCrmApiAutomation\\testdata\\CreateAgencyTestData.json");
		FileReader fr = new FileReader(f);
		JSONTokener jsonToken = new JSONTokener(fr);
		JSONObject data = new JSONObject(jsonToken);
		Response response =given().header("Authorization", "Bearer " + Token)
				.contentType(ContentType.JSON).body(data).when().post(Routes.get_url);
		return response;
	}

	public static Response GetAgency() {
		Response response = given().header("Authorization", "Bearer " + Token).pathParam("agencyId", 1).contentType(ContentType.JSON).when()
				.get(Routes.get_url);
		return response;
	}

//	public static Response UpdateAgency(String AgencyId, String Payload) {
//
//		Response response = given().header("Authorization", "Bearer " + Token).pathParam("agencyId", AgencyId).contentType(ContentType.JSON)
//				.accept(ContentType.TEXT).when().put(Routes.update_url);
//		return response;
//	}

}

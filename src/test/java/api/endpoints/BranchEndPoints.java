package api.endpoints;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ResourceBundle;

import org.json.JSONObject;
import org.json.JSONTokener;

import authorization.GenerateBearerToken;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class BranchEndPoints {
	static GenerateBearerToken generate = new GenerateBearerToken();
	static String Token = generate.Bearertoken();
	
	static ResourceBundle getURL() {
		ResourceBundle routes =  ResourceBundle.getBundle("routes");
		return routes;
		}
	
	public static Response CreateBranch() throws FileNotFoundException {
		String Post_branch =  getURL().getString("Post_branch");
		File f = new File(
				"C:\\Eclipse New\\NewWorkSpace\\TravelCrmApiAutomation\\testdata\\CreateBranchTestData.json");
		FileReader fr = new FileReader(f);
		JSONTokener jsonToken = new JSONTokener(fr);
		JSONObject data = new JSONObject(jsonToken);
		Response AgentResponse = given().header("Authorization", "Bearer " + Token)
				.header("Content-Type", "application/json").body(data.toString()).when()
				.post(Post_branch);
		return AgentResponse;
	}

	public static Response GetBranch() {
		String get_branch =  getURL().getString("get_branch");
		Response response = given().header("Authorization", "Bearer " + Token).pathParam("branchId", 1).contentType(ContentType.JSON).when()
				.get(get_branch);
		return response;
	}

//	public static Response Updatebranch(String AgencyId, String Payload) {
//String Put_branch =  getURL().getString("Put_branch");
//		Response response = given().header("Authorization", "Bearer " + Token).pathParam("agencyId", AgencyId).contentType(ContentType.JSON)
//				.accept(ContentType.TEXT).when().put(Put_branch);
//		return response;
//	}


}

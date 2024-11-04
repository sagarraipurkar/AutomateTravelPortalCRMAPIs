package token;

import java.util.ResourceBundle;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TokenGenerate {

	static ResourceBundle getURL() {
		ResourceBundle routes = ResourceBundle.getBundle("routes");
		return routes;
	}

	@Test
	public String Bearertoken() {
		RestAssured.baseURI = "http://13.233.79.181:7105";
		RequestSpecification request = RestAssured.given();

		String Post_Authorization = getURL().getString("Post_Authorization");
		String Payload = "{\r\n" + "  \"email\": \"TS201@test1012.com\",\r\n" + "  \"password\": \"test\"\r\n" + "}";
		request.header("Content-Type", "application/json");

		Response ResponseToken = request.body(Payload).post(Post_Authorization);
		ResponseToken.prettyPrint();

		String JsonString = ResponseToken.getBody().asString();
		;
		String token = JsonString.trim();
		System.out.println("The Token is" + " " + token);
		return token;

	}

}

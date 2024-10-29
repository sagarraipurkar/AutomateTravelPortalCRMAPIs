package token;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TokenGenerate {

	@Test
	public String Bearertoken() {
		RestAssured.baseURI = "http://13.233.79.181:7105";
		RequestSpecification request = RestAssured.given();

		String Payload = "{\r\n" + "  \"email\": \"TS201@test1012.com\",\r\n" + "  \"password\": \"test\"\r\n" + "}";
		request.header("Content-Type", "application/json");

		Response ResponseFromGenerateToken = request.body(Payload).post("/api/Authentication/login");
		ResponseFromGenerateToken.prettyPrint();

		String JsonString = ResponseFromGenerateToken.getBody().asString();
		;
		String token = JsonString.trim();
		System.out.println("The Token is" + " " + token);
		return token;

	}

}

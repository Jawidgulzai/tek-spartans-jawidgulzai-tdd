package tek.tdd.api.test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class TokenGenerationTest {

    @Test
    public void sendingRequestWithRest(){

        RestAssured.baseURI = "https://dev.insurance-api.tekschool-students.com";

        RequestSpecification request = RestAssured.given().contentType(ContentType.JSON);

        Map<String, String> requestBody = new HashMap<>();
        requestBody.put("username", "supervisor");
        requestBody.put("password", "tek_supervisor");

        request.body(requestBody);
         Response response = request.when().post("/api/token");

         response.then().statusCode(200);
         response.prettyPrint();


    }
}

package request.booking.auth;

import io.restassured.http.ContentType;
import org.json.JSONObject;

import static io.restassured.RestAssured.given;

public class PostAuthRequest {

    public static String createToken(JSONObject json) {

        return given()
                .contentType(ContentType.JSON)
                .body(json.toString())
                .when()
                .post("https://restful-booker.herokuapp.com/auth")
                .then()
                .statusCode(200)
                .extract()
                .response()
                .jsonPath()
                .getString("token");



    }



}

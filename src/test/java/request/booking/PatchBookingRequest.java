package request.booking;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;

import static io.restassured.RestAssured.given;

public class PatchBookingRequest {

    public static Response patchBooking(String bookingId,JSONObject json, String token) {

       return given()
                .contentType(ContentType.JSON)
                .body(json.toString())
                .header("Cookie", "token=" + token)
                .when()
                .patch("https://restful-booker.herokuapp.com/booking/" + bookingId)
                .then()
                .statusCode(200)
                .extract()
                .response();

    }



}

package request.booking;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;

import static io.restassured.RestAssured.given;

public class PostBookingRequest {


    public static Response createBooking(JSONObject booking) {


        return given()
                .contentType(ContentType.JSON)
                .body(booking.toString())
                .when()
                .post("https://restful-booker.herokuapp.com/booking")
                .then()
                .statusCode(200)
                .extract()
                .response();

    }

}

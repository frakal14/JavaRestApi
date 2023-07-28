package request.booking;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class DeleteBookingRequest {

    public static Response deleteBooking(String bookingId, String token) {

       return given()
                .contentType(ContentType.JSON)
                .header("Cookie", "token=" + token)
                .when()
                .delete("https://restful-booker.herokuapp.com/booking/" + bookingId)
                .then()
                .extract()
                .response();



    }
}

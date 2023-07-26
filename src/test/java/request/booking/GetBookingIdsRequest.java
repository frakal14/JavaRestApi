package request.booking;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class GetBookingIdsRequest {

    public static Response getAllBookingIds() {

        return given()
                .when()
                .get("https://restful-booker.herokuapp.com/booking")
                .then()
                .statusCode(200)
                .extract()
                .response();


    }


}

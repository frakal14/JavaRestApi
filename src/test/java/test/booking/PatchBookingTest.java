package test.booking;

import dto.AuthDto;
import dto.BookingDto;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import request.booking.PatchBookingRequest;
import request.booking.PostBookingRequest;
import request.booking.auth.PostAuthRequest;

import static org.assertj.core.api.Assertions.assertThat;

public class PatchBookingTest {

    private static String token;

    @BeforeAll

    static void setUp() {
        JSONObject defaultAuth = AuthDto.getDefaultAuth();
        token = PostAuthRequest.createToken(defaultAuth);

    }

    @Test
    void partialUpdateBookingTest() {

        // 1. Creating a new booking
        JSONObject defaultBookingData = BookingDto.getDefaultBookingData();
        Response createResponse = PostBookingRequest.createBooking(defaultBookingData);
        String bookingId = createResponse.jsonPath().getString("bookingid");


        // 2. Object with new data

        JSONObject patchBooking = new JSONObject();
        patchBooking.put("firstname", "Chris");
        patchBooking.put("lastname", "API");

        // 3. Sending PATCH booking request
        Response patchResponse = PatchBookingRequest.patchBooking(bookingId, patchBooking, token);
        JsonPath jsonPath = patchResponse.jsonPath();

        assertThat(jsonPath.getString("firstname")).isEqualTo("Chris");
        assertThat(jsonPath.getString("lastname")).isEqualTo("API");

        // System.out.println(patchResponse.asString());


    }


}

package test.booking;

import dto.AuthDto;
import dto.BookingDto;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import request.booking.DeleteBookingRequest;
import request.booking.PostBookingRequest;
import request.booking.auth.PostAuthRequest;

import static org.assertj.core.api.Assertions.assertThat;

public class DeleteBookingTest {

    private static String token;

    @BeforeAll

    static void setUp() {
        JSONObject defaultAuth = AuthDto.getDefaultAuth();
        token = PostAuthRequest.createToken(defaultAuth);

    }

    @Test
    void deleteBookingTest() {

        JSONObject defaultBookingData = BookingDto.getDefaultBookingData();
        Response createResponse = PostBookingRequest.createBooking(defaultBookingData);
        String bookingId = createResponse.jsonPath().getString("bookingid");

        Response deleteResponse = DeleteBookingRequest.deleteBooking(bookingId, token);

        assertThat(deleteResponse.getStatusCode()).isEqualTo(201);


    }


}

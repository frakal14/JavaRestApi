package test.booking;

import dto.Booking;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import request.booking.PostBookingRequest;

import static org.assertj.core.api.Assertions.assertThat;

public class CreateBookingTest {


    @Test
    void createBookingTest() {


        final JSONObject booking = Booking.getDefaultBookingData();
        Response response = PostBookingRequest.createBooking(booking);

        JsonPath json = response.jsonPath();

        assertThat(json.getString("booking.firstname")).isEqualTo("Karol");
        assertThat(json.getString("booking.lastname")).isEqualTo("Testowy");


    }


}

package test.booking;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import request.booking.GetBookingIdsRequest;

import static org.assertj.core.api.Assertions.assertThat;

public class GetAllBookingIdsTest {

    @Test
    void getBookingIdsTest() {

        Response response = GetBookingIdsRequest.getAllBookingIds();
        JsonPath json = response.jsonPath();

        assertThat(json.getList("bookingid").size()).isPositive();
        System.out.println(json.getList("bookingid").size());
    }


}

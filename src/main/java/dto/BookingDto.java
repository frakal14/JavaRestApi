package dto;

import org.json.JSONObject;

public class BookingDto {


    public static JSONObject getDefaultBookingData() {

        JSONObject bookingDates = new JSONObject();
        bookingDates.put("checkin", "2023-01-01");
        bookingDates.put("checkout", "2023-01-31");

        JSONObject booking = new JSONObject();
        booking.put("firstname", "Karol");
        booking.put("lastname", "Testowy");
        booking.put("totalprice", 345);
        booking.put("depositpaid", true);
        booking.put("additionalneeds", "sauna");
        booking.put("bookingdates", bookingDates);

        return booking;
    }




}

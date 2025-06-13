package com.herokuapp.restfulbooker;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class GetBookingIdsTest {
    @Test
    public void getBookingIdsWithoutFilterTest(){
        //To get response with booking ids
        Response response = RestAssured.get("https://restful-booker.herokuapp.com/booking");
        response.print();
        //Verify response 200
        Assert.assertEquals(response.getStatusCode(),200, "Not 200.");
        //At least one booking id in response
        List<Integer> bookingIds = response.jsonPath().getList("bookingid");
        Assert.assertFalse(bookingIds.isEmpty(), "Booking id is empty");
    }
}

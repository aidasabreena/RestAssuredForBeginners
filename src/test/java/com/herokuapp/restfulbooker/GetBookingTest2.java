package com.herokuapp.restfulbooker;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class GetBookingTest2 {
    @Test
    public void getBooking2Test(){
        //To get response with booking ids
        Response response = RestAssured.get("https://restful-booker.herokuapp.com/booking/1");
        response.print();
        //Verify response 200
        Assert.assertEquals(response.getStatusCode(),200, "Not 200.");
        //Verify All fields
        SoftAssert softAssert = new SoftAssert();
        /*
        {
    "firstname": "Sally",
    "lastname": "Brown",
    "totalprice": 111,
    "depositpaid": true,
    "bookingdates": {
        "checkin": "2013-02-23",
        "checkout": "2014-10-23"
    },
    "additionalneeds": "Breakfast"
}
         */

    }
}

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
        String actualFirstName = response.jsonPath().getString("firstname");
        softAssert.assertEquals(actualFirstName, "Mary", "wrong firstname");

        String actualLastName = response.jsonPath().getString("lastname");
        softAssert.assertEquals(actualLastName, "Smith", "wrong lastname");

        int totalprice = response.jsonPath().getInt("totalprice");
        softAssert.assertEquals(totalprice, 624, "wrong price");

        boolean depositPaid = response.jsonPath().getBoolean("depositpaid");
        softAssert.assertFalse(depositPaid, "paid");

        String actualCheckIn = response.jsonPath().getString("checkin");
        softAssert.assertEquals(actualCheckIn, "2018-12-10", "wrong checkin date");

        String actualCheckOut = response.jsonPath().getString("checkout");
        softAssert.assertEquals(actualCheckOut, "2025-03-27", "wrong checkout date");

        String additionalNeeds = response.jsonPath().getString("additionalneeds");
        softAssert.assertEquals(additionalNeeds, "Breakfast", "wrong needs");

        softAssert.assertAll();
        /*
         "firstname": "Mary",
    "lastname": "Smith",
    "totalprice": 624,
    "depositpaid": false,
    "bookingdates": {
        "checkin": "2018-12-10",
        "checkout": "2025-03-27"
    },
    "additionalneeds": "Breakfast"
         */

    }
}

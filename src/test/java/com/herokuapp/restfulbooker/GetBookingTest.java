package com.herokuapp.restfulbooker;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNull.notNullValue;

public class GetBookingTest {
    @Test
    public void getBookingTest(){
        Response response = given().
                when().
                get("https://restful-booker.herokuapp.com/booking/5").
                then().
                assertThat().
                statusCode(200).
                body("firstname", notNullValue()).
                body("lastname",notNullValue()).
                extract().response();

        // Print the full response for debugging
        System.out.println("Response Body:");
        System.out.println(response.prettyPrint());
    }
}

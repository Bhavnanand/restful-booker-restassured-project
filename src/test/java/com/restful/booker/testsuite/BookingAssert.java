package com.restful.booker.testsuite;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.hasItem;

public class BookingAssert {
    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "https://restful-booker.herokuapp.com";
        response = given()
                .when()
                .get("/booking/1")
                .then().statusCode(200);
    }
    @Test
    public void test001(){
        response.body("firstname", hasItem("Eric"));
    }
    @Test
    public void test002(){
        response.body("lastname",hasItem("Jones"));
    }
    @Test
    public void test003(){
        response.body("totalprice",hasItem("568"));
    }
    @Test
    public void test004(){
        response.body("depositpaid",hasItem("false"));
    }
    @Test
    public void test005(){
        response.body("additionalneeds",hasItem("Breakfast"));
    }
    @Test
    public void test006(){
        response.body("bookingdates.checkin",hasItem("2019-09-17"));
    }
    @Test
    public void test007(){
        response.body("bookingdates.checkout",hasItem("2020-11-07"));
    }

}


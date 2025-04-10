package com.RestAPI.qa.assertions;

import io.restassured.response.Response;

import static org.testng.Assert.assertEquals;

public class AssertActions {

    public void VerifyResponseBody(String actual, String expected, String description){

        assertEquals(actual, expected , description);
    }
    public void VerifyResponseBody(int actual, int expected, String description){

        assertEquals(actual, expected , description);
    }
    public void VerifyStatusCode(Response response, Integer expected){

        assertEquals(response.getStatusCode(), expected );
    }

}

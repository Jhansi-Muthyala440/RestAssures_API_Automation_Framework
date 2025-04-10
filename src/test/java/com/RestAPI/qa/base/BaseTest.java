package com.RestAPI.qa.base;

import com.RestAPI.qa.assertions.AssertActions;
import com.RestAPI.qa.endpoints.APIConstants;
import com.RestAPI.qa.modules.PayloadManager;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    public RequestSpecification requestSpecification;
    public AssertActions assertActions;
    public Response response;
    public ValidatableResponse validatableResponse;
    public JsonPath jsonPath;
    public PayloadManager payloadManager ;

    @BeforeTest
    public void setUp(){
            payloadManager = new PayloadManager();
            assertActions = new AssertActions();
            requestSpecification = new RequestSpecBuilder()
                    .setBaseUri(APIConstants.BASE_URL)
                    .addHeader("Content-Type", "application/json")
                    .build().log().all();


    }


}

package com.RestAPI.qa.tests.crud;

import com.RestAPI.qa.Pojos.Booking;
import com.RestAPI.qa.Pojos.BookingResponse;
import com.RestAPI.qa.base.BaseTest;
import com.RestAPI.qa.endpoints.APIConstants;
import com.RestAPI.qa.modules.PayloadManager;
import io.qameta.allure.*;
import io.restassured.RestAssured;
import org.hamcrest.Matcher;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class testCreateBookingPost extends BaseTest {


    @Link(name = "Website", url = "https://restful-hooker.api")
    @Owner("Jhansi M ")
    @Issue("AUTH-123")
    @TmsLink("TMS-456")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify That ")
    @Test
    public void testVerifyCreateBookingPost01(){
        requestSpecification.basePath(APIConstants.BASE_PATH_POST);
        response = RestAssured.given(requestSpecification)
                        .when().body(payloadManager.CreatePayLoadBookingAsstring()).post();
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);

        PayloadManager payloadManager1 = new PayloadManager();
        BookingResponse bookingResponse = payloadManager.bookingResponseJava(response.asString());
// AssertJ
        assertThat(bookingResponse.getBookingid()).isNotNull();
        assertThat(bookingResponse.getBooking().getFirstname()).isNotNull().isNotBlank();
        assertThat(bookingResponse.getBooking().getFirstname())
               .isEqualTo("Kusum");

        // TestNG Assertions
        assertActions.VerifyStatusCode(response,200);

        Assert.assertEquals(true,true);
    }


}

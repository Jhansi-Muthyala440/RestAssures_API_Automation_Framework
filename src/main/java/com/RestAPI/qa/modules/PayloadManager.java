package com.RestAPI.qa.modules;
import com.RestAPI.qa.Pojos.Booking;
import com.RestAPI.qa.Pojos.BookingDates;
import com.RestAPI.qa.Pojos.BookingResponse;
import com.github.javafaker.Faker;
import com.google.gson.Gson;

public class PayloadManager {
    Gson gson;
    public String CreatePayLoadBookingAsstring(){
        String FirstName;
        String LastName ;
        String PostPalylaod;
        Booking booking = new Booking();
        Faker fake = new Faker();
        FirstName = fake.name().firstName();
        LastName = fake.name().lastName();

        booking.setFirstname("Kusum");
        booking.setLastname("Tharavi");
        booking.setTotalprice(123);
        booking.setDepositpaid(true);
        BookingDates bookingdates = new BookingDates();
        bookingdates.setCheckin("2025-01-01");
        bookingdates.setCheckout("2025-01-01");

        booking.setBookingdates(bookingdates);

        booking.setAdditionalneeds("BreakFast");

       gson = new Gson();
       PostPalylaod = gson.toJson(booking);

        return PostPalylaod;
    }
    public BookingResponse bookingResponseJava(String responseString){

        gson = new Gson();
        BookingResponse bookingResponse = gson.fromJson(responseString, BookingResponse.class);

        return bookingResponse;


    }
}
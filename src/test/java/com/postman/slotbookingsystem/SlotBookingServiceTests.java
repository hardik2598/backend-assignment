package com.postman.slotbookingsystem;

import com.postman.slotbookingsystem.model.RequestUser;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.context.event.annotation.AfterTestMethod;
import org.springframework.test.context.event.annotation.BeforeTestMethod;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.Assert.assertEquals;

public class SlotBookingServiceTests extends AbstractTest {

    @Override
    @Before
    public void setUp() {
        super.setUp();
    }

    @Before
    public void registerUser() throws Exception {
        String uri = "/postman/register";
        RequestUser requestUser = RequestUser.builder()
                .username("hardik_2598")
                .password("bhatt")
                .build();

        String inputJson = super.mapToJson(requestUser);
        mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
    }

    @BeforeTestMethod
    public void loginUser() throws Exception {
        String uri = "/postman/login";
        RequestUser requestUser = RequestUser.builder()
                .username("hardik_2598")
                .password("bhatt")
                .build();

        String inputJson = super.mapToJson(requestUser);
        mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
    }

    @Test
    public void bookSlotTest() throws Exception {
        String uri = "/postman/book-slot";

        String requestSlot = "{ \"slotDate\" : \"2020-04-04\", \"slotStartTime\" : \"16:00\", \"slotStartTime\" : \"17:00\" }";

        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(requestSlot)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(302, status);
    }

    @Test
    public void slotAvailabilityTest() throws Exception {
        String uri = "/postman/check-slot-availability";
        String requestSlot = "{ \"slotDate\" : \"2020-04-04\", \"slotStartTime\" : \"16:00\", \"slotStartTime\" : \"17:00\" }";

        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(requestSlot)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(302, status);
    }

    @Test
    public void markSlotAvailableTest() throws Exception {
        String uri = "/postman/mark-slot-available";
        String requestSlot = "{ \"slotDate\" : \"2020-04-04\", \"slotStartTime\" : \"16:00\", \"slotStartTime\" : \"17:00\" }";

        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(requestSlot)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(302, status);
    }

    @Test
    public void markAllSlotAvailableTest() throws Exception {
        String uri = "/postman/mark-all-slot-available";
        String requestSlot = "{ \"slotDate\" : \"2020-04-04\", \"slotStartTime\" : \"16:00\", \"slotStartTime\" : \"17:00\" }";

        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(requestSlot)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(302, status);
    }

    @Test
    public void getAllAvailableSlotTest() throws Exception {
        String uri = "/postman/get-all-available-slots";
        String requestSlot = "{ \"slotDate\" : \"2020-04-04\", \"slotStartTime\" : \"16:00\", \"slotStartTime\" : \"17:00\" }";

        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(requestSlot)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(302, status);
    }

    @Test
    public void getAllBookedSlotTest() throws Exception {
        String uri = "/postman/get-all-booked-slots";
        String requestSlot = "{ \"slotDate\" : \"2020-04-04\", \"slotStartTime\" : \"16:00\", \"slotStartTime\" : \"17:00\" }";

        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(requestSlot)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(302, status);
    }

    @AfterTestMethod
    private void logoutUser() throws Exception {
        String uri = "/postman/logout";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
    }
}

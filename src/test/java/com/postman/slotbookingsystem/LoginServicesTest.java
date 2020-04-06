package com.postman.slotbookingsystem;

import com.postman.slotbookingsystem.model.RequestUser;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.Assert.assertEquals;

public class LoginServicesTest extends AbstractTest {

    @Override
    @Before
    public void setUp() {
        super.setUp();
    }

    public void registerUser() throws Exception {
        String uri = "/postman/register";
        RequestUser requestUser = RequestUser.builder()
                .username("hardik")
                .password("bhatt")
                .build();

        String inputJson = super.mapToJson(requestUser);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
    }

    @Test
    public void loginUserPositiveTest() throws Exception {
        registerUser();

        String uri = "/postman/login";
        RequestUser requestUser = RequestUser.builder()
                .username("hardik")
                .password("bhatt")
                .build();

        String inputJson = super.mapToJson(requestUser);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        assertEquals(content, "Successfully LoggedIn");
        if (status == 200) logoutUser();
    }

    private void logoutUser() throws Exception {
        String uri = "/postman/logout";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
    }
}

package com.smsservice;

import javax.ws.rs.core.Application;

import com.google.gson.Gson;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ResourceTest extends JerseyTest {






    @Override
    protected Application configure() {
        return new ResourceConfig(Resource.class);
    }

    @Test
    public void testIsItUp() {
        final String responseMsg = target().path("/test").request().get(String.class);
        assertEquals("SMS Service is up", responseMsg);
    }

    @Test
    public void testServiceCall(){

        final ServiceTestObject responseMsg=  target().path("/status").request().get(ServiceTestObject.class);
           ServiceTestObject expectedObject= new ServiceTestObject();
                expectedObject.setServiceName("SMSService");
                expectedObject.setServiceStatus("Up");
                             Gson gson=new Gson();
                             assertEquals(gson.toJson(expectedObject),gson.toJson(responseMsg));


    }

    @Test
    public void testRegistration() {
        final RegistrationObject responseJson = target().path("/registeruser")
                .queryParam("username", "bob")
                .queryParam("tel", "07654321234")
                .request().get(RegistrationObject.class);
        RegistrationObject expectedObject=new RegistrationObject();
        expectedObject.setUserName("Bob");
        expectedObject.setPhoneNumber("07654321234");
        expectedObject.setRegistered(true);
        Gson gson=new Gson();
        assertEquals(gson.toJson(expectedObject),gson.toJson(responseJson));
    }

}

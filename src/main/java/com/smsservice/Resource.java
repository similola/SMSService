package com.smsservice;

import com.smsservice.textmessageutils.TextMessageHandler;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;


@Path("")
public class Resource {

    @GET
    @Path("/test")
    @Produces(MediaType.TEXT_PLAIN)
    public String isItUp() {
        return "SMS Service is up";
    }

    @GET
    @Path("/status")
    @Produces(MediaType.APPLICATION_JSON)
    public ServiceTestObject getStatus() {
        ServiceTestObject s = new ServiceTestObject();
        s.setServiceName("SMSService");
        s.setServiceStatus("Up");
        return s;
    }


    @GET
    @Path("/registeruser")
    @Produces(MediaType.APPLICATION_JSON)
    public RegistrationObject registerUser(@QueryParam("username") String username, @QueryParam("tel") String tel) {
        //send registration text message
        TextMessageHandler handler = new TextMessageHandler();
        String name = handler.formatName(username);
        handler.sendSMS(tel, name + ", you have registered successfully with SMS Service");

        RegistrationObject r = new RegistrationObject();
        r.setUserName(name);
        r.setPhoneNumber(tel);
        r.setRegistered(true);
        return r;

    }
}


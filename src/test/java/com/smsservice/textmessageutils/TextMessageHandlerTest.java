package com.smsservice.textmessageutils;

import com.google.common.base.Optional;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class TextMessageHandlerTest {


    @Test
    public void testValidatePhoneNumber() throws Exception {
        Optional<String> expectedValidatedNumber=Optional.of("+447313678675");
        String numberToValidate="07313678675";
        TextMessageHandler handler=new TextMessageHandler();
        assertEquals(expectedValidatedNumber,handler.validatePhoneNumber(numberToValidate));

    }

    @Test
    public void testFormatPhoneNumber() throws Exception {
        String expectedFormattedNumber="+447313678675";
        String numberToFormat="07313678675";
        TextMessageHandler handler=new TextMessageHandler();
        assertEquals(expectedFormattedNumber,handler.formatPhoneNumber(numberToFormat));
    }

    @Test
    public void testFormatName() throws Exception {
        String expectedName="Simi";
        String nameToFormat="simi";
        TextMessageHandler handler=new TextMessageHandler();
        assertEquals(expectedName,handler.formatName(nameToFormat));
    }

}
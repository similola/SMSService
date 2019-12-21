package com.smsservice.textmessageutils;


public class TextMessageTestClient {

    public static void main(String[] args) {

        /*Run this class with program arguments:-number <11 digit UK mobile number>*/
        String number = "";
        String message = "A test message from the Test Client";
        for (int i = 0; i < args.length; i = i + 2) {
            if (new String(args[i]).equals("-number")) {
                number = args[i + 1];
            }
        }

        TextMessageHandler handler = new TextMessageHandler();
        handler.sendSMS(number, message);
    }
}

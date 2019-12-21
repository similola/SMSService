package com.smsservice.textmessageutils;

import com.google.common.base.Optional;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.apache.log4j.Logger;


public class TextMessageHandler {
    final private static Logger logger = Logger.getLogger(TextMessageHandler.class);

    public void sendSMS(String receiverNumber, String messageContent) {
        Twilio.init(TextMessageConstants.ACCOUNT_SID, TextMessageConstants.AUTH_TOKEN);

        if (validatePhoneNumber(receiverNumber).isPresent()) {
            PhoneNumber to = new PhoneNumber(validatePhoneNumber(receiverNumber).get());
            PhoneNumber from = new PhoneNumber(TextMessageConstants.SENDER_NUMBER);

            //send SMS
            try {
                Message message = Message.creator(to, from, messageContent).create();

                logger.info(message.getSid());
                logger.info("sendSMS()-SMS sent to receiver");
            } catch (Exception e) {
                logger.error(e);
                logger.error(e.getMessage());
            }
        } else {
            logger.warn("sendSMS()-Phone number not validated");
        }

    }

    /*check phone number is 11 digits long and in correct format(starts with 0)*/
    public Optional<String> validatePhoneNumber(String number) {

        String regexStr = "^[0-9]{11}$";
        if (number.matches(regexStr) && number.substring(0, 1).equals("0")) {
            return Optional.of(formatPhoneNumber(number));
        }
        return Optional.absent();
    }

    /*format phonenumber to include UK country code*/
    public String formatPhoneNumber(String number) {
        return "+44" + number.substring(1, 11);
    }

    /*format name-capitalize first letter only*/
    public String formatName(String name) {
        return name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
    }
}

package com.beta.replyservice.common;

import com.beta.replyservice.dto.ReplyMessage;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Util {
    public static ReplyMessage processV2(String mesage, String type) {
        ReplyMessage result = null;
        try {
            TYPE typeOfOperation = TYPE.toValue(type);
            if (typeOfOperation == TYPE.MD5SUM) {
                result = getMd5Sum(mesage);
            } else if (typeOfOperation == TYPE.REVERSE) {
                result = reverse(mesage);
            } else {
                result = new ReplyMessage("Invalid type");
            }
        } catch (IllegalArgumentException e) {
            new ReplyMessage("Invalid type");
        }
        return result;
    }

    private static ReplyMessage reverse(String input) {
        if (input == null || input.length() == 0) {
            return new ReplyMessage("");
        } else {
            StringBuilder result = new StringBuilder();
            for (int i = input.length() - 1; i > -1; i--) {
                result.append(input.charAt(i));
            }
            return new ReplyMessage(result.toString());
        }
    }

    private static ReplyMessage getMd5Sum(String input) {
        try {

            // Static getInstance method is called with hashing MD5
            MessageDigest md = MessageDigest.getInstance("MD5");

            // digest() method is called to calculate message digest
            //  of an input digest() return array of byte
            byte[] messageDigest = md.digest(input.getBytes());

            // Convert byte array into signum representation
            BigInteger no = new BigInteger(1, messageDigest);

            // Convert message digest into hex value
            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return new ReplyMessage(hashtext);
        }
        // For specifying wrong message digest algorithms
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}

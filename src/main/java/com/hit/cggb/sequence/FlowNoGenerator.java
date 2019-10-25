package com.hit.cggb.sequence;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * @author Charies Gavin
 *         https:github.com/guobinhit
 * @date 10/24/19,10:00 AM
 * @description flow number generator
 */
public class FlowNoGenerator {
    private static String material = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static int length;
    private static int randomLength;

    /**
     * Initialize global variables
     */
    static {
        length = material.length();
        randomLength = 7;
    }

    /**
     * Privatization of constructors to prevent instantiation
     */
    private FlowNoGenerator() {
    }

    /**
     * Serial number generation method
     *
     * @param systemCode System code, two digits in length
     * @return Serial number
     */
    public static String generate(String systemCode) {
        return generate(systemCode, "000");
    }

    /**
     * Serial number generation method
     *
     * @param systemCode System code, two digits in length
     * @param bizCode    Service code, three digits in length
     * @return Serial number
     */
    public static String generate(String systemCode, String bizCode) {
        if (systemCode != null && systemCode.trim().length() == 2) {
            if (bizCode != null && bizCode.trim().length() == 3) {
                return systemCode + bizCode + (new SimpleDateFormat("yyyyMMddHHmmssSSS")).format(new Date()) + getRandomStr(length);
            } else {
                throw new IllegalArgumentException("bizCode length must be 3");
            }
        } else {
            throw new IllegalArgumentException("systemCode length must be 2");
        }
    }

    /**
     * Gets a random string of a specified length
     *
     * @param length Specify string length
     * @return Random string
     */
    private static String getRandomStr(int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < randomLength; ++i) {
            sb.append(material.charAt((new Random()).nextInt(length - 1)));
        }
        return sb.toString();
    }
}

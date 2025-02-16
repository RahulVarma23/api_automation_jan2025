package utils;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomDataGenerator {


    public static String getRandomStringValue(int chars) {
        return RandomStringUtils.random(chars, true, false);
    }

    public static int getRandomIntValue(int chars) {
        return Integer.parseInt(RandomStringUtils.random(chars, false, true));
    }

    public static String getRandomAlphaNumericValue(int chars) {
        return RandomStringUtils.random(chars, true, true);
    }

    public static String getRandomEmailId(int chars) {
        return RandomStringUtils.random(chars, true, true)+"@abc.com";
    }
}

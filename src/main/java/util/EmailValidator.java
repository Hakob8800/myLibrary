package util;

import java.util.regex.Pattern;

public final class EmailValidator {

    private EmailValidator(){}

    private static final String EMAIL_PATTERN = "^(.+)@(\\S+)$";
    public static boolean patternMatches(String emailAddress) {

        return Pattern.compile(EMAIL_PATTERN)
                .matcher(emailAddress)
                .matches();
    }
}

package org.funtastic.utility;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AppUtils {
	private static final String EMAIL_VALIDATION_REGEX = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	public static boolean validateEmail(String email) {
		Pattern pattern = Pattern.compile(EMAIL_VALIDATION_REGEX);
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
	}
}

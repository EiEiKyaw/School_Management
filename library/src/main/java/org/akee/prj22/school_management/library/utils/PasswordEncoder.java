package org.akee.prj22.school_management.library.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoder {
	
	public static void main(String args[]) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String password = "123456";
		System.out.println(encoder.encode(password));
	}

}

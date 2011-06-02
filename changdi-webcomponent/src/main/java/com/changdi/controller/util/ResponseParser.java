package com.changdi.controller.util;

import javax.servlet.http.HttpSession;

public class ResponseParser {
	public static String customKey = "09c4940a9199421e916389420184bfe4";
	public static String customSecret = "7aa9c482ff5234ed8275dcd0c47f8cad";
	
	public static boolean parseResponse(String response,HttpSession session) {
		if (response == null || response.equals("")) {
			return false;
		}

		String[] tokenArray = response.split("&");

		if (tokenArray.length < 2) {
			return false;
		}

		String strTokenKey = tokenArray[0];
		String strTokenSecrect = tokenArray[1];

		String[] token1 = strTokenKey.split("=");
		if (token1.length < 2) {
			return false;
		}
		session.setAttribute("tokenKey", token1[1]);

		String[] token2 = strTokenSecrect.split("=");
		if (token2.length < 2) {
			return false;
		}
		session.setAttribute("tokenSecret", token2[1]);
		return true;
	}
}

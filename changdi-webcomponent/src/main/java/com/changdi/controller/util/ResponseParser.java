package com.changdi.controller.util;

import java.util.logging.Logger;

import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.changdi.controller.IndexController;

public class ResponseParser {
	public static String customKey = "09c4940a9199421e916389420184bfe4";
	public static String customSecret = "7aa9c482ff5234ed8275dcd0c47f8cad";
	
	private static Log logger = LogFactory.getLog(ResponseParser.class);
	
	public static boolean parseResponse(String response,HttpSession session) {
		if (response == null || response.equals("")) {
			return false;
		}
		
		logger.debug(String.format("response:%s", response));
		
		String[] tokenArray = response.split("&");

		if (tokenArray.length < 2) {
			return false;
		}

		String strTokenKey = tokenArray[0];
		String strTokenSecrect = tokenArray[1];

		logger.debug(String.format("strTokenKey:%s", strTokenKey));
		logger.debug(String.format("strTokenSecrect:%s", strTokenSecrect));
		
		String[] token1 = strTokenKey.split("=");
		if (token1.length < 2) {
			return false;
		}
		
		logger.debug(String.format("token1[1]:%s", token1[1]));
		
		session.setAttribute("tokenKey", token1[1]);

		String[] token2 = strTokenSecrect.split("=");
		if (token2.length < 2) {
			return false;
		}
		
		logger.debug(String.format("token2[1]:%s", token2[1]));
		
		session.setAttribute("tokenSecret", token2[1]);
		return true;
	}
}

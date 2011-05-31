package com.changdi;

import org.junit.Test;

import com.changdi.controller.example.QWeiboSyncApi;

public class TestSendRequest {

	@Test
	public void processRequest() {
		String customKey = "09c4940a9199421e916389420184bfe4";
		String customSecrect = "7aa9c482ff5234ed8275dcd0c47f8cad";
		QWeiboSyncApi api = new QWeiboSyncApi();
		String response = null;

		System.out.println("GetRequestToken......");
		response = api.getRequestToken(customKey, customSecrect);

		System.out.println("Response from server：");
		System.out.println(response);
	}

}

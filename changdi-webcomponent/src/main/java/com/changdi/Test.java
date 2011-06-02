package com.changdi;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import com.changdi.vo.ResponseData;
import com.changdi.vo.User;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Gson gson = new Gson();
		File f = new File(
				"/root/workspace/changdi-core/changdi-webcomponent/src/main/java/user.json");
		String json = "";
		try {
			FileInputStream reader = new FileInputStream(f);
			byte[] b = new byte[1024];
			while ((reader.read(b)) != -1) {
				json += new String(b);
				b = new byte[1024];
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(json);
		ResponseData<User> vo = gson.fromJson(json, new TypeToken<ResponseData<User>>(){}.getType());
		System.out.println(vo);
	}
}

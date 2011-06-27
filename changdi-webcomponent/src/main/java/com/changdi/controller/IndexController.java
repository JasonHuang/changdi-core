package com.changdi.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.changdi.controller.example.QWeiboSyncApi;
import com.changdi.controller.example.QWeiboType.ResultType;
import com.changdi.controller.util.ResponseParser;
import com.changdi.service.UserService;
import com.changdi.service.VenueService;
import com.changdi.vo.ResponseData;
import com.changdi.vo.User;
import com.changdi.vo.UserToken;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@Controller
public class IndexController {

	private static final String DOMAIN_URL = "www.zchangdi.com";

	private static final int COOKIE_MAX_AGE = 60 * 60 * 24 * 30 * 12;

	private Log logger = LogFactory.getLog(IndexController.class);

	@Autowired
	private VenueService venueService;

	@Autowired
	private UserService userService;

	@Autowired
	private QWeiboSyncApi api;

	@RequestMapping("index")
	public String index(ModelMap model, HttpSession session,
			HttpServletResponse res, HttpServletRequest req) {

		/*
		 * List<Map<String, Object>> venues = venueService.showAllVenue();
		 * 
		 * model.put("venues", venues);
		 */

		String tokenKey = (String) session.getAttribute("tokenKey");
		String tokenSecret = (String) session.getAttribute("tokenSecret");
		String verifier = (String) session.getAttribute("verifier");

		logger.debug(String.format("tokenKey:%s", tokenKey));
		logger.debug(String.format("tokenSecret:%s", tokenSecret));
		logger.debug(String.format("verifier:%s", verifier));

		if (verifier == null || verifier.equals("")) {
			String name = readNameFromCookie(req);
			if (name != null && !name.equals("")) {
				UserToken ut = userService.loadUserTokenByName(name);
				tokenKey = ut.getTokenKey();
				tokenSecret = ut.getTokenSecret();
				verifier = ut.getVerifier();
			}
		}

		if (verifier != null && !verifier.equals("")) {
			String response = api.getUserInfo(ResponseParser.customKey,
					ResponseParser.customSecret, tokenKey, tokenSecret,
					ResultType.ResultType_Json);

			logger.debug(String.format("response:%s", response));
			Gson gson = new Gson();

			ResponseData<User> vo = gson.fromJson(response,
					new TypeToken<ResponseData<User>>() {
					}.getType());

			logger.debug(String.format("vo:%s", vo));

			User uo = vo.getData();

			uo.setTokenKey(tokenKey);
			uo.setTokenSecret(tokenSecret);
			uo.setVerifier(verifier);

			userService.authorize(uo);

			setCookieToClient(uo, res);

			model.put("response", response);
			model.put("user", uo);
		}
		return "index";
	}

	private String readNameFromCookie(HttpServletRequest req) {

		Cookie[] cookies = req.getCookies();
		if (cookies == null || cookies.length == 0)
			return null;
		for (int i = 0; i < cookies.length; i++) {
			String cookieName = cookies[i].getName();
			if (cookieName.equals("username")) {
				return cookies[i].getValue();
			}
		}
		return null;
	}

	private void setCookieToClient(User uo, HttpServletResponse response) {
		Cookie cookie = new Cookie("username", uo.getName());
		cookie.setMaxAge(COOKIE_MAX_AGE);
		cookie.setDomain(DOMAIN_URL);
		cookie.setPath("/");
		response.addCookie(cookie);
	}

	@RequestMapping("callback")
	public String callback(
			@RequestParam(value = "oauth_verifier", required = false) String verifier,
			ModelMap model, HttpSession session) {
		logger.debug(String.format("i m in controller,oauth_verifier:%s",
				verifier));

		session.setAttribute("verifier", verifier);

		String tokenKey = (String) session.getAttribute("tokenKey");
		String tokenSecret = (String) session.getAttribute("tokenSecret");

		String response = api.getAccessToken(ResponseParser.customKey,
				ResponseParser.customSecret, tokenKey, tokenSecret, verifier);

		if (!ResponseParser.parseResponse(response, session)) {

			return "404";
		}
		logger.debug("response:" + response);
		/*
		 * response = api.publishMsg(ResponseParser.customKey,
		 * ResponseParser.customSecret, ResponseParser.tokenKey,
		 * ResponseParser.tokenSecret, "test pushMsg", null,
		 * ResultType.ResultType_Json);
		 */

		logger.debug("response:" + response);

		return "redirect:index";
	}
}

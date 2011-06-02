package com.changdi.controller;

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
import com.changdi.service.VenueService;
import com.changdi.vo.ResponseData;
import com.changdi.vo.User;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@Controller
public class IndexController {

	private Log logger = LogFactory.getLog(IndexController.class);

	@Autowired
	private VenueService venueService;

	@Autowired
	private QWeiboSyncApi api;

	@RequestMapping("index")
	public String index(ModelMap model, HttpSession session) {

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
			uo = venueService.addAppUser(uo);

			model.put("response", response);
			model.put("user", uo);
		}
		return "index";
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

			return "";
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

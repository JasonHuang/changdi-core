package com.changdi.controller;

import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.changdi.controller.example.QWeiboSyncApi;
import com.changdi.controller.example.QWeiboType.PageFlag;
import com.changdi.controller.example.QWeiboType.ResultType;
import com.changdi.controller.util.ResponseParser;
import com.changdi.service.VenueService;

@Controller
public class IndexController {

	private Log logger = LogFactory.getLog(IndexController.class);

	@Autowired
	private VenueService venueService;

	@RequestMapping("index")
	public String index(ModelMap model) {

		List<Map<String, Object>> venues = venueService.showAllVenue();

		model.put("venues", venues);
		return "index";
	}

	@RequestMapping("callback")
	public String callback(
			@RequestParam(value = "oauth_verifier", required = false) String verifier,
			ModelMap model) {
		logger.debug(String.format("i m in controller,oauth_verifier:%s",
				verifier));

		QWeiboSyncApi api = new QWeiboSyncApi();
		String response = api.getAccessToken(ResponseParser.customKey,
				ResponseParser.customSecret, ResponseParser.tokenKey,
				ResponseParser.tokenSecret, verifier);

		if (!ResponseParser.parseResponse(response))
			return "index";

		logger.debug("response:" + response);
		response = api.publishMsg(ResponseParser.customKey,
				ResponseParser.customSecret, ResponseParser.tokenKey,
				ResponseParser.tokenSecret, "test pushMsg", null,
				ResultType.ResultType_Json);

		logger.debug("response:" + response);

		response = api.getHomeMsg(ResponseParser.customKey,
				ResponseParser.customSecret, ResponseParser.tokenKey,
				ResponseParser.tokenSecret, ResultType.ResultType_Json,
				PageFlag.PageFlag_First, 10);

		model.put("response", response);

		return "callback";
	}
}

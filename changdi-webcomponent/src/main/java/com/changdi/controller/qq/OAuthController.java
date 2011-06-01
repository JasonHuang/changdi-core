package com.changdi.controller.qq;

import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.changdi.controller.IndexController;
import com.changdi.controller.example.QWeiboSyncApi;
import com.changdi.controller.util.ResponseParser;
import com.changdi.service.VenueService;

@Controller
public class OAuthController {

	private Log logger = LogFactory.getLog(IndexController.class);

	@Autowired
	private VenueService venueService;

	@RequestMapping(value = "oAuth")
	public String oAuth(

	ModelMap model) {

		logger.debug("i 'm in oAuth controller.");

		QWeiboSyncApi api = new QWeiboSyncApi();

		String requestedToken = api.getRequestToken(ResponseParser.customKey,
				ResponseParser.customSecret);
		List<Map<String, Object>> venues = venueService.showAllVenue();

		model.put("requestToken", requestedToken);
		model.put("venues", venues);

		if (!ResponseParser.parseResponse(requestedToken))
			return "index";

		return "redirect:http://open.t.qq.com/cgi-bin/authorize?oauth_token="
				+ ResponseParser.tokenKey;
	}

}

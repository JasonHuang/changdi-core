package com.changdi.controller;

import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.changdi.service.VenueService;

@Controller
public class IndexController {

	private Log logger = LogFactory.getLog(IndexController.class);

	@Autowired
	private VenueService venueService;

	@RequestMapping("index")
	public String index(ModelMap model) {
		logger.debug("i m in controller");

		List<Map<String, Object>> venues = venueService.showAllVenue();

		model.put("venues", venues);
		return "index";
	}
}

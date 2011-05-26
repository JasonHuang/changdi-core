package com.changdi.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	private Log logger = LogFactory.getLog(IndexController.class);

	@RequestMapping("index")
	public String index() {
		logger.debug("i m in controller");
		return "index";
	}
}

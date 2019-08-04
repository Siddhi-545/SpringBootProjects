package com.siddhiself.microservice.limitservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.siddhiself.microservice.bean.LimitConfiguration;

/**
 * Limitservice controller class
 *	
 * @author Siddhi Diwane
 *
 */
@RestController
public class LimitsServiceController {

	@Autowired
	private Configuration configuration;

	@GetMapping("/limits")
	public LimitConfiguration retrieveLimitsFromConfigurations() {
		return new LimitConfiguration(configuration.getMaximum(),configuration.getMinimum());
	}

}

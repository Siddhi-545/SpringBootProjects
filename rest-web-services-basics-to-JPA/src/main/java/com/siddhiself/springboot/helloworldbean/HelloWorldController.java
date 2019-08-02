package com.siddhiself.springboot.helloworldbean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * This class is responsible to send data into http response
 * 
 * @author Siddhi Diwane
 *
 */

@RestController
public class HelloWorldController {

	@Autowired
	private MessageSource messageSource;

	@GetMapping(path = "/hello")
	public String helloWorld() {
		return "Hey Siddhi!";
	}

	@GetMapping(path = "/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("Hello Siddhi");
	}

	@GetMapping(path = "/hello-world/path-variable/{name}")
	public HelloWorldBean helloWorldParamVariable(@PathVariable String name) {
		return new HelloWorldBean(String.format("Hello dear %s", name));
	}

	@GetMapping(path = "/hello-world-internationalized")
	public String helloWorldInternationalized() {
		return messageSource.getMessage("good.morning.message", null, LocaleContextHolder.getLocale());
	}
	/**
	 * NOTES
	 * Hit http://localhost:8080/hello-world-internationalized?language=fr
	 * Bydefault language is set to english
	 */
}

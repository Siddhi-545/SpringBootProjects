package com.siddhiself.springboot.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller class for versioning
 * 
 * @author Siddhi Diwane
 *
 * NOTES 
 * The REST headers and parameters contain a wealth of information
 * that can help you track down issues when you encounter them.
 */

@RestController
public class PersonVersioningController {

	//Hit http://localhost:8080/v1/person
	@GetMapping("v1/person")
	public PersonV1 personV1() {
		return new PersonV1("Siddhi Diwane");
	}

	//Hit http://localhost:8080/v2/person
	@GetMapping("v2/person")
	public PersonV2 personV2() {
		return new PersonV2(new Name("Samrudhi", "Diwane"));
	}
	
	//Hit http://localhost:8080/person/param?version=1
	//params ->indicates which paramtere to be used for distinguishing
	@GetMapping(value = "/person/param", params = "version=1")
	public PersonV1 paramV1() {
		return new PersonV1("Bod Henry");
	}

	//http://localhost:8080/person/param?version=2
	@GetMapping(value = "/person/param", params = "version=2")
	public PersonV2 paramV2() {
		return new PersonV2(new Name("Alice", "Fong"));
	}
	
	//Hit in Postman
	//Get ;http://localhost:8080/person/header;
	//Headers : key=X-API-VERSION;value = 1
	@GetMapping(value = "/person/header", headers = "X-API-VERSION=1")
	public PersonV1 headerV1() {
		return new PersonV1("Steve Hawk");
	}

	//Hit in Postman
	//Get ;http://localhost:8080/person/header;
	//Headers : key=X-API-VERSION;value = 2
	@GetMapping(value = "/person/header", headers = "X-API-VERSION=2")
	public PersonV2 headerV2() {
		return new PersonV2(new Name("Bob", "Lice"));
	}

	//Hit in Postman
	//Get ;http://localhost:8080/person/produces;
	//Headers : key=Accept ;value=application/vnd.company.app-v1+json
	@GetMapping(value = "/person/produces", produces = "application/vnd.company.app-v1+json")
	public PersonV1 producesV1() {
		return new PersonV1("Rob Hawkings");
	}

	//Hit in Postman
	//Get ;http://localhost:8080/person/produces;
	//Headers : key=Accept ;value=application/vnd.company.app-v2+json
	@GetMapping(value = "/person/produces", produces = "application/vnd.company.app-v2+json")
	public PersonV2 producesV2() {
		return new PersonV2(new Name("Era", "Dawn"));
	}

	/**
	 * Versioning  Document
	 * 
	 * Media type versioning (a.k.a “content negotiation” or “accept header”) => GitHub 
	 * (Custom) headers versioning => Microsoft 
	 * URI Versioning => Twitter 
	 * Request Parameter versioning => Amazon 
	 * Factors
	 * URI Pollution
	 * Misuse of HTTP Headers
	 * Caching
	 * Can we execute the request on the browser?
	 * API Documentation
	 * No Perfect Solution
	 */
}

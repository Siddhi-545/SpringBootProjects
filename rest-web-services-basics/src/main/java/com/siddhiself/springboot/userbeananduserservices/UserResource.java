package com.siddhiself.springboot.userbeananduserservices;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.siddhiself.springboot.exception.UserNotFoundException;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * This class is user implementation class
 * 
 * @author Siddhi Diwane
 *
 * NOTES 
 * The Spring HATEOAS project is a library of APIs that can be use
 * to create REST representations that follow the principle of HATEOAS
 * (Hypertext as the Engine of Application State). Generally,
 * the principle implies that the API should guide the client through
 * the application by returning relevant information about the next
 * potential steps, along with each response
 * Spring HATEOAS offers three abstractions for creating the URI – ResourceSupport, Link, and ControllerLinkBuilder.
 */

@RestController
@Api(value="UserDetails", description="Operations(Create,Delete,Retrive,Search,Update) to access and retrive user details")
public class UserResource {

	@Autowired
	private UserDaoService service;

	@GetMapping("/users-list")
	@ApiOperation("Returns list of all Users in the system.")
	public List<User> retriveAllUser() {
		return service.findAllUser();
	}

	@GetMapping("/users/{id}")
	@ApiOperation("Returns specific User by their identifier searhed along with url. 404 if does not exist")
	public Resource<User> retriveUser(@PathVariable int id) {
		User user = service.searchUser(id);
		if (user == null)
			throw new UserNotFoundException("id-" + id);
		// "all-users", SERVER_PATH + "/users"
		// retrieveAllUsers
		Resource<User> resource = new Resource<User>(user);

		ControllerLinkBuilder linkTo = linkTo(methodOn(UserResource.class).retriveAllUser());
		resource.add(linkTo.withRel("all-users"));
		// HATEOAS
		return resource;
	}

	/*
	 * To add new user hit below body with post request 
	 * request-type: post 
	 * url :http://localhost:8080/users-list 
	 * body : { "id": 653, "name": "Honey","birthDate": "2000-07-19T04:29:24.054+0000" }
	 */
	@PostMapping("/users-list")
	@ApiOperation("Creates a new user.")
	public ResponseEntity<Object> addNewUser(@ApiParam("User information for a new user to be created.")@Valid @RequestBody User user) {
		User savedUser = service.addUser(user);
		// CREATED
		// /user/{id}     savedUser.getId()
		
		URI location = ServletUriComponentsBuilder
			.fromCurrentRequest()
			.path("/{id}")
			.buildAndExpand(savedUser.getId()).toUri();
		
		return ResponseEntity.created(location).build();
		
	}
	
	@DeleteMapping("/users/{id}")
	@ApiOperation("Deletes a user from the system. 404 if the user identifier is not found.")
	public void deleteUser(@PathVariable int id) {
		User user = service.deleteUserById(id);
		if (user == null)
			throw new UserNotFoundException("id-" + id);
	}
}

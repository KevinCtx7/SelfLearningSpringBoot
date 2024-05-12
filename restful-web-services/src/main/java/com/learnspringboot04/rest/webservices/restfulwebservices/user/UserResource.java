package com.learnspringboot04.rest.webservices.restfulwebservices.user;


import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import java.net.URI;
import java.util.List;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.validation.Valid;

@RestController
public class UserResource {
	
	/*
	 * 200 - Success
	 * 201 - Created
	 * 204 - No content
	 * 401 - Unauthorized
	 * 400 - Bad Request (validation error)
	 * 404 - Resource not found
	 * 500 - Server Error
	 */
	
	private UserDaoService service;
	
	public UserResource(UserDaoService service) {
		this.service = service;
	}
	
	@GetMapping("/users")
	public List<User> retrieveAllUsers(){
		return service.findAll();
		
	}
	
	
	@GetMapping("/users/{id}")
	public EntityModel<User> retrieveUser(@PathVariable int id){
		User user = service.findOne(id);
		
		if(user == null) {
			throw new UserNotFoundException("id: "+id);
		}
		
		//To Wrap link to the user obj
		EntityModel<User> entityModel = EntityModel.of(user);
		
		
		//To Retrieve url based on the method
		WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).retrieveAllUsers());
		
		entityModel.add(link.withRel("all-users"));
		
		return entityModel;
		
	}
	
	@PostMapping("/users")
	public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
		User savedUser = service.save(user);
		
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(user.getId())
				.toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping("/users/{id}")
	public ResponseEntity<User> updateUser(@PathVariable int id, @Valid @RequestBody User user) {
		user.setId(id);
		service.update(user);
		
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.buildAndExpand(user.getId())
				.toUri();
		
		return ResponseEntity.created(location).build();
	
	}
	
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable int id){
		service.deleteById(id);
		
	}
	
	

}

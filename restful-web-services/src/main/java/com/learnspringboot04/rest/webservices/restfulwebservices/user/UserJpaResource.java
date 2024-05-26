package com.learnspringboot04.rest.webservices.restfulwebservices.user;


import com.learnspringboot04.rest.webservices.restfulwebservices.jpa.PostRepository;
import com.learnspringboot04.rest.webservices.restfulwebservices.jpa.UserRepository;
import jakarta.validation.Valid;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class UserJpaResource {

	/*
	 * 200 - Success
	 * 201 - Created
	 * 204 - No content
	 * 401 - Unauthorized
	 * 400 - Bad Request (validation error)
	 * 404 - Resource not found
	 * 500 - Server Error
	 */


	private UserRepository repository;
	private PostRepository postRepository;

	public UserJpaResource(PostRepository postRepository, UserRepository repository) {
		this.repository = repository;
		this.postRepository = postRepository;
	}
	
	@GetMapping("/jpa/users")
	public List<User> retrieveAllUsers(){
		return repository.findAll();
		
	}
	
	
	@GetMapping("/jpa/users/{id}")
	public EntityModel<User> retrieveUser(@PathVariable int id){
		Optional<User> user = repository.findById(id);
		
		if(user.isEmpty()) {
			throw new UserNotFoundException("id: " + id);
		}
		
		//To Wrap link to the user obj
		EntityModel<User> entityModel = EntityModel.of(user.get());
		
		
		//To Retrieve url based on the method
		WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).retrieveAllUsers());
		
		entityModel.add(link.withRel("all-users"));
		
		return entityModel;
		
	}
	
	@PostMapping("/jpa/users")
	public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
		User savedUser = repository.save(user);
		
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(user.getId())
				.toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping("/jpa/users/{id}")
	public ResponseEntity<User> updateUser(@PathVariable int id, @Valid @RequestBody User user) {
		user.setId(id);
		repository.save(user);
		
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.buildAndExpand(user.getId())
				.toUri();
		
		return ResponseEntity.created(location).build();
	
	}
	
	@DeleteMapping("/jpa/users/{id}")
	public void deleteUser(@PathVariable int id){
		repository.deleteById(id);
		
	}

	@GetMapping("/jpa/users/{id}/posts")
	public List<Post> retrievePostsForUser(@PathVariable int id){
		Optional<User> user = repository.findById(id);

		if(user.isEmpty()) {
			throw new UserNotFoundException("id: " + id);
		}

		return user.get().getPosts();
	}

	@PostMapping("/jpa/users/{id}/posts")
	public ResponseEntity<User> createPostForUser(@PathVariable int id, @Valid @RequestBody Post post) {
		Optional<User> user = repository.findById(id);

		if(user.isEmpty()) {
			throw new UserNotFoundException("id: " + id);
		}

		post.setUser(user.get());

		Post savedPost = postRepository.save(post);

		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedPost.getId())
				.toUri();


		return ResponseEntity.created(location).build();
	}


	@GetMapping("/jpa/users/{id}/posts/{postId}")
	public Optional<Post> retrievePostsForUser(@PathVariable int id,@PathVariable int postId){
		Optional<User> user = repository.findById(id);

		if(user.isEmpty()) {
			throw new UserNotFoundException("id: " + id);
		}

		Optional<Post> post = user.get().getPosts().stream().filter(p->p.getId()==postId).findFirst();

		if(post.isEmpty()) {
			throw new PostNotFoundException("Post: " + postId +" is not found at the user id: " + id );
		}

		return post;
	}
	
	

}

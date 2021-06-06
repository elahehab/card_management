package com.card.management.main;

import java.util.List;
import java.util.stream.Collectors;

import com.card.management.main.models.User;
import com.card.management.main.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
@RequestMapping(path="/user") 
public class UserController {
	@Autowired 
	private UserRepository userRepository;

	@GetMapping("/{id}")
	EntityModel<User> one(@PathVariable Integer id) {
		User user = userRepository.findById(id).orElseThrow();
		
		return EntityModel.of(user,
		linkTo(methodOn(UserController.class).one(id)).withSelfRel(),
		linkTo(methodOn(UserController.class).all()).withRel("all"));
	}

	@GetMapping(path="/all")
	public @ResponseBody CollectionModel<EntityModel<User>> all() {
		List<EntityModel<User>> users = userRepository.findAll().stream()
				.map(user -> EntityModel.of(user,
						linkTo(methodOn(UserController.class).one(user.getId())).withSelfRel(),
						linkTo(methodOn(UserController.class).all()).withRel("users")))
				.collect(Collectors.toList());

		return CollectionModel.of(users, linkTo(methodOn(UserController.class).all()).withSelfRel());
	}

	@DeleteMapping("/remove/{id}")
	void deleteUser(@PathVariable int id) {
		userRepository.deleteById(id);
	}

	@PostMapping("/new")
	User newEmployee(@RequestBody User newUser) {
		return userRepository.save(newUser);
	}
}

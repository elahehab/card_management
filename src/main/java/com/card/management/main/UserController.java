package com.card.management.main;

import java.util.List;

import com.card.management.main.models.User;
import com.card.management.main.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller	
@RequestMapping(path="/user") 
public class UserController {
	@Autowired 
	private UserRepository userRepository;

	@PostMapping(path="/add") 
	public @ResponseBody String addNewUser (@RequestParam String name
			, @RequestParam String lastname, @RequestParam String nationalId,
			@RequestParam String username, @RequestParam String password) {

		User n = new User();
		n.setName(name);
		n.setLastname(lastname);
		n.setNationalId(nationalId);
		n.setUsername(username);
		n.setPassword(password);
		userRepository.save(n);
		return "Saved";
	}

	@GetMapping(path="/all")
	public @ResponseBody Iterable<User> getAllUsers() {
		return userRepository.findAll();
	}

	@GetMapping(path="/login")
	public @ResponseBody String login(@RequestParam String username, @RequestParam String password) {
		List<User> users = userRepository.findByUsernameAndPassword(username, password);
		if(users.size() > 1) {
			return "More than one user exists with this username and password";
		} else if(users.size() == 0) {
			return "No user found with this username and password";
		} else {
			User authenticatedUser = users.get(0);
			return authenticatedUser.getName() + " " + authenticatedUser.getLastname() + " logged in";
		}
	}
}

package com.card.management.main;


import com.card.management.main.models.Card;
import com.card.management.main.repository.CardRepository;

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

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path="/card")
public class CardController {
    
    @Autowired
    private CardRepository cardRepository;

    @GetMapping("/{id}")
	EntityModel<Card> one(@PathVariable Integer id) {
		Card card = cardRepository.findById(id).orElseThrow();
		
		return EntityModel.of(card,
		linkTo(methodOn(UserController.class).one(id)).withSelfRel(),
		linkTo(methodOn(UserController.class).all()).withRel("all"));
	}

	@GetMapping(path="/all")
	public @ResponseBody CollectionModel<EntityModel<Card>> all() {
		List<EntityModel<Card>> users = cardRepository.findAll().stream()
				.map(user -> EntityModel.of(user,
						linkTo(methodOn(UserController.class).one(user.getId())).withSelfRel(),
						linkTo(methodOn(UserController.class).all()).withRel("employees")))
				.collect(Collectors.toList());

		return CollectionModel.of(users, linkTo(methodOn(CardController.class).all()).withSelfRel());
    }
    
    @DeleteMapping("/remove/{id}")
	void deleteCard(@PathVariable int id) {
		cardRepository.deleteById(id);
	}

	@PostMapping("/new")
	Card newCard(@RequestBody Card newCard) {
		return cardRepository.save(newCard);
	}

}

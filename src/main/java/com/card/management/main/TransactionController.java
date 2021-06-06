package com.card.management.main;

import com.card.management.main.models.Transaction;
import com.card.management.main.repository.TransactionRepository;

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
@RequestMapping(path="/transaction")
public class TransactionController {
    
    @Autowired
    private TransactionRepository transactionRepository;

    @GetMapping("/{id}")
	EntityModel<Transaction> one(@PathVariable Integer id) {
		Transaction trns = transactionRepository.findById(id).orElseThrow();
		
		return EntityModel.of(trns,
		linkTo(methodOn(UserController.class).one(id)).withSelfRel(),
		linkTo(methodOn(UserController.class).all()).withRel("all"));
	}

	@GetMapping(path="/all")
	public @ResponseBody CollectionModel<EntityModel<Transaction>> all() {
		List<EntityModel<Transaction>> transactions = transactionRepository.findAll().stream()
				.map(user -> EntityModel.of(user,
						linkTo(methodOn(UserController.class).one(user.getId())).withSelfRel(),
						linkTo(methodOn(UserController.class).all()).withRel("employees")))
				.collect(Collectors.toList());

		return CollectionModel.of(transactions, linkTo(methodOn(TransactionController.class).all()).withSelfRel());
    }
    
    @DeleteMapping("/remove/{id}")
	void deleteTransaction(@PathVariable int id) {
		transactionRepository.deleteById(id);
	}

	@PostMapping("/new")
	Transaction newTransaction(@RequestBody Transaction newTrns) {
		return transactionRepository.save(newTrns);
	}
}
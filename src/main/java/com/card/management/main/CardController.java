package com.card.management.main;

import java.util.Date;

import com.card.management.main.repository.CardRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/card")
public class CardController {
    
    @Autowired
    private CardRepository cardRepository;

    @PostMapping(path="/add")
    public @ResponseBody String addNewCard(@RequestParam String cardNumber,
    @RequestParam int cvv2, @RequestParam int expirationMonth,
     @RequestParam int expirationYear, @RequestParam String secondPass) {
        return "";
    }
}

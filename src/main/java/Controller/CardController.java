package Controller;

import Exceptions.CardNotFoundException;
import JPA.CardRepository;
import backDeck.Card;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CardController {

    private final CardRepository repository;

    public CardController(CardRepository cardRepo) {
        this.repository = cardRepo;
    }


    //all items
    @GetMapping("/cards")  //all the cards
    public List<Card> all() {
        return repository.findAll();
    }

    @PostMapping("/cards")
    public  Card newCard(@RequestBody Card newCard) {
        return repository.save(newCard);
    }

    //use specification instead of manually doing it
    //https://www.baeldung.com/rest-api-search-language-spring-data-specifications
    @GetMapping("/cards/{id}")  //all the cards of the corresponding deck;
    public List<Card> allWithDeckId (@PathVariable int id) {

        List<Card> cards = repository.findAll();
        for (Card c : cards)
        {
            //if (c.)
        }
        return cards;
    }

    @PutMapping("/cards/{id}")
    public Card replaceCard(@RequestBody Card newCard, @PathVariable Long id) {

        return repository.findById(id)
                .map(employee -> {
                    employee.setColor(newCard.getColor());
                    employee.setValue(newCard.getValue());
                    return repository.save(employee);
                })
                .orElseGet(() -> {
                    newCard.setId(id);
                    return repository.save(newCard);
                });
    }

    @DeleteMapping("/cards/{id}")
    public void deleteCard(@PathVariable Long id) {
        repository.deleteById(id);
    }
}

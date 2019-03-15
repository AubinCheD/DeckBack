package Controller;

import JPA.DeckRepository;
import backDeck.Card;
import backDeck.Deck;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeckController {

    private final DeckRepository repository;

    public DeckController(DeckRepository deckRepo) {
        this.repository = deckRepo;
    }


    //all items
    @GetMapping("/decks/")  //all the cards
    public List<Deck> all() {
        return repository.findAll();
    }

    @PostMapping("/decks")
    public Deck newDeck(@RequestBody Deck newDeck) {
        return repository.save(newDeck);
    }

    @GetMapping("/decks/{idSession}")  //all the cards of the corresponding deck;
    public Deck allWithDeckId (@PathVariable int idSession) {

        return repository.findByIdSession(idSession);
    }

        /*
    @PutMapping("/decks/{idSession}")
    Deck replaceDeck(@RequestBody Card newCard, @PathVariable Long id) {

    }*/

    @DeleteMapping("/decks/{id}")
    public void deleteDeck(@PathVariable Long id) {
        repository.deleteById(id);
    }
}


//https://stackoverflow.com/questions/40118878/8080-port-already-taken-issue-when-trying-to-redeploy-project-from-spring-tool-s/49357430

package backDeck;

import Controller.DeckController;
import JPA.DeckRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.io.IOException;
import java.util.List;
import java.util.Optional;


@SpringBootApplication
public class DeckApplication {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(DeckApplication.class, args);


        Deck deck = new Deck(1705);

        DeckController deckControl = new DeckController(new DeckRepository() {
            @Override
            public Deck findByIdSession(int idSession) {
                return null;
            }

            @Override
            public List<Deck> findAll() {
                return null;
            }

            @Override
            public List<Deck> findAll(Sort sort) {
                return null;
            }

            @Override
            public List<Deck> findAllById(Iterable<Long> iterable) {
                return null;
            }

            @Override
            public <S extends Deck> List<S> saveAll(Iterable<S> iterable) {
                return null;
            }

            @Override
            public void flush() {

            }

            @Override
            public <S extends Deck> S saveAndFlush(S s) {
                return null;
            }

            @Override
            public void deleteInBatch(Iterable<Deck> iterable) {

            }

            @Override
            public void deleteAllInBatch() {

            }

            @Override
            public Deck getOne(Long aLong) {
                return null;
            }

            @Override
            public <S extends Deck> List<S> findAll(Example<S> example) {
                return null;
            }

            @Override
            public <S extends Deck> List<S> findAll(Example<S> example, Sort sort) {
                return null;
            }

            @Override
            public Page<Deck> findAll(Pageable pageable) {
                return null;
            }

            @Override
            public <S extends Deck> S save(S s) {
                return null;
            }

            @Override
            public Optional<Deck> findById(Long aLong) {
                return Optional.empty();
            }

            @Override
            public boolean existsById(Long aLong) {
                return false;
            }

            @Override
            public long count() {
                return 0;
            }

            @Override
            public void deleteById(Long aLong) {

            }

            @Override
            public void delete(Deck deck) {

            }

            @Override
            public void deleteAll(Iterable<? extends Deck> iterable) {

            }

            @Override
            public void deleteAll() {

            }

            @Override
            public <S extends Deck> Optional<S> findOne(Example<S> example) {
                return Optional.empty();
            }

            @Override
            public <S extends Deck> Page<S> findAll(Example<S> example, Pageable pageable) {
                return null;
            }

            @Override
            public <S extends Deck> long count(Example<S> example) {
                return 0;
            }

            @Override
            public <S extends Deck> boolean exists(Example<S> example) {
                return false;
            }
        });

        deckControl.newDeck(deck);


        System.in.read();
    }

}

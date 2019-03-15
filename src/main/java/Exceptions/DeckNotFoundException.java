package Exceptions;

public class DeckNotFoundException  extends RuntimeException {

    public DeckNotFoundException(Long id) {
        super("Could not find deck with session id n° " + id);
    }
}

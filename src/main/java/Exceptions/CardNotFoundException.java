package Exceptions;

public class CardNotFoundException extends RuntimeException {

    public CardNotFoundException(Long id) {
        super("Could not find deck with session id n° " + id);
    }
}
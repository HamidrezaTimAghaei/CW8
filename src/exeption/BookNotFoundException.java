package exeption;

public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException(String massage) {
        super(massage);
    }
}

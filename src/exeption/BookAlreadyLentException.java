package exeption;

public class BookAlreadyLentException extends RuntimeException{
    public BookAlreadyLentException(String massage){
        super(massage);
    }
}

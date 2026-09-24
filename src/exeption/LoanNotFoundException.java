package exeption;

public class LoanNotFoundException extends RuntimeException{
    public LoanNotFoundException(String massage){
        super(massage);
    }
}

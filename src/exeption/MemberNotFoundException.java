package exeption;

public class MemberNotFoundException extends RuntimeException {

    public MemberNotFoundException(String massage){
        super(massage);
    }
}

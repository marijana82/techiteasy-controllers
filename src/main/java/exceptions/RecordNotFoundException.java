package exceptions;

public class RecordNotFoundException extends RuntimeException {

    //create default exception

    //create exception with a message
    public RecordNotFoundException(String message) {
        super(message);

    }
}

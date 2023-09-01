package exceptions;

public class RecordNotFoundException extends RuntimeException {

    //create default exception
    public RecordNotFoundException() {
        super();
    }

    //create exception with a message
    public RecordNotFoundException(String message) {
        super(message);

    }
}

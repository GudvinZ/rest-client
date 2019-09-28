package test.restclient.exception;

//@ResponseStatus(HttpStatus.BAD_REQUEST)
public class IsAlreadyExistException extends RuntimeException {
    public IsAlreadyExistException(String message) {
        super(message);
    }

    public IsAlreadyExistException() {
    }
}
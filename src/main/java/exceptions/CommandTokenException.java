package exceptions;

public class CommandTokenException extends RuntimeException {
    private String message;

    public CommandTokenException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}

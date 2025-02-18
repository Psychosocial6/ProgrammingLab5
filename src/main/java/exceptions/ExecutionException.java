package exceptions;

public class ExecutionException extends Exception {
    private String message;

    public ExecutionException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}

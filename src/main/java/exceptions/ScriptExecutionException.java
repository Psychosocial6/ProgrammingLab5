package exceptions;

public class ScriptExecutionException extends Exception {
    private String message;

    public ScriptExecutionException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}

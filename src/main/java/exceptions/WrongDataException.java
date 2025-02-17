package exceptions;

public class WrongDataException extends Exception {
    private String message;

    public WrongDataException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}

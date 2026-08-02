package spring.coding.exception;

/**
 * A custom exception thrown when user-provided input is invalid.
 * (e.g., blank names, negative numbers for duration, etc.)
 */
public class InvalidInputException extends RuntimeException {

    public InvalidInputException(String message) {
        super(message);
    }
}

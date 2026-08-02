package spring.coding.exception;

/**
 * A custom exception thrown when a numerical value is outside its
 * valid boundaries (e.g., a negative ID or duration).
 */
public class InvalidBoundaryException extends RuntimeException {

    public InvalidBoundaryException(String message) {
        super(message);
    }
}

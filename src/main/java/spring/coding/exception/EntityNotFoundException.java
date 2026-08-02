package spring.coding.exception;

/**
 * A custom exception thrown when an entity (like a Student, Course, etc.)
 * cannot be found by its ID.
 */
public class EntityNotFoundException extends RuntimeException {

    public EntityNotFoundException(String message) {
        super(message);
    }
}

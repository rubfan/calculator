package exceptions;

/**
 * This exception will appear whe we will try to divide by zero
 */
public class DivideByZeroException extends Exception {
    public DivideByZeroException() {
        super("Divide by zero is impossible operation!");
    }
}
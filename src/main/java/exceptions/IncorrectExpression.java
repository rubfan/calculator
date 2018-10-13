package exceptions;

/**
 * This Exception show that user input incorrect symbol or wrong expression
 */
public class IncorrectExpression extends Exception {
    public IncorrectExpression() {
        super("This is incorrect part of expression!");
    }
}

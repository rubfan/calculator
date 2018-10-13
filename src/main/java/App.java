import calculators.RpnCalculator;
import input.CommandLineInput;
import operations.AdditionOperation;
import operations.DivisionOperation;
import operations.MultiplicationOperation;
import operations.SubtractionOperation;
import output.CommandLineOutput;

/**
 * Main class that initialises and starts the Calculator
 */
public class App {

    /**
     * Prepare and run RPN Calculator
     */
    public static void main(String[] args) {
        new RpnCalculator.Builder(
                new CommandLineInput(),
                new CommandLineOutput())
                .addOperation(new AdditionOperation())
                .addOperation(new SubtractionOperation())
                .addOperation(new MultiplicationOperation())
                .addOperation(new DivisionOperation())
                .build()
                .run();
    }
}

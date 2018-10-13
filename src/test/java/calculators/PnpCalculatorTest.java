package calculators;

import input.Input;
import operations.AdditionOperation;
import operations.DivisionOperation;
import operations.MultiplicationOperation;
import operations.SubtractionOperation;
import org.junit.Before;
import org.junit.Test;
import output.Output;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.containsString;

/**
 * This test is for RpnCalculator class
 *
 * @author ruslaan.gramatic
 */
public class PnpCalculatorTest {
    private RpnCalculator calculator;
    private String inputData = "";
    private String outputData = "";

    @Before
    public void init() {
        calculator = new RpnCalculator.Builder(
                new Input() {
                    public String input() {
                        return inputData;
                    }
                },
                new Output() {
                    public void show(String data) {
                        outputData = data;
                    }
                })
                .addOperation(new AdditionOperation())
                .addOperation(new SubtractionOperation())
                .addOperation(new MultiplicationOperation())
                .addOperation(new DivisionOperation())
                .build();
    }

    @Test
    public void testCompute() {
        boolean result = calculator.compute("1 + 2 + 3 + 4 +");
        assertFalse(result);
        assertThat(outputData, containsString("10"));
        calculator.compute("10 + 20 + 30 - 70 + 5 + ");
        assertThat(outputData, containsString("5"));
        calculator.compute("22");
        calculator.compute("33");
        calculator.compute("40");
        calculator.compute("+");
        assertThat(outputData, containsString("180"));
    }

    @Test
    public void testComputeShouldExit() {
        calculator.compute("q");
        assertThat(outputData, containsString("Calculation is finished."));
    }

    @Test
    public void testComputeIncorrectExpression() {
        calculator.compute("a + b");
        assertThat(outputData, containsString("This is incorrect part of expression!"));
    }

    @Test
    public void testComputeDivideByZeroException() {
        calculator.compute("1 + 0 / 0 /");
        assertThat(outputData, containsString("Divide by zero is impossible operation!"));
    }
}

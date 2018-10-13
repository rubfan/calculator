package calculators;

import exceptions.IncorrectExpression;
import input.Input;
import operations.Operation;
import output.Output;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.regex.Pattern;

/**
 * This is Calculator that can to operate with stack of operations.
 */
public class RpnCalculator {
    private static final String NUMBER_REGEX = "[-]?[0-9]+[.]?[0-9]*";

    private Input input;
    private Output output;
    private List<Operation> allOperations;
    private Queue<BigDecimal> stack;

    public static class Builder {
        private Input input;
        private Output output;
        private List<Operation> allOperations;

        public Builder(Input input, Output output) {
            this.input = input;
            this.output = output;
            this.allOperations = new LinkedList<>();
        }

        public Builder addOperation(Operation operation) {
            this.allOperations.add(operation);
            return this;
        }

        public RpnCalculator build() {
            RpnCalculator rpnCalculator = new RpnCalculator();
            rpnCalculator.input = this.input;
            rpnCalculator.output = this.output;
            rpnCalculator.allOperations = this.allOperations;
            return rpnCalculator;
        }
    }

    private RpnCalculator() {
        stack = new LinkedList<>();
    }

    /**
     * Runs the calculation for the RPN expression that we can put in command line for example.
     */
    public void run() {
        String data;
        do {
            output.show("> ");
            data = input.input();
        } while (!compute(data));
    }

    /**
     * This method divide string to separate tokens and put them to stack besides it calculate result if it faced with operation
     */
    public boolean compute(String expression) {
        if (expression.isEmpty()) {
            return false;
        }
        boolean calcFlag = false;
        for (String value : expression.split("\\s+")) {
            if (Pattern.compile(NUMBER_REGEX).matcher(value).matches()) {
                stack.add(new BigDecimal(value));
            } else if ("q".equals(value)) {
                output.show("Calculation is finished.\n");
                return true;
            } else {
                try {
                    calcFlag = tryToCalculate(value);
                } catch (Exception e) {
                    output.show(e.getMessage() + "\n");
                    return false;
                }
            }
        }
        if (stack.size() > 0 && calcFlag) {
            output.show(stack.peek().toEngineeringString() + "\n");
        }
        return false;
    }

    /**
     * This method checks if current input token is operation and perform calculations if it's true
     */
    private boolean tryToCalculate(String value) throws Exception {
        for (Operation operation : allOperations) {
            if (operation.getToken().equals(value)) {
                operation.calculate(stack);
                return true;
            }
        }
        throw new IncorrectExpression();
    }
}

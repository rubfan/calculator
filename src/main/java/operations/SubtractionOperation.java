package operations;

import java.math.BigDecimal;
import java.util.Queue;

/**
 * This operation can substract any number of values.
 *
 * @author ruslan.gramatic
 */
public class SubtractionOperation implements Operation {
    @Override
    public void calculate(Queue<BigDecimal> stack) {
        BigDecimal result = new BigDecimal(0);
        boolean firstOperationFlag = true;
        while (!stack.isEmpty()) {
            BigDecimal value = stack.poll();
            if (firstOperationFlag) {
                firstOperationFlag = false;
                result = value;
            } else {
                result = result.subtract(value);
            }
        }
        stack.add(result);
    }

    @Override
    public String getToken() {
        return "-";
    }
}
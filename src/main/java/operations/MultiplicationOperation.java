package operations;

import java.math.BigDecimal;
import java.util.Queue;

/**
 * This operation can multiply any number of values.
 *
 * @author ruslan.gramatic
 */
public class MultiplicationOperation implements Operation {
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
                result = result.multiply(value);
            }
        }
        stack.add(result);
    }

    @Override
    public String getToken() {
        return "*";
    }
}

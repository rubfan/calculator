package operations;

import exceptions.DivideByZeroException;

import java.math.BigDecimal;
import java.util.Queue;

/**
 * This operation can divide any number of values.
 *
 * @author ruslan.gramatic
 */
public class DivisionOperation implements Operation {
    @Override
    public void calculate(Queue<BigDecimal> stack) throws DivideByZeroException {
        BigDecimal result = new BigDecimal(0);
        boolean firstOperationFlag = true;
        while (!stack.isEmpty()) {
            BigDecimal value = stack.poll();
            if (BigDecimal.ZERO.equals(value)) {
                throw new DivideByZeroException();
            } else {
                if (firstOperationFlag) {
                    firstOperationFlag = false;
                    result = value;
                } else {
                    result = result.divide(value,3, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                }
            }
        }
        stack.add(result);
    }

    @Override
    public String getToken() {
        return "/";
    }
}

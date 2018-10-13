package operations;

import java.math.BigDecimal;
import java.util.Queue;

/**
 * This operation can add any number of values.
 *
 * @author ruslan.gramatic
 */
public class AdditionOperation implements Operation {
    @Override
    public void calculate(Queue<BigDecimal> stack) {
        BigDecimal result = new BigDecimal(0);
        while (!stack.isEmpty()) {
            BigDecimal value = stack.poll();
            if (value != null) {
                result = result.add(value);
            }
        }
        stack.add(result);
    }

    @Override
    public String getToken() {
        return "+";
    }
}

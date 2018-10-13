package operations;

import exceptions.DivideByZeroException;

import java.math.BigDecimal;
import java.util.Queue;

/**
 * @author ruslan.gramatic
 *
 * This is common interface for all operations
 */
public interface Operation {
    void calculate(Queue<BigDecimal> stack) throws DivideByZeroException;
    String getToken();
}

package operations;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.Queue;

import static org.junit.Assert.assertEquals;

/**
 * This test is for MultiplicationOperation
 *
 * @author ruslan.gramatic
 */
public class MultiplicationOperationTest {
    MultiplicationOperation multiplicationOperation;

    @Before
    public void init() {
        multiplicationOperation = new MultiplicationOperation();
    }

    @Test
    public void testCalculate() {
        Queue<BigDecimal> stack = new LinkedList<BigDecimal>(){{
            add(new BigDecimal(5));
            add(new BigDecimal(5));
            add(new BigDecimal(4));
        }};
        multiplicationOperation.calculate(stack);
        assertEquals(new BigDecimal(100), stack.peek());
    }

    @Test
    public void testGetToken() {
        assertEquals("*", multiplicationOperation.getToken());
    }
}

package operations;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.Queue;

import static org.junit.Assert.assertEquals;

/**
 * This test is for SubtractionOperation
 *
 * @author ruslan.gramatic
 */
public class SubtractionOperationTest {
    SubtractionOperation subtractionOperation;

    @Before
    public void init() {
        subtractionOperation = new SubtractionOperation();
    }

    @Test
    public void testCalculate() {
        Queue<BigDecimal> stack = new LinkedList<BigDecimal>(){{
            add(new BigDecimal(100));
            add(new BigDecimal(33));
            add(new BigDecimal(10));
        }};
        subtractionOperation.calculate(stack);
        assertEquals(new BigDecimal(57), stack.peek());
    }

    @Test
    public void testGetToken() {
        assertEquals("-", subtractionOperation.getToken());
    }
}
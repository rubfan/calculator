package operations;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.Queue;

import static org.junit.Assert.assertEquals;

/**
 * This test is for AdditionOperationTest
 *
 * @author ruslan.gramatic
 */
public class AdditionOperationTest {
    AdditionOperation additionOperation;

    @Before
    public void init() {
        additionOperation = new AdditionOperation();
    }

    @Test
    public void testCalculate() {
        Queue<BigDecimal> stack = new LinkedList<BigDecimal>(){{
            add(new BigDecimal(10));
            add(new BigDecimal(20));
            add(new BigDecimal(30));
        }};
        additionOperation.calculate(stack);
        assertEquals(new BigDecimal(60), stack.peek());
    }

    @Test
    public void testGetToken() {
        assertEquals("+", additionOperation.getToken());
    }
}

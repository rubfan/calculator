package operations;

import exceptions.DivideByZeroException;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.Queue;

import static org.junit.Assert.assertEquals;

/**
 * This test is for DivisionOperation
 *
 * @author ruslan.gramatic
 */
public class DivisionOperationTest {
    DivisionOperation divisionOperation;

    @Before
    public void init() {
        divisionOperation = new DivisionOperation();
    }

    @Test
    public void testCalculate() throws DivideByZeroException {
        Queue<BigDecimal> stack = new LinkedList<BigDecimal>(){{
            add(new BigDecimal(100));
            add(new BigDecimal(20));
        }};
        divisionOperation.calculate(stack);
        assertEquals(new BigDecimal(5), stack.peek());

        Queue<BigDecimal> stack2 = new LinkedList<BigDecimal>(){{
            add(new BigDecimal(1));
            add(new BigDecimal(2));
        }};
        divisionOperation.calculate(stack2);
        assertEquals(new BigDecimal(0.5), stack2.peek());
    }

    @Test
    public void testGetToken() {
        assertEquals("/", divisionOperation.getToken());
    }
}

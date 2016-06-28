package workshop.task_1_2;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by olenasyrota on 6/28/16.
 */
public class FactorialTest {

    @Test
    public void factorial_EdgeParameter() {
        long i = 1;
        assertEquals(1, Factorial.factorial(i));

    }

    @Test
    public void factorial_NormalParameter() {
        long i = 5;
        assertEquals(120, Factorial.factorial(i));
    }

}
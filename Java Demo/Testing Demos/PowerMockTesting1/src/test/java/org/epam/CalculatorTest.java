package org.epam;

import org.junit.jupiter.api.Test;
import org.powermock.reflect.Whitebox;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorTest {
    Calculator calculator = new Calculator();

    @Test
    public void test_add_for_two_and_four_using_() throws Exception {
            int result = Whitebox.invokeMethod(calculator,"add",2,4);
            assertEquals(6,result);
    }

}
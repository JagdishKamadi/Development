package com.epam;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.powermock.reflect.Whitebox;
import org.springframework.test.util.ReflectionTestUtils;

import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.spy;

@ExtendWith(MockitoExtension.class)
class CalculatorTest {

    @InjectMocks
    private Calculator calculator;

    @Test
    public void test_Sum_Using_ReflectionAPI() throws Exception {
        Class cl = Class.forName("com.epam.Calculator");
        Calculator calculator1 = (Calculator) cl.newInstance();
        Method method = cl.getDeclaredMethod("sum", int.class, int.class);
        method.setAccessible(true);
        int sum = (int) method.invoke(calculator1, 4, 5);
        assertEquals(9, sum);
    }

    @Test
    public void test_Sum_Using_ReflectionAPI2() throws Exception {
        Method method = calculator.getClass().getDeclaredMethod("sum", int.class, int.class);
        method.setAccessible(true);
        int sum = (int) method.invoke(calculator, 4, 5);
        assertEquals(9, sum);
    }

    private static Object[] getAllValues() {
        return new Object[]{
                new Object[]{4, 5, 9},
                new Object[]{7, 8, 15},
                new Object[]{4, -1, 3}
        };
    }

    @ParameterizedTest
    @MethodSource(value = "getAllValues")
    public void test_Sum_using_ReflectionTestUtils(int x, int y, int sum) {
        assertEquals(sum, (int) ReflectionTestUtils.invokeMethod(calculator, "sum", x, y));
    }
    
    @Test
    public void test_sumOfElement() {
        Element element = Element.builder()
                .x(4)
                .y(5)
                .z(-1).build();

    }
}
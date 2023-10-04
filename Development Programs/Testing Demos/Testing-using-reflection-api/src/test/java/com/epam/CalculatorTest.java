package com.epam;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.junit.jupiter.MockitoExtension;

import java.lang.reflect.Method;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = spy(Calculator.class);
    }

    @Test
    public void test_sum_Using_ReflectionAPI() throws Exception {
        Class cl = Class.forName("com.epam.Calculator");
        Calculator calculator1 = (Calculator) cl.newInstance();
        Method method = cl.getDeclaredMethod("sum", int.class, int.class);
        method.setAccessible(true);
        int sum = (int) method.invoke(calculator1, 2, 2);
        assertThat(sum).isEqualTo(4);

    }

    @Test
    public void test_sumOfElement_Using_ReflectionAPI() throws Exception {
        Element element = Element.builder()
                .x(2)
                .y(4)
                .z(-1).build();

        Class cl = Class.forName("com.epam.Calculator");
        Calculator calculator1 = (Calculator) cl.newInstance();
        Method method = cl.getDeclaredMethod("sumOfElement", Element.class);
        method.setAccessible(true);
        method.invoke(calculator1, element);
    }


}
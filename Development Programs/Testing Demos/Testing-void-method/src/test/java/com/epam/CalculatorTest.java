package com.epam;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
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
    public void test_Sum_Using_DoNothing() {
        doNothing().when(calculator).sum(isA(int.class), isA(String.class));
        calculator.sum(2, "Jagdish");
        verify(calculator, times(1)).sum(2, "Jagdish");
    }

    @Test
    public void test_Sum_Using_ThrowsException() {
        assertThrows(Exception.class, () -> {
            doThrow().when(calculator).sum(isA(Integer.class), isNull());
        });

        calculator.sum(0, null);
    }

    // use the argument captor mostly for void method
    @Test
    public void test_Sum_Using_ArgumentCaptor_For_String() {
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        doNothing().when(calculator).sum(any(int.class), captor.capture());
        calculator.sum(1, "Jagdish");
        assertEquals("Jagdish", captor.getValue());
        assertThat(captor.getValue()).isEqualTo("Jagdish");
    }

    @Test
    public void test_Sum_Using_ArgumentCaptor_For_2_Argument_With_Verify() {
        ArgumentCaptor intCaptor = ArgumentCaptor.forClass(int.class);
        ArgumentCaptor stringCaptor = ArgumentCaptor.forClass(String.class);
        doNothing().when(calculator).sum((Integer) intCaptor.capture(), (String) stringCaptor.capture());
        calculator.sum(1, "Jagdish");
        verify(calculator, times(1)).sum(1, "Jagdish");
        assertThat(intCaptor.getValue()).isEqualTo(1);
        assertThat(stringCaptor.getValue()).isEqualTo("Jagdish");
    }

    private static Object[] getAllValues() {
        return new Object[]{
                new Object[]{2, "Jagdish"},
                new Object[]{4, "Harshal"},
                new Object[]{-1, "Jayant"}
        };
    }

    @ParameterizedTest
    @MethodSource(value = "getAllValues")
    public void test_Sum_Using_ArgumentCaptor_For_2_Argument_With_Verify_Using_MethodResource(int x, String element) {
        ArgumentCaptor intCaptor = ArgumentCaptor.forClass(int.class);
        ArgumentCaptor stringCaptor = ArgumentCaptor.forClass(String.class);
        doNothing().when(calculator).sum((Integer) intCaptor.capture(), (String) stringCaptor.capture());
        calculator.sum(x, element);
        verify(calculator, times(1)).sum(x, element);
        assertThat(intCaptor.getValue()).isEqualTo(x);
        assertThat(stringCaptor.getValue()).isEqualTo(element);
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
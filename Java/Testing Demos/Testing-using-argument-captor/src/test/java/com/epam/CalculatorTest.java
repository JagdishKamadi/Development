package com.epam;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = spy(Calculator.class);
    }

    @Test
    public void test_Sum() {
        assertEquals(9, calculator.sum(4, 5));
        ArgumentCaptor intArgumentCaptor = ArgumentCaptor.forClass(Integer.class);
        verify(calculator).sum((Integer) intArgumentCaptor.capture(), (Integer) intArgumentCaptor.capture());
        List<Integer> allValues = intArgumentCaptor.getAllValues();
        assertEquals(List.of(4, 5), allValues);
        int sum = ReflectionTestUtils.invokeMethod(calculator, "sum", 4, 5);

    }

    @Test
    public void test_sumOfElement() {
        Element element = Element.builder()
                .x(4)
                .y(5)
                .z(-1).build();

        calculator.sumOfElement(element);
        ArgumentCaptor argumentCaptor = ArgumentCaptor.forClass(Element.class);
        verify(calculator).sumOfElement((Element) argumentCaptor.capture());
        List<Element> allElements = argumentCaptor.getAllValues();
        assertAll("Tested all x,y and z values in once/n",
                () -> element.getX().equals(allElements.get(0).getX()),
                () -> element.getY().equals(allElements.get(0).getY()),
                () -> element.getZ().equals(allElements.get(0).getZ()));
    }

}
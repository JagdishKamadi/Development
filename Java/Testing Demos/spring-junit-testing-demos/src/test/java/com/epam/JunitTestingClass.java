package com.epam;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;
import org.junit.jupiter.params.provider.*;
import org.springframework.test.annotation.Repeat;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.time.temporal.ChronoUnit;
import java.util.EnumSet;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.params.provider.EnumSource.Mode.EXCLUDE;

@TestClassOrder(ClassOrderer.OrderAnnotation.class)
public class JunitTestingClass {

    private static final Logger LOGGER = LogManager.getLogger(JunitTestingClass.class);

    /**
     * we are following the nested class so
     * that we can see how each annotation works
     */

    private static Calculator calculator;
    private static Person person;

    @BeforeAll
    static void setUpObject() {
        calculator = new Calculator();
        person = new Person();
    }


    @Order(1)
    @Nested
    class Tag_Annotation_Test {
        @Target({ElementType.TYPE, ElementType.METHOD})
        @Retention(RetentionPolicy.RUNTIME)
        @Tag(value = "fast")
        public @interface Fast {

        }

        @Fast
        @Test
        void sum_Test() {
            assertEquals(3, Math.max(-1, 3));
        }

        // second process to create the annotation with test method
        @Target({ElementType.TYPE, ElementType.METHOD})
        @Retention(RetentionPolicy.RUNTIME)
        @Tag(value = "fast")
        @Test
        public @interface FastTest {

        }

        @FastTest
        @DisplayName(value = "Fast Test")
        public void sum_Test2() {
            assertEquals(3, Math.max(-1, 3));
        }
    }

    // setting up the custom display name generators

    @Order(2)
    @Nested
    @DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
    class CustomDisplayNameGenerator {

        @Test
        void test_Whether_Max_Is_Correct_Or_Not() {
            assertEquals(2, Math.max(2, -8));
        }

        @Nested
        @IndicativeSentencesGeneration(separator = "->", generator = DisplayNameGenerator.ReplaceUnderscores.class)
        class A_year_is_a_leap_year {
            @Test
            void if_it_is_divisible_by_4_but_not_by_100() {
            }

            @org.junit.jupiter.params.ParameterizedTest(name = "Year {0} is a leap year.")
            @ValueSource(ints = {2016, 2020, 2048})
            void if_it_is_one_of_the_following_years(int year) {
            }
        }
    }

    @Order(3)
    @Nested
    public class AssertionsDemo {

        private Person person = Person.builder()
                .firstName("Jagdish")
                .lastName("Kamadi")
                .build();

        private Calculator calculator = new Calculator();

        // Within a code block, if an assertion fails the
        // subsequent code in the same block will be skipped.

        @Order(4)
        @Test
        void dependent_Test() {
            assertAll("This method is like if first fails then not going to run later test case ",
                    () -> {
                        String firstName = person.getFirstName();
                        assertEquals("Jagdish", firstName);
                        // Executed only if the previous assertion is valid.
                        assertAll("first name",
                                () -> assertTrue(firstName.startsWith("J")),
                                () -> assertTrue(firstName.endsWith("h"))
                        );
                    });
        }


        @Test
        void dependent_Test2() {
            assertAll("This method is like if first fails then not going to run later test case ",
                    () -> {
                        String firstName = person.getFirstName();
                        assertEquals("Jagadish", firstName);
                        // Executed only if the previous assertion is valid.
                        assertAll("first name",
                                () -> assertTrue(firstName.startsWith("J")),
                                () -> assertTrue(firstName.endsWith("h"))
                        );
                    });
        }

        @Test
        void exceptionTesting() {
            Exception exception = assertThrows(ArithmeticException.class, () ->
                    calculator.divide(1, 0));
            assertEquals("/ by zero", exception.getMessage());
        }
    }

    @Order(5)
    @Nested
    class HamcrestAssertionsDemo {
        private final Calculator calculator = new Calculator();

        @Test
        void assertWithHamcrestMatcher() {
            assertThat(calculator.divide(10, 5), equalTo(2));
            assertThat(calculator.sub(4, 1), equalTo(3));
        }
    }

    @Order(6)
    @Nested
    @DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
    public class OsBaseJunitTesting {

        @Test
        @EnabledOnJre(JRE.JAVA_18)
        @EnabledOnOs(OS.WINDOWS)
        void sum_On_Windows() {
            assertEquals(40, calculator.add(25, 15));
        }

        @DisabledOnOs(OS.LINUX)
        @Test
        void mul_On_Any_Os_Except_Linux() {
            assertEquals(20, calculator.multiply(4, 5));
        }

        @Test
        @EnabledOnOs(OS.LINUX)
            // it will run only on linux
        void sum_On_Linux() {
            assertEquals(40, calculator.add(25, 15));
        }

        @TestOnMac
        @EnabledForJreRange(min = JRE.JAVA_8, max = JRE.JAVA_14)
        void sub_On_Mac() {
            assertEquals(3, calculator.sub(8, 5));
        }

        @Target(ElementType.METHOD)
        @Retention(RetentionPolicy.RUNTIME)
        @Test
        @EnabledOnOs(OS.MAC)
        public @interface TestOnMac {
        }
    }

    @Nested
    public class RepeatedTestClass {
        public void beforeEach(TestInfo testInfo, RepetitionInfo repetitionInfo) {
            int currentRepetition = repetitionInfo.getCurrentRepetition();
            int totalRepetitions = repetitionInfo.getTotalRepetitions();
            String methodName = testInfo.getTestMethod().get().getName();

            LOGGER.info(String.format("About to execute repetition %d of %d for %s", currentRepetition, totalRepetitions, methodName));
        }

        @RepeatedTest(10)
        public void randomTest() {
            assertNotEquals(10, new Random().nextInt(10) + 1);
        }
    }

    @Nested
    class ParameterizedTest {
        @org.junit.jupiter.params.ParameterizedTest
        @ValueSource(ints = {1, 2, 34, 4, 5, 7, 89, 9, 34})
        public void evenTest(int i) {
            assumeTrue(i % 2 == 0);
        }

        @org.junit.jupiter.params.ParameterizedTest
        @NullSource
        public void nullSourceTest(String nullString) {
            assertNull(nullString);
        }

        @org.junit.jupiter.params.ParameterizedTest
        @EnumSource(names = {"DAYS", "HOURS", "MONTHS"})
        public void testWithEnumSourceInclude(ChronoUnit chronoUnit) {
            assertTrue(EnumSet.of(ChronoUnit.DAYS, ChronoUnit.HOURS, ChronoUnit.MONTHS).contains(chronoUnit));
        }

        @org.junit.jupiter.params.ParameterizedTest
        @EnumSource(mode = EXCLUDE, names = {"ERAS", "FOREVER"})
        void testWithEnumSourceExclude(ChronoUnit unit) {
            assertFalse(EnumSet.of(ChronoUnit.ERAS, ChronoUnit.FOREVER).contains(unit));
        }

        @org.junit.jupiter.params.ParameterizedTest
        @CsvSource({
                "apple,         1",
                "banana,        2",
                "'lemon, lime', 0xF1",
                "strawberry,    700_000"
        })
        void testWithCsvSource(String fruit, int rank) {
            assertNotNull(fruit);
            assertNotEquals(0, rank);
        }

        // this below method is correct but giving file not exist error

       /* @org.junit.jupiter.params.ParameterizedTest
        @CsvFileSource(resources = "D:\\Jagdish\\Programs\\Testing Demos\\spring-junit-testing-demos\\src\\test\\resources\\name-age-1.csv", useHeadersInDisplayName = false)
        void csvFileSourceTest(String name, int age) {
            assertNotNull(name);
            assumeTrue(age >= 22);
        }*/
    }

    @Nested
    public class TimeoutTest {

        @Test
        @RepeatedTest(10)
        @Timeout(value = 1, unit = TimeUnit.SECONDS)
        public void beforeTimeoutTesting() {
            assertTrue(4 % 2 == 0);
        }
    }
}

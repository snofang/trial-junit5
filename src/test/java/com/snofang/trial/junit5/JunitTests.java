package com.snofang.trial.junit5;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class JunitTests {

    @BeforeAll
    static void initAll(){
        System.out.println("*** before all ***");
    }

    @BeforeEach
    void init(){
        System.out.println("*** before each ***");
    }

    @Test
    @DisplayName("simple assertions test")
    void simpleAssertion() {
        Assertions.assertEquals(1, 1);
    }

    @Test
    @DisplayName("another simple assertion - disabled ")
    @Disabled("disabled for demonstration purpose")
    void simpleAssertionDisabled() {
        Assertions.assertEquals(1, 1);
    }

    /**
     * should not stop on one failure and continue on assertions all.
     */
    @Test
    void multipleAssertionSample() {
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
        Assertions.assertAll(() -> Assertions.assertEquals(1, integers.get(0)),
                () -> Assertions.assertEquals(2, integers.get(1)),
                () -> Assertions.assertEquals(3, integers.get(2)),
                () -> Assertions.assertEquals(4, integers.get(3)),
                () -> Assertions.assertEquals(5, integers.get(4)));
    }

    /**
     * It is possible to have assumption on some tests
     */
    @Test
    void conditionalTest() {
        Assumptions.assumeTrue(false);
        System.out.println("this should not be seen/executed");
    }


    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    void parametrizedTest(int param) {
        Assertions.assertEquals(param, param);
    }

    @Test
    void assertThrows() {
        Assertions.assertThrows(IllegalArgumentException.class,
                //TODO: why this is not accepted without curly braces?
                () -> {
                    throw new IllegalArgumentException();
                });
    }

    @Nested
    class HavingIntegerValue {
        private final int intValue = 2;

        @Nested
        class ShouldBe {

            @Test
            void onIsLessThanTwo() {
                assertTrue(1 < 2);
            }

            @Test
            void zeroIsLessThanTwo() {
                assertTrue(0 < 2);
            }
        }

        @Nested
        class ShouldNotBe {

            @Test
            void fourIsNotEqualTheValue() {
                Assertions.assertNotEquals(4, 2);
            }
        }


    }

    @AfterEach
    void tearDown() {
        System.out.println("*** after each *** ");
    }

    @AfterAll
    static void tearDownAll() {
        System.out.println("*** after all *** ");
    }
}

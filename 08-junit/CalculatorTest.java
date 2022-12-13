package put.io.testing.junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    //Calculator calculator = new Calculator();
    private static Calculator calculator;

    @BeforeEach
    public void setUp() {
        calculator = new Calculator();
    }
    /*
    Różnica pomiędzy BeforeEach i BeforeAll polega na tym iż:
        BeforeEach wywoływany jest przed każdym testem
        BeforeAll wywoływany jest on przed wszystkimi testami i tylko raz
        Aby BeforeAll działał funkcja musi być statyczna
     */


    @Test
    public void testAdd(){
        assertEquals(5,calculator.add(2,3));
        assertEquals(10,calculator.add(5,5));
    }

    @Test
    public void testMultiply(){
        assertEquals(100,calculator.multiply(10,10));
        assertEquals(-25,calculator.multiply(-5,5));
    }

    @Test
    public void testAddPositiveNumbers(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            assertEquals(60,calculator.addPositiveNumbers(-10,50));
        });
    }
}

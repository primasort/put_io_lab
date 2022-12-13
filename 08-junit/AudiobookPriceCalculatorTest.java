package put.io.testing.audiobooks;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import put.io.testing.junit.Calculator;

import static org.junit.jupiter.api.Assertions.*;

class AudiobookPriceCalculatorTest {
    /*
        5.1: jest to testowanie typu whitebox
        5.2: istnieją 4 scieżki
     */
    private  Audiobook audiobook;
    private AudiobookPriceCalculator calculator;
    @BeforeEach
    void setUp(){
        audiobook = new Audiobook("test",100);
        calculator = new AudiobookPriceCalculator();
    }

    @Test
    void test1(){
        Customer customer = new Customer("Maurycy",Customer.LoyaltyLevel.STANDARD,false);
        assertEquals(100, calculator.calculate(customer, audiobook));
    }

    @Test
    void test2(){
        Customer customer = new Customer("Robert",Customer.LoyaltyLevel.SILVER,false);
        assertEquals(90,calculator.calculate(customer,audiobook));
    }

    @Test
    void test3(){
        Customer customer = new Customer("Tomek", Customer.LoyaltyLevel.GOLD, false);
        assertEquals(80, calculator.calculate(customer, audiobook));
    }

    @Test
    void test4(){
        Customer customer = new Customer("Grzesiu", Customer.LoyaltyLevel.STANDARD,true);
        assertEquals(0, calculator.calculate(customer, audiobook));
    }
}

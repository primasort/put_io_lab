package put.io.testing.junit;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FailureOrErrorTest {

    @Test
    void test1(){
        assertEquals(3,4);
        // 4.1: Oznacza jako failed
    }

    @Test
    void test2(){
        throw new IllegalArgumentException();
        // 4.1: Oznacza jako error
    }

    @Test
    void test3(){
        try{
            assertEquals(4,3);
        }
        catch (Error e){
            e.printStackTrace();
        }
    }
}

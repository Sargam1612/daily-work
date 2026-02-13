import com.zeta.Calculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {
    Calculator calc;
    @Test
    void testAdd(){
        //3A'S OF TESTING
 //        calc = new com.zeta.Calculator(); // ARRANGE
        int answer = calc.add(2,3); //ACT
        assertEquals(4,answer); //ANSWER

    }

    @Test
    void testAddFOrNegative(){
//        calc = new com.zeta.Calculator(); // ARRANGE
        int answer = calc.add(-2,3); //ACT
        assertEquals(1,answer);
    }

    @BeforeEach
    void setup(){
        calc = new Calculator();
    }

    @Test
    void testAddForLongNumbers(){
//        calc = new com.zeta.Calculator(); // ARRANGE
        int answer = calc.add(299999999,399999999); //ACT
        assertEquals(699999998,answer);
    }

    @Test
    void testDivide(){
        int result = calc.divide(6,3);
        assertEquals(2,result);
    }

    @Test
    void testDivideWithFIVE(){
        int result = calc.divide(5,3);
        assertEquals(1,result);
    }

    //wait if exceptions are thrown-->
    @Test
    void testDivideWithException(){
        int result = calc.divide(6,3);
        //assertThrowsExactly(ArithmeticException.class,()->calc.divide(10,0));

        //not very suitable - but to understand
        try{
            calc.divide(10,0);
        }catch(ArithmeticException e){
            assertEquals(ArithmeticException.class,e.getClass());
        }
    }

}

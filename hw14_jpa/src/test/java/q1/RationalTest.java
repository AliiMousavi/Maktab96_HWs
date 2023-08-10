package q1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RationalTest {

    Rational number1 = new Rational();
    Rational number2 = new Rational();

    @Test
    void add() {
        number1.setSimplifiedValue(1,2);
        number2.setSimplifiedValue(3,4);
        Rational result = number1.add(number2);
        assertEquals(5, result.getNumerator());
        assertEquals(4, result.getDenominator());


    }

    @Test
    void sub() {
        number1.setSimplifiedValue(3, 4);
        number2.setSimplifiedValue(1, 2);
        Rational result = number1.sub(number2);
        assertEquals(1, result.getNumerator());
        assertEquals(4, result.getDenominator());
    }

    @Test
    void mul() {
        number1.setSimplifiedValue(2, 3);
        number2.setSimplifiedValue(3, 5);
        Rational result = number1.mul(number2);
        assertEquals(2, result.getNumerator());
        assertEquals(5, result.getDenominator());
    }

    @Test
    void div() {
        number1.setSimplifiedValue(5, 6);
        number2.setSimplifiedValue(2, 3);
        Rational result = number1.div(number2);
        assertEquals(5, result.getNumerator());
        assertEquals(4, result.getDenominator());
    }

    @Test
    void toFloatingPoint() {
        number1.setSimplifiedValue(3, 4);
        double result = number1.toFloatingPoint();
        assertEquals(0.75, result);
    }

    @Test
    void toComplexNumber() {
        number1.setSimplifiedValue(7, 4);
        String result = number1.toComplexNumber();
        assertEquals("1 + 3/4", result);
    }

    @Test
    public void testToStringReturn() {
        number1.setSimplifiedValue(2, 4);
        String result = number1.toString();
        assertEquals("1/2", result);
    }

    @Test
    public void testToString() {
        number1.setSimplifiedValue(0, 4);
        String result = number1.toString();
        assertEquals("0", result);
    }

    @Test
    public void testSetValue() {
        number1.setValue(2, 3);
        assertEquals(2, number1.getNumerator());
        assertEquals(3, number1.getDenominator());
    }
}
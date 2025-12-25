package stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EvaluateReversePolishNotationTest {

    @Test
    void evalRPNRecursive() {
        assertEquals(6, new EvaluateReversePolishNotation().evalRPNRecursive(
                new String[]{"4","13","5","/","+"}));
    }
}
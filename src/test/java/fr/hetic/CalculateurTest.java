package fr.hetic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class CalculateurTest {

    @Test
    public void additionOfTwoNumbersReturnsCorrectResult() {
        float result = Calculateur.operations.get("+").apply(2.0f, 3.0f);
        assertEquals(5.0f, result);
    }

    @Test
    public void subtractionOfTwoNumbersReturnsCorrectResult() {
        float result = Calculateur.operations.get("-").apply(5.0f, 3.0f);
        assertEquals(2.0f, result);
    }

    @Test
    public void multiplicationOfTwoNumbersReturnsCorrectResult() {
        float result = Calculateur.operations.get("*").apply(2.0f, 3.0f);
        assertEquals(6.0f, result);
    }

    @Test
    public void operationWithInvalidOperatorReturnsNull() {
        assertNull(Calculateur.operations.get("/"));
    }
}
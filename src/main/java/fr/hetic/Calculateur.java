package fr.hetic;

import java.util.Map;
import java.util.function.BinaryOperator;

public class Calculateur {
    static final Map<String, BinaryOperator<Float>> operations = Map.of(
            "+", (a, b) -> a + b,
            "-", (a, b) -> a - b,
            "*", (a, b) -> a * b
    );

    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Utilisation: java Calculateur <nombre> <nombre> <opérateur>");
            return;
        }

        float a = Float.parseFloat(args[0]);
        float b = Float.parseFloat(args[1]);
        String operator = args[2];

        BinaryOperator<Float> operation = operations.get(operator);
        if (operation == null) {
            System.out.println("Opérateur invalide: " + operator);
            return;
        }

        float result = operation.apply(a, b);
        System.out.println("Résultat: " + result);
    }
}
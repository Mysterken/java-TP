interface Operation {
    float calculate(float a, float b);
}

public class Calculateur {
    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Utilisation: java Calculateur <nombre> <nombre> <opérateur>");
            return;
        }

        float a = Float.parseFloat(args[0]);
        float b = Float.parseFloat(args[1]);
        String operator = args[2];

        try {
            Operation operation = OperationFactory.getOperation(operator);
            float result = operation.calculate(a, b);
            System.out.println("Résultat: " + result);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}

class OperationFactory {
    public static Operation getOperation(String operator) {
        switch (operator) {
            case "+":
                return new Addition();
            case "-":
                return new Subtraction();
            case "*":
                return new Multiplication();
            default:
                throw new IllegalArgumentException("Opérateur invalide: " + operator);
        }
    }
}

class Addition implements Operation {
    @Override
    public float calculate(float a, float b) {
        return a + b;
    }
}

class Multiplication implements Operation {
    @Override
    public float calculate(float a, float b) {
        return a * b;
    }
}

class Subtraction implements Operation {
    @Override
    public float calculate(float a, float b) {
        return a - b;
    }
}

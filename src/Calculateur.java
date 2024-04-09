public class Calculateur {
    public static void main(String[] args) {

        if (args.length != 3) {
            System.out.println("Utilisation: java Calculateur <nombre> <nombre> <opérateur>");
            return;
        }

        float a = Float.parseFloat(args[0]);
        float b = Float.parseFloat(args[1]);

        String operator = args[2];

        float result;
        switch (operator) {
            case "+":
                result = a + b;
                break;
            case "-":
                result = a - b;
                break;
            case "*":
                result = a * b;
                break;
            default:
                System.out.println("Opérateur invalide: " + operator);
                return;
        }

        System.out.println("Résultat: " + result);
    }
}

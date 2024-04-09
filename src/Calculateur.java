import java.io.*;

public class Calculateur {
    public static void main(String[] args) {

        if (args.length < 1) {
            System.out.println("Veuillez spécifier le chemin du dossier contenant les fichiers à traiter");
            return;
        }

        String path = args[0];

        File folder = new File(path);
        File[] listOfFiles = folder.listFiles();

        if (listOfFiles == null) {
            System.out.println("Le dossier spécifié est vide");
            return;
        }

        for (File file : listOfFiles) {
            if (file.isFile() && file.getName().endsWith(".op")) {
                try {

                    BufferedReader reader = new BufferedReader(new FileReader(file));
                    BufferedWriter writer = new BufferedWriter(new FileWriter(file.getAbsolutePath().replace(".op", ".res")));

                    String line;

                    while ((line = reader.readLine()) != null) {

                        String[] parts = line.split(" ");

                        if (parts.length != 3) {
                            writer.write("ERROR\n");
                            continue;
                        }

                        try {

                            float a = Float.parseFloat(parts[0]);
                            float b = Float.parseFloat(parts[1]);
                            float result = 0;

                            switch (parts[2]) {
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
                                    writer.write("ERROR\n");
                                    continue;
                            }

                            writer.write(result + "\n");
                        } catch (NumberFormatException e) {
                            writer.write("ERROR\n");
                        }
                    }

                    reader.close();
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        System.out.println("Traitement terminé");

    }
}

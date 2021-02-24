import com.br.companyabc.healthylife.model.Client;

import java.io.File;
import java.util.Scanner;

public class TestClientScanner {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("clients.csv"), "utf-8");

            while (scanner.hasNextLine()) {
                try {
                    String line = scanner.nextLine();
                    Scanner lineScanner = new Scanner(line);

                    lineScanner.useDelimiter(",");

                    String name = lineScanner.next();
                    Double weight = Double.parseDouble(lineScanner.next());
                    Double height = Double.parseDouble(lineScanner.next());

                    Client c = new Client(name, weight, height);
                    c.calculateImc();
                    c.classifyImc();

                    System.out.printf("%s (%.2f) -> %s%n", c.getName(), c.getWeight(), c.getImcClassification());
                } catch (Exception e) {
                    System.out.printf("Error: %s%n", e);
                }

            }
        } catch (Exception ex) {
            System.out.printf("Error: %s", ex);
        }
    }
}

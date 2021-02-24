import com.br.companyabc.healthylife.exception.HighHeightException;
import com.br.companyabc.healthylife.exception.HighWeightException;
import com.br.companyabc.healthylife.model.Client;
import com.br.companyabc.healthylife.model.Man;
import com.br.companyabc.healthylife.model.Women;

import java.util.ArrayList;

public class TestClientArrayList {
    public static void main(String[] args) {
        try {
            Client c1 = new Man("Henrique Pessolato", 64.5, 1.65);
            Client c2 = new Women("Giulia Figueiredo", 50.0, 1.50);
            Client c3 = new Women("Carla Peixoto", 100.0, 1.60);
            Client c4 = new Man("Rodrigo Carlos", -50.0, 3.0);

            ArrayList<Client> clientList = new ArrayList<>();
            clientList.add(c1);
            clientList.add(c2);
            clientList.add(c3);
            clientList.add(c4);
            clientList.remove(c4);

            for (Client c : clientList) {
                c.calculateImc();
                c.classifyImc();
                System.out.printf("%s -> %s%n", c.getName(), c.getImcClassification());
            }
        } catch (Exception ex) {
            System.out.printf("Ocorreu uma exceção: %s", ex.getMessage());
            System.out.printf("Classe de exceção: %s", ex.getClass().getName());
        }
    }
}

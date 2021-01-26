import com.br.companyabc.healthylife.model.Client;
import com.br.companyabc.healthylife.model.Man;
import com.br.companyabc.healthylife.model.Women;

import java.util.ArrayList;
import java.util.Comparator;

class ClientNameComparator implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        Client c1 = (Client) o1;
        Client c2 = (Client) o2;

        return c1.getName().compareTo(c2.getName());
    }
}

public class TesteClientArrayListComparator {
    public static void main(String[] args) {
        Client c1 = new Man("Henrique Pessolato", 64.5, 1.65);
        Client c2 = new Women("Giulia Figueiredo", 50.0, 1.50);
        Client c3 = new Women("Carla Peixoto", 100.0, 1.60);

        ArrayList<Client> clientList = new ArrayList<>();
        clientList.add(c1);
        clientList.add(c2);
        clientList.add(c3);

        clientList.sort(new ClientNameComparator());

        clientList.forEach(item -> System.out.println(item));

    }
}

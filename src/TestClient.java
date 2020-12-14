import com.br.companyabc.healthylife.model.Client;
import com.br.companyabc.healthylife.model.Man;

import java.time.LocalDate;

class TestClient {
    public static void main(String[] args) {
        try (Client c = new Man("Henrique Pessolato", 67.0, 1.68) {
        }){
            LocalDate birthDate = LocalDate.of(1995, 5, 26);
            c.setActivityLevel(2);
            c.calculateImc();
            //c.calculateImc(10.0);
            c.classifyImc();
            c.calculateAge(birthDate);
            c.calculateCaf();
            c.calculateEer();
            c.chooseDiet();
            System.out.println("Classificação de IMC: " + c.getImcClassification());
            System.out.println("Valor da Dieta: " + c.getDiet() + " KCAL");
        } catch (Exception ex) {
            System.out.println("Ocorreu uma exceção: " + ex.getMessage());
            System.out.println("Classe de exceção: " + ex.getClass().getName());
        }

        System.out.println("Fim do programa!");
    }
}

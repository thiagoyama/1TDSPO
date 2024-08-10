import java.util.*;

public class MapTest {

    public static void main(String[] args) {
        //Criar um mapeamento de veículos, chave é a placa do veículo, valor é modelo do carro
        Map<String, String> veiculos = new HashMap<>();

        //Adicionar 3 veículos no mapeamento
        veiculos.put("ABC-1234", "Gol 1.0 Bege");
        veiculos.put("KD23FS0", "Civic 2.0 Preto");
        veiculos.put("JKS12KD", "Fusca 1.0 Amarelo");

        //Recuperar o modelo do veículo pela placa
        System.out.println(veiculos.get("JKS12KD"));

        //Adicionar um veículo com a mesma chave? adicionar a chave ABC-1234 o veiculo Palio 1.0
        veiculos.put("ABC-1234", "Palio 1.0");
        System.out.println(veiculos.get("ABC-1234"));

        //Exibir todos os veiculos no formato: placa : modelo
        Set<String> chaves = veiculos.keySet();
        for (String item : chaves){
            System.out.println(item + " : " + veiculos.get(item));
        }

        for (Map.Entry<String, String> entry : veiculos.entrySet()) {
            System.out.println("Placa: " + entry.getKey() + ", Veículo: " + entry.getValue());
        }

        Map<Integer, List<String>> superMapa = new HashMap<>();
        superMapa.put(1, Arrays.asList(new String[]{"Gol", "Palio", "Fusca"}));
        superMapa.put(2, Arrays.asList(new String[]{"Civic", "Corolla", "Sentra"}));

    }
}

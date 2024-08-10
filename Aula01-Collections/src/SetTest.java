import java.util.HashSet;
import java.util.Set;

public class SetTest {

    public static void main(String[] args) {
        //Criar uma coleção de esportes olimpicos
        Set<String> esportes = new HashSet<>();

        //Adicionar 4 esportes
        esportes.add("Break Dance");
        esportes.add("Volei");
        esportes.add("Basquete");
        esportes.add("Natação");

        //Adicionar novamente um elemento repetido
        esportes.add("Volei");

        //Exibir os esportes do conjunto
        for (String item : esportes){
            System.out.println(item);
        }
    }
}

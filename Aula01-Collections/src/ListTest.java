import java.util.ArrayList;
import java.util.List;

public class ListTest {
    public static void main(String[] args) {

        List<String> compras = new ArrayList<>();
        compras.add("Arroz");
        compras.add("Feijão");
        //compras.add(100); erro de compilação por causa do generics

        //1-Exibir a quantidade de elementos da lista
        int tamanho = compras.size();
        System.out.println("Itens na lista: " + tamanho);

        //2-Remover o Feijão da lista
        compras.remove("Feijão");

        //3-Validar se o Macarrão está na lista
        System.out.println("Tem Macarrão?" + compras.contains("Macarrão"));

        //4-Criar um array(vetor) da lista
        String[] vetorCompras = compras.toArray(new String[]{});

        //5-Adicionar o Macarrão na primeira posição da lista
        compras.add(0,"Macarrão");

        //6-Exibir o item da lista de compra que está na posição 0
        System.out.println("Item posição 0: " + compras.get(0));

        //7-Apagar toda a lista de compra
        compras.clear();

        //8-Adicionar os itens PlayStation, Xbox, TV, Nintendo
        compras.add("PlayStation");
        compras.add("XBox");
        compras.add("TV");
        compras.add("Nintendo");

        //9-Substituir o item da posição 0 por Chocolate
        compras.set(0, "Chocolate");

        //10-Achar a posição do primeiro Chocolate
        System.out.println("Posição do chocolate: " + compras.indexOf("Chocolate"));

        //11-Criar uma sublista dos dois primeiros itens da lista
        List<String> subLista = compras.subList(0, 2);

        System.out.println("Sublista");
        for (String item : subLista ){
            System.out.println(item);
        }

        System.out.println("Lista completa");
        //Percorrer a lista e exibir o item da lista
        for (String item : compras){
            System.out.println(item);
        }
    }
}
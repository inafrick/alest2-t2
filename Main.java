
import java.util.List;

public class Main {
    public static void main(String[] args) {
        float nano = System.nanoTime();
        Reader reader = new Reader();
        List<Box> caixas = reader.lerCaixas("casosT30/caso10000.txt");
        Graph grafo = new Graph(caixas);

        List<Box> maiorCaminho = grafo.encontrarCaminhoMaisLongo();

        System.out.println("Quantidade de caixas da maior sequência: " + maiorCaminho.size());
        nano = System.nanoTime() - nano;
        System.out.println("Tempo de execução: " + nano / 1000000 + "ms");
    }
}
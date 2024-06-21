
import java.util.List;

public class Main {
    public static void main(String[] args) {
        float nano = System.nanoTime();
        Reader reader = new Reader();
        List<Box> boxes = reader.readBoxes("casosT30/caso10000.txt");
        Graph graph = new Graph(boxes);

        List<Box> longestPath = graph.findLongestPath();

        System.out.println("Longest path: ");
        for (Box box : longestPath) {
            System.out.println(box);
        }

        System.out.println("Quantidade de caixas da maior sequência: " + longestPath.size());
        nano = System.nanoTime() - nano;
        System.out.println("Tempo de execução: " + nano / 1000000 + "ms");
    }
}
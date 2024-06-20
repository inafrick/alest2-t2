import java.util.List;

public class Main {
    public static void main(String[] args) {
        Reader reader = new Reader();
        List<Box> list = reader.readBoxes("casosT30/exemplo.txt");

        Graph graph = new Graph();
        graph.buildGraph(list);

        List<Box> longestPath = graph.findLongestPath();

        System.out.println("Maior sequência:");
        for (Box box : longestPath) {
            System.out.println(box);
        }

        System.out.println("Quantidade de caixas da maior sequência: " + longestPath.size());
    }
}
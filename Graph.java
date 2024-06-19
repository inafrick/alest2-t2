import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Graph {
    protected static final String NEWLINE = System.getProperty("line.separator");

    protected Map<Box, List<Box>> graph;
    protected Set<Box> vertices;

    public Graph() {
        graph = new HashMap<>();
        vertices = new HashSet<>();
    }

    public Graph(String filename) {
        this();
        Reader reader = new Reader();
        List<Box> list = reader.readBoxes(filename);
        for (Box b : list) {
            // b.canNest(b);
        }
    }

    public void addEdge(Box v, Box w) {
        addToList(v, w);
        addToList(w, v);
        if (!vertices.contains(v)) {
            vertices.add(v);
        }
        if (!vertices.contains(w)) {
            vertices.add(w);
        }
    }

    public Iterable<Box> getAdj(Box v) {
        List<Box> res = graph.get(v);
        if (res == null)
            res = new LinkedList<>();
        return res;
    }

    // Adiciona um vértice adjacente a outro, criando a lista
    // de adjacências caso ainda não exista no dicionário
    protected List<Box> addToList(Box v, Box w) {
        List<Box> list = graph.get(v);
        if (list == null)
            list = new LinkedList<>();
        list.add(w);
        graph.put(v, list);
        return list;
    }
}
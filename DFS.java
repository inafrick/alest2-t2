import java.util.*;

public class DFS {
    private Set<Box> marked;
    private Map<Box, Box> edgeTo;
    private Box start;

    public DFS(Graph G, Box start) {
        this.start = start;
        marked = new HashSet<>();
        edgeTo = new HashMap<>();
        dfs(G, start);
    }

    boolean hasPathTo(Box v) {
        return marked.contains(v);
    }

    Iterable<Box> pathTo(Box v) {
        if (!hasPathTo(v))
            return null;
        List<Box> path = new LinkedList<>();
        Box w = v;
        while (!w.equals(start)) {
            path.add(0, w); // insere no início da lista
            w = edgeTo.get(w);
        }
        path.add(0, start);
        return path;
    }

    private void dfs(Graph g, Box s) {
        System.out.println("Visitando: " + s);
        marked.add(s);
        for (Box w : g.getAdj(s)) {
            if (!marked.contains(w)) {
                edgeTo.put(w, s);
                dfs(g, w);
            }
        }
    }
}
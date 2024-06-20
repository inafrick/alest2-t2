import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Graph {
    protected Map<Box, List<Box>> graph;
    protected Set<Box> vertices;
    protected int totalVertices;
    protected int totalEdges;

    public Graph() {
        graph = new HashMap<>();
        vertices = new HashSet<>();
        totalVertices = totalEdges = 0;
    }

    public void buildGraph(List<Box> boxes) {
        Collections.sort(boxes);

        for (Box box : boxes) {
            if (!vertices.contains(box)) {
                vertices.add(box);
                totalVertices++;
            }
        }

        for (int i = 0; i < boxes.size(); i++) {
            Box currentBox = boxes.get(i);
            for (int j = i + 1; j < boxes.size(); j++) {
                Box nextBox = boxes.get(j);
                if (currentBox.canNest(nextBox)) {
                    addEdge(currentBox, nextBox);
                }
            }
        }
    }

    public void addEdge(Box v, Box w) {
        addToList(v, w);
    }

    public Iterable<Box> getAdj(Box v) {
        List<Box> res = graph.get(v);
        if (res == null)
            res = new LinkedList<>();
        return res;
    }

    public Set<Box> getVerts() {
        return vertices;
    }

    public int getTotalVertices() {
        return totalVertices;
    }

    public int getTotalEdges() {
        return totalEdges;
    }

    protected List<Box> addToList(Box v, Box w) {
        List<Box> list = graph.get(v);
        if (list == null)
            list = new LinkedList<>();
        list.add(w);
        graph.put(v, list);
        totalEdges++;
        return list;
    }

    public List<Box> findLongestPath() {
        List<Box> longestPath = new LinkedList<>();
        Map<Box, List<Box>> boxList = new HashMap<>();
        for (Box box : getVerts()) {
            List<Box> currentPath = findLongestPathFromBox(box, boxList);
            if (currentPath.size() > longestPath.size()) {
                longestPath = currentPath;
            }
        }
        return longestPath;
    }

    private List<Box> findLongestPathFromBox(Box box, Map<Box, List<Box>> boxList) {
        if (boxList.containsKey(box)) {
            return boxList.get(box);
        }
        List<Box> longestPath = new LinkedList<>();
        for (Box neighbor : getAdj(box)) {
            List<Box> currentPath = findLongestPathFromBox(neighbor, boxList);
            if (currentPath.size() > longestPath.size()) {
                longestPath = currentPath;
            }
        }
        List<Box> result = new ArrayList<>();
        result.add(box);
        result.addAll(longestPath);
        boxList.put(box, result);
        return result;
    }
}
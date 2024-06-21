import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {
    private List<Box> vertices;
    private Map<Box, List<Box>> adjList;

    public Graph(List<Box> boxes) {
        vertices = new ArrayList<>(boxes);
        adjList = new HashMap<>();
        for (Box box : boxes) {
            adjList.put(box, new ArrayList<>());
        }
        buildGraph();
    }

    private void buildGraph() {
        Collections.sort(vertices);
        for (int i = 0; i < vertices.size(); i++) {
            Box currentBox = vertices.get(i);
            for (int j = i + 1; j < vertices.size(); j++) {
                Box nextBox = vertices.get(j);
                if (currentBox.canNest(nextBox)) {
                    adjList.get(currentBox).add(nextBox);
                }
            }
        }
    }

    public List<Box> findLongestPath() {
        Map<Box, List<Box>> memo = new HashMap<>();
        List<Box> longestPath = new ArrayList<>();

        for (Box box : vertices) {
            List<Box> currentPath = findLongestPathFromBox(box, memo);
            if (currentPath.size() > longestPath.size()) {
                longestPath = currentPath;
            }
        }
        return longestPath;
    }

    private List<Box> findLongestPathFromBox(Box box, Map<Box, List<Box>> memo) {
        if (memo.containsKey(box)) {
            return memo.get(box);
        }

        List<Box> longestPath = new ArrayList<>();
        for (Box neighbor : adjList.get(box)) {
            List<Box> currentPath = findLongestPathFromBox(neighbor, memo);
            if (currentPath.size() > longestPath.size()) {
                longestPath = currentPath;
            }
        }

        List<Box> result = new ArrayList<>();
        result.add(box);
        result.addAll(longestPath);
        memo.put(box, result);

        return result;
    }
}
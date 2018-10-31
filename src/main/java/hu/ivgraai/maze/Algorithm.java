package hu.ivgraai.maze;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Gergo IVAN
 * @since 31 Oct, 2018
 */
public class Algorithm {

    public static TraverseResult isReachable(Graph graph, Object source, Object target) {
        Map<Vertex, Colour> statuses = new HashMap<>();
        Map<Vertex, Vertex> ancestor = new HashMap<>();

        for (Vertex v : graph.getVertices()) {
            statuses.put(v, Colour.White);
            ancestor.put(v, null);
        }
        depthFirstSearch(graph, statuses, ancestor, graph.getVertex(source));

        final List<Object> links = new ArrayList<>();

        Vertex var = graph.getVertex(target);
        if (!Colour.White.equals(statuses.get(var))) {
            do {
                links.add(var.getId());
                var = ancestor.get(var);
            } while (null != var);
        }

        return new TraverseResult() {
            @Override
            public List<Object> sequence() {
                return links;
            }
        };
    }

    private static Void depthFirstSearch(Graph graph, Map<Vertex, Colour> visited, Map<Vertex, Vertex> parent, Vertex reference) {
        visited.put(reference, Colour.Grey);

        for (Vertex v : graph.getNeighbours(reference)) {
            if (Colour.White.equals(visited.get(v))) {
                parent.put(v, reference);
                depthFirstSearch(graph, visited, parent, v);
            }
        }

        visited.put(reference, Colour.Black);
        return null;
    }

    private enum Colour { White, Grey, Black }

    public static interface TraverseResult {

        List<Object> sequence();

    }

}

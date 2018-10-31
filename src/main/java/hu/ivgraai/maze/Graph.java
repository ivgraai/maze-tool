package hu.ivgraai.maze;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author Gergo IVAN
 * @since 31 Oct, 2018
 */
public class Graph { // undirected

    private final Map<Vertex, Edges> MATRIX = new HashMap<>();

    public Graph() {
        // empty method
    }

    public void addEdge(Vertex u, Vertex v) {
        if (!MATRIX.containsKey(u)) {
            MATRIX.put(u, new Edges());
        }
        if (!MATRIX.containsKey(v)) {
            MATRIX.put(v, new Edges());
        }

        MATRIX.get(u).add(v);
        MATRIX.get(v).add(u);
    }

    public Set<Vertex> getVertices() {
        return MATRIX.keySet();
    }

    public Vertex getVertex(Object id) {
        for (Vertex v : MATRIX.keySet()) {
            if (id.equals(v.getId())) {
                return v;
            }
        }

        throw new UnsupportedOperationException();
    }

    public Edges getNeighbours(Vertex v) {
        return MATRIX.get(v);
    }

}

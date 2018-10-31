package hu.ivgraai.maze;

import hu.ivgraai.maze.Input.Coordinate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Gergo IVAN
 * @since 31 Oct, 2018
 */
public class Utility {

    private static final Integer VALUE_WALLS = 1;
    private static final Integer VALUE_PASSAGE = 0;
    private static final Character CHAR_WALLS = '#';
    private static final Character CHAR_PASSAGE = ' ';
    private static final Character CHAR_PATH = 'X';
    private static final Character CHAR_START = 'S';
    private static final Character CHAR_END = 'E';

    public static Object convertIdentifier(int x, int y) {
        return new Coordinate().setX(x).setY(y);
    }

    private static Vertex biFunction(int x, int y) {
        return new Vertex(convertIdentifier(x, y));
    }

    public static Graph parseInput(Input input) {
        Graph g = new Graph();

        for (int i = 0; i < input.getHeight(); ++i) {
            for (int j = 0; j < input.getWidth(); ++j) {
                Coordinate cord = new Coordinate()
                    .setX(i)
                    .setY(j);

                if (VALUE_WALLS.equals(input.getValue(cord))) {
                    continue;
                }
                Vertex src = new Vertex(cord);

                if (0 < (i - 1) && VALUE_PASSAGE.equals(input.getValue(i - 1, j))) {
                    g.addEdge(src, biFunction(i - 1, j));
                }
                if (0 < (j - 1) && VALUE_PASSAGE.equals(input.getValue(i, j - 1))) {
                    g.addEdge(src, biFunction(i, j - 1));
                }
                if ((j + 1) < input.getWidth() && VALUE_PASSAGE.equals(input.getValue(i, j + 1))) {
                    g.addEdge(src, biFunction(i, j + 1));
                }
                if ((i + 1) < input.getHeight() && VALUE_PASSAGE.equals(input.getValue(i + 1, j))) {
                    g.addEdge(src, biFunction(i + 1, j));
                }
            }
        }

        return g;
    }

    public static List<List<Character>> parseOutput(Input input, Algorithm.TraverseResult result) {
        List<List<Character>> retval = new ArrayList<>();
        for (int i = 0; i < input.getHeight(); ++i) {

            List<Character> fragment = new ArrayList<>();
            for (int j = 0; j < input.getWidth(); ++j) {
                Coordinate current = new Coordinate().setX(i).setY(j);
                if (VALUE_WALLS.equals(input.getValue(i, j))) {
                    fragment.add(CHAR_WALLS);
                } else if (input.getStart().getX() == j && input.getStart().getY() == i) {
                    fragment.add(CHAR_START);
                } else if (input.getEnd().getX() == j && input.getEnd().getY() == i) {
                    fragment.add(CHAR_END);
                } else if (result.sequence().contains(current)) {
                    fragment.add(CHAR_PATH);
                } else {
                    fragment.add(CHAR_PASSAGE);
                }
            }
            retval.add(fragment);

        }

        return retval;
    }

}

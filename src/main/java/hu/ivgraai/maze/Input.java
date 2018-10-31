package hu.ivgraai.maze;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Gergo IVAN
 * @since 31 Oct, 2018
 */
public class Input {

    private int width;
    private int height;
    private final Coordinate start = new Coordinate();
    private final Coordinate end = new Coordinate();
    private final List<List<Integer>> values = new ArrayList<>();

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Coordinate getStart() {
        return start;
    }

    public void setStart(int x, int y) {
        this.start.x = x;
        this.start.y = y;
    }

    public Coordinate getEnd() {
        return end;
    }

    public void setEnd(int x, int y) {
        this.end.x = x;
        this.end.y = y;
    }

    public Integer getValue(Coordinate c) {
        return values.get(c.x).get(c.y);
    }

    public Integer getValue(int x, int y) {
        return values.get(x).get(y);
    }

    public void addValues(List<Integer> values) {
        this.values.add(values);
    }

    public static class Coordinate {

        private int x;
        private int y;

        public Coordinate() {
            // empty method
        }

        public int getX() {
            return x;
        }

        public Coordinate setX(int x) {
            this.x = x;
            return this;
        }

        public int getY() {
            return y;
        }

        public Coordinate setY(int y) {
            this.y = y;
            return this;
        }

        @Override
        public int hashCode() {
            int hash = 7;
            hash = 13 * hash + this.x;
            hash = 13 * hash + this.y;
            return hash;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            final Coordinate other = (Coordinate) obj;
            if (this.x != other.x) {
                return false;
            }
            return this.y == other.y;
        }

        @Override
        public String toString() {
            return "{" + "x=" + x + ", y=" + y + '}';
        }

    }

}

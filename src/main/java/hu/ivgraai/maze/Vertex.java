package hu.ivgraai.maze;

import java.util.Objects;

/**
 * @author Gergo IVAN
 * @since 31 Oct, 2018
 */
public class Vertex {

    // private Class<?> clazz;
    private Object id;

    public Vertex(Object id) {
        this.id = id;
    }

    public Object getId() {
        return id;
    }

    public void setId(Object id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.id);
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
        final Vertex other = (Vertex) obj;
        return Objects.equals(this.id, other.id);
    }

}

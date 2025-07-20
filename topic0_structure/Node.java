package topic0_structure;

import java.util.*;

public class Node {
    private int value;
    private List<Edge> neighbors;

    Node(int value) {
        this.value = value;
        this.neighbors = new ArrayList<>();
    }

    public int getValue() {
        return value;
    }
    public void setValue(int value) {
        this.value = value;
    }

    public List<Edge> getNeighbors() {
        return neighbors;
    }
    public void setNeighbors(List<Edge> neighbors) {
        this.neighbors = neighbors;
    }
}

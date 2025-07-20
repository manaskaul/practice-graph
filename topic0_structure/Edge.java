package topic0_structure;

public class Edge {
    private Node target;
    private int weight;

    Edge(Node target, int weight) {
        this.target = target;
        this.weight = weight;
    }

    public Node getTarget() {
        return target;
    }
    public void setTarget(Node target) {
        this.target = target;
    }

    public int getWeight() {
        return weight;
    }
    public void setWeight(int weight) {
        this.weight = weight;
    }
}

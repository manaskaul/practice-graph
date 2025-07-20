package topic1_representation;

import java.util.*;

public class GraphRepresentation {
    public static void main(String[] args) {
        List<List<Integer>> edges = List.of(
            List.of(0, 1, 5),
            List.of(1, 3, 3),
            List.of(2, 0, 6),
            List.of(3, 1, 4)
        );
        
        AdjMat matrix = new AdjMat(4);
        matrix.constructGraph(edges, true, true);
        matrix.printGraph();

        AdjList list = new AdjList(4);
        list.constructGraph(edges, true, true);
        list.printGraph();
    }
}



package topic3_minimum_spanning_tree;

import java.util.List;

public class MinimumSpanningTree {
    public static void main(String[] args) {
        List<List<Integer>> edges = List.of(
            List.of(0, 1, 2),
            List.of(0, 2, 1),
            List.of(1, 2, 1),
            List.of(2, 4, 2),
            List.of(2, 3, 2),
            List.of(4, 3, 1)
        );

        KruskalMst kmst = new KruskalMst();
        int weight1 = kmst.findMstWeight(edges, 5);
        System.out.println("Kruskal's MST Weight : " + weight1);
        
        PrimMst pmst = new PrimMst();
        int weight2 = pmst.findMstWeight(edges, 10);
        System.out.println("Prim's MST Weight : " + weight2);
    }
}

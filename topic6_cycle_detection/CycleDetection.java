package topic6_cycle_detection;

import java.util.List;

import topic1_representation.AdjList;

public class CycleDetection {
    public static void main(String[] args) {
        
        List<List<Integer>> edges1 = List.of(
            List.of(0, 1),
            List.of(0, 2),
            List.of(1, 3),
            List.of(2, 4),
            List.of(3, 5),
            List.of(4, 6),
            List.of(5, 7),
            List.of(6, 7),
            List.of(4, 8)
        );
        int V1 = 9;

        AdjList adjList1 = new AdjList(V1);
        List<List<Integer>> list1 = adjList1.constructList(edges1, false, false);

        UndirectedUnweighted undUnw = new UndirectedUnweighted();
        
        boolean isCyclic1 = undUnw.detectCycleUsingBfs(list1, V1, 0);
        System.out.printf("Graph is Cyclic ? (BFS) : %b\n", isCyclic1);
        
        boolean isCyclic2 = undUnw.detectCycleUsingDfs(list1, V1, 0);
        System.out.printf("Graph is Cyclic ? (DFS) : %b\n", isCyclic2);
    }
}

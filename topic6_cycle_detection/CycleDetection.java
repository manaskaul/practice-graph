package topic6_cycle_detection;

import java.util.List;

import topic1_representation.AdjList;

public class CycleDetection {
    public static void main(String[] args) {
        
        // UNDIRECTED ACYCLIC GRAPH
        List<List<Integer>> edges1 = List.of(
            List.of(0, 1),
            List.of(0, 2),
            List.of(1, 3),
            List.of(2, 4),
            List.of(3, 5),
            List.of(4, 6),
            List.of(5, 7),
            List.of(6, 8)
        );
        int V1 = 9;

        AdjList adjList1 = new AdjList(V1);
        List<List<Integer>> list1 = adjList1.constructList(edges1, false, false);

        UndirectedGraphCycleDetection und1 = new UndirectedGraphCycleDetection();
        
        boolean isCyclicBfs1 = und1.detectCycleUsingBfs(list1, V1, 0);
        System.out.printf("Undirected Graph is Cyclic ? (BFS) : %B\n", isCyclicBfs1);
        
        boolean isCyclicDfs1 = und1.detectCycleUsingDfs(list1, V1, 0);
        System.out.printf("Undirected Graph is Cyclic ? (DFS) : %B\n", isCyclicDfs1);


        // UNDIRECTED CYCLIC GRAPH
        List<List<Integer>> edges2 = List.of(
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
        int V2 = 9;

        AdjList adjList2 = new AdjList(V2);
        List<List<Integer>> list2 = adjList2.constructList(edges2, false, false);

        UndirectedGraphCycleDetection und2 = new UndirectedGraphCycleDetection();
        
        boolean isCyclicBfs2 = und2.detectCycleUsingBfs(list2, V2, 0);
        System.out.printf("Undirected Graph is Cyclic ? (BFS) : %B\n", isCyclicBfs2);
        
        boolean isCyclicDfs2 = und2.detectCycleUsingDfs(list2, V2, 0);
        System.out.printf("Undirected Graph is Cyclic ? (DFS) : %B\n", isCyclicDfs2);



        System.out.println();



        // DIRECTED ACYCLIC GRAPH
        List<List<Integer>> edges3 = List.of(
            List.of(0, 1),
            List.of(1, 2),
            List.of(2, 5),
            List.of(2, 3),
            List.of(3, 4),
            List.of(4, 5),
            List.of(5, 6)
        );
        int V3 = 7;

        AdjList adjList3 = new AdjList(V3);
        List<List<Integer>> list3 = adjList3.constructList(edges3, true, false);

        DirectedGraphCycleDetection dir1 = new DirectedGraphCycleDetection();
        
        boolean isCyclicDfs3 = dir1.detectCycleUsingDfs(list3, V3, 0);
        System.out.printf("Directed Graph is Cyclic ? (DFS) : %B\n", isCyclicDfs3);

        // DIRECTED ACYCLIC GRAPH
        List<List<Integer>> edges4 = List.of(
            List.of(0, 1),
            List.of(1, 2),
            List.of(2, 3),
            List.of(2, 6),
            List.of(3, 4),
            List.of(4, 5),
            List.of(5, 2),
            List.of(6, 7),
            List.of(6, 8),
            List.of(8, 7)
        );
        int V4 = 9;

        AdjList adjList4 = new AdjList(V4);
        List<List<Integer>> list4 = adjList4.constructList(edges4, true, false);

        DirectedGraphCycleDetection dir2 = new DirectedGraphCycleDetection();
        
        boolean isCyclicDfs4 = dir2.detectCycleUsingDfs(list4, V3, 0);
        System.out.printf("Directed Graph is Cyclic ? (DFS) : %B\n", isCyclicDfs4);
    }
}

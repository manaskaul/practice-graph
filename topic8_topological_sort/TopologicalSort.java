package topic8_topological_sort;

import java.util.*;

import topic1_representation.AdjList;

/**
 * Linear ordering of vertices such that if there is an edge between u & v, u appears before v in that ordering
 * Only valid on Directed Acyclic Graphs
 */
public class TopologicalSort {
    public static void main(String[] args) {

        List<List<Integer>> edges = List.of(
            List.of(2, 3),
            List.of(3, 1),
            List.of(4, 0),
            List.of(4, 1),
            List.of(5, 0),
            List.of(5, 2)
        );
        int V = 6;

        AdjList adjList = new AdjList(V);
        List<List<Integer>> list = adjList.constructList(edges, true, false);
        
        // DFS Algo
        DfsTopoSort dfsTopoSort = new DfsTopoSort();
        List<Integer> topoSortedList1 = dfsTopoSort.dfsTopologicalSort(list, V);

        System.out.printf("Topological Sort (DFS) : [ ");
        for(int t : topoSortedList1) {
            System.out.printf("%d ", t);
        }
        System.out.printf("]\n");

        // BFS Algo : Khan's Algo
        BfsTopoSort bfsTopoSort = new BfsTopoSort();
        List<Integer> topoSortedList2 = bfsTopoSort.bfsTopologicalSort(list, V);

        System.out.printf("Topological Sort (BFS) : [ ");
        for(int t : topoSortedList2) {
            System.out.printf("%d ", t);
        }
        System.out.printf("]\n");
    }
}

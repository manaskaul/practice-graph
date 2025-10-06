package topic8_topological_sort;

import java.util.*;

/**
 * Only valid on Directed Acyclic Graphs
 * for u -> v, u appears before v in linear ordering
 * Using 2 stacks - 1st for the dfs recursion and 2nd for the actual sorted node list
 * TC: O(V+E)
 * SC: O(V)
 */
public class DfsTopoSort {
    
    public List<Integer> dfsTopologicalSort(List<List<Integer>> adjList, int V) {
        List<Integer> topoSortedList = new ArrayList<>();
        
        boolean[] visited = new boolean[V];
        Stack<Integer> topoStack = new Stack<>();
        
        // check for all components
        for(int i=0; i<V; i++) {
            if(!visited[i]) {
                topoSort(adjList, V, i, visited, topoStack);
            }
        }

        while(!topoStack.isEmpty()) {
            topoSortedList.add(topoStack.pop());
        }

        return topoSortedList;
    }

    private static void topoSort(List<List<Integer>> adjList, int V, int node, boolean[] visited, Stack<Integer> topoStack) {
        visited[node] = true;

        for(int neighbor : adjList.get(node)) {
            if(!visited[neighbor]) {
                topoSort(adjList, V, neighbor, visited, topoStack);
            }
        }

        topoStack.push(node);
    }
}

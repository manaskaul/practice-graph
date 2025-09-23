package topic6_cycle_detection;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * Can always add a for loop to check for all components in a graph with disconnected components
 *
 * TC: O(V+E)
 * SC: O(V) 
 */
public class UndirectedGraphCycleDetection {
    
    
    public boolean detectCycleUsingBfs(List<List<Integer>> adjList, int V, int src) {
        // Queue holds [curr_element, parent]
        Queue<int[]> q = new LinkedList<>();
        boolean[] visited = new boolean[V+1];
        
        q.offer(new int[]{src, -1});
        visited[src] = true;

        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int currNode = curr[0];
            int parent = curr[1];

            for(int neighbor : adjList.get(currNode)) {
                if(!visited[neighbor]) {
                    q.offer(new int[]{neighbor, currNode});
                    visited[neighbor] = true;
                } else {
                    // checking if the neighbor is not the parent
                    // then it must have been processed by someone else
                    // and there must be a cycle
                    if(neighbor != parent) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public boolean detectCycleUsingDfs(List<List<Integer>> adjList, int V, int src) {
        boolean[] visited = new boolean[V+1];
        return dfsCycleDetection(adjList, V, visited, src, -1);
    }

    private boolean dfsCycleDetection(List<List<Integer>> adjList, int V, boolean[] visited, int curr, int parent) {
        visited[curr] = true;
        
        for(int neighbor : adjList.get(curr)) {
            if(!visited[neighbor]) {
                // Only return true if the cycle is detected
                // else check all the nodes
                if(dfsCycleDetection(adjList, V, visited, neighbor, curr)) {
                    return true;
                }
            } else {
                // checking if the neighbor is not the parent
                // then it must have been processed by someone else
                // and there must be a cycle
                if(neighbor != parent) {
                    return true;
                }
            }
        }
        return false;
    }
}

package topic6_cycle_detection;

import java.util.List;


/*
 * Cycle mean when travelling on a path (before any backtracking) and we encounter the same node again
 * This is tracked using 2 visited arrays : globalVisited & pathVisited
 * globalVisited keeps track of the nodes visited during the overall dfs recursion
 * pathVisited keeps track of the nodes visited during the path traversal
 * when backtracking, the pathVisited of the returning node is again unset
 * TC: O(V+E)
 * SC: O(V)
 */
// Can also make do with using a single visited array, by using int[] visited instead of boolean
// 0 would mark unvisited, 1 would mark global visited, 2 would mark path visited
public class DirectedGraphCycleDetection {
    
    public boolean detectCycleUsingDfs(List<List<Integer>> adjList, int V, int src) {
        boolean[] globalVisited = new boolean[V+1];
        boolean[] pathVisited = new boolean[V+1];

        return dfsCycleDetection(adjList, globalVisited, pathVisited, src);
    }

    private boolean dfsCycleDetection(List<List<Integer>> adjList, boolean[] globalVisited, boolean[] pathVisited, int curr) {
        
        globalVisited[curr] = true;
        pathVisited[curr] = true;

        for(int neighbor : adjList.get(curr)) {
            // the neighbor is not already visited
            if(!globalVisited[neighbor]) {
                // only return if cycle detected
                if(dfsCycleDetection(adjList, globalVisited, pathVisited, neighbor)) {
                    return true;
                }
            } 
            // the neighbor is visited globally
            else {
                // the neighbor was visited in the path
                if(pathVisited[neighbor]) {
                    return true;
                }
            }
        }

        pathVisited[curr] = false;
        
        return false;
    }
}

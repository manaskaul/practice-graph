package topic8_topological_sort;

import java.util.*;

/*
 * Only valid on Directed Acyclic Graphs
 * for u -> v, u appears before v in linear ordering
 * 
 * Using a Indegree array to store indegree cound for every node, and Queue to store the actual order
 * 
 * 1. Calculate the indegree (no of edges coming into a node) of all the nodes
 * 2. Add all nodes into queue with indegree 0 (there will be atleast 1 for DAG)
 * 3. Remove a node from the queue (this would also give the linear order) and process it, i.e. reduce the indegree for all its adjacent nodes by 1
 * 4. If indegree of any adjacent node becomes 0, add it into the queue
 * 5. Process the next node from queue
 * 
 * TC: O(V+E)
 * SC: O(V)
 */
public class BfsTopoSort {
    public List<Integer> bfsTopologicalSort(List<List<Integer>> adjList, int V) {
        
        List<Integer> topoSortedList = new ArrayList<>();

        int[] indegree = new int[V];
        Queue<Integer> q = new LinkedList<>();

        // Calculate indegree of all nodes
        for(int i=0; i<V; i++) {
            for(int adj : adjList.get(i)) {
                indegree[adj] += 1;
            }
        }

        // add nodes with indegree 0 into queue
        for(int i=0; i<V; i++) {
            if(indegree[i] == 0) {
                q.offer(i);
            }
        }

        // process each node with indegree 0 
        // remove it from the graph and and reduce indegree of adjacent nodes by 1
        // add adjacent node in queue if it's indegree becomes 0
        while(!q.isEmpty()) {
            int node = q.poll();
            topoSortedList.add(node);
            for(int adj : adjList.get(node)) {
                indegree[adj] -= 1;
                if(indegree[adj] == 0) {
                    q.offer(adj);
                }
            }
        }

        // cycle detection
        if (topoSortedList.size() != V) {
            throw new IllegalStateException("Graph has a cycle, topological sort not possible");
        }

        return topoSortedList;
    }
}

package topic4_shortest_path;

import java.util.Arrays;
import java.util.List;

/**
 * 
 * Works with negative edge weights and negative cycles
 * Helps to detect negative cycles
 * Only applicable for Directed Graphs
 * For Undirected graph, convert it to Directed version to make it work
 * 
 * TC : O(E * V)
 * 
 * Relaxation has to be done V-1 times
 * Relaxation means taking all the edges and finding : if (dist[srcNode] + weight < dist[tgtNode]) {}
 * So E relaxations are to be done V-1 times = E * V
 * Check for negative cycle means, even after the V-1 relaxations, there is still relaxation going to happen
 */
public class BellmanFord {

    /*
     * adjList is List of <srcNode, tgtNode, weight>
     */
    public int[] findDistanceFromSource(List<List<Integer>> adjList, int V) {
        int[] dist = new int[V+1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[0] = 0;
        for (int i = 1; i <= V-1; i++) {
            for (List<Integer> edge : adjList) {
                int srcNode = edge.get(0);
                int tgtNode = edge.get(1);
                int weight = edge.get(2);

                if (dist[srcNode] != Integer.MAX_VALUE && dist[srcNode] + weight < dist[tgtNode]) {
                    dist[tgtNode] = dist[srcNode] + weight;
                }
            }
        }

        
        for (List<Integer> edge : adjList) {
            int srcNode = edge.get(0);
            int tgtNode = edge.get(1);
            int weight = edge.get(2);

            if (dist[srcNode] != Integer.MAX_VALUE && dist[srcNode] + weight < dist[tgtNode]) {
                System.out.println("NEGATIVE CYCLE EXISTS");
                return new int[V+1];
            }
        }
        
        
        return dist;
    }
}

package topic4_shortest_path;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

import topic1_representation.Pair;

/**
 * Using PQ, check for the smallest weight first
 * For all the target nodes connected to the src node
 * If the distance to reach it is smaller than the current distance, use the new found distance
 * 
 * TC : E log(V)
 * 
 * Doesn't work with negative edge weight or negative 
 */
public class Dijkstra {

    public int[] findDistanceFromSource(List<List<Pair>> adjList, int V) {
        // Initlize dist array as infinity
        int[] dist = new int[V+1];
        for(int i=0; i<=V; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        // pq stores elements as {node, weight}
        PriorityQueue<List<Integer>> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.get(1)));
        
        dist[0] = 0;
        pq.offer(List.of(0, 0));

        while(!pq.isEmpty()) {
            List<Integer> elem = pq.poll();
            int srcNode = elem.get(0);
            int srcWeight = elem.get(1);

            List<Pair> tgtNodes = adjList.get(srcNode);
            for (Pair tgt : tgtNodes) {
                int tgtNode = tgt.getNode();
                int tgtWeight = tgt.getWeight();

                int totalWgt = srcWeight + tgtWeight;
                if (dist[tgtNode] > totalWgt) {
                    dist[tgtNode] = totalWgt;
                    pq.add(List.of(tgtNode, totalWgt));
                }
                
            }
        }

        return dist;
    }
}

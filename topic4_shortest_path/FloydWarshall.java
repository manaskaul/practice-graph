package topic4_shortest_path;

import java.util.ArrayList;
import java.util.List;

/*
 * Find source node from every node to every other node
 * Multiple source shortest path algo
 * Helps to detect negative cycle as well
 * 
 * TC: O(V^3)
 * 
 * Go via every vertex/edge (exaustive search)
 * We build a shortest path matrix for all the Vertices
 * The computation is to find the minimum via all the edges
 * 
 * To detect a negative cycle, cost[i][i], i.e. weight to go from a node to self, gets reduced to less than 0
 * 
 */
public class FloydWarshall {

    private final int INF = Integer.MAX_VALUE;

    public List<List<Integer>> findDistanceFromSource(List<List<Integer>> adjMat, int V) {

        for(int viaNode = 0; viaNode < V; viaNode++) {
            
            for(int srcNode = 0; srcNode < V; srcNode++) {
                
                int srcVia = adjMat.get(srcNode).get(viaNode);
                if (srcVia == INF) {
                    continue;
                }

                for(int tgtNode = 0; tgtNode < V; tgtNode++) {

                    int viaTgt = adjMat.get(viaNode).get(tgtNode);
                    if (viaTgt == INF) {
                        continue;
                    }


                    // costMat[srcNode][tgtNode] = Math.min(costMat[srcNode][tgtNode], costMat[srcNode][viaNode] + costMat[viaNode][tgtNode]);
                    adjMat.get(srcNode).set(tgtNode, 
                        Math.min(
                            adjMat.get(srcNode).get(tgtNode), 
                            adjMat.get(srcNode).get(viaNode) + adjMat.get(viaNode).get(tgtNode)
                        )
                    );
                }
            }
        }

        for(int i = 0; i < V; i++) {
            if(adjMat.get(i).get(i) < 0) {
                System.out.println("NEGATIVE CYCLE EXISTS");
                return new ArrayList<>();
            }
        }

        return adjMat;
    }
}

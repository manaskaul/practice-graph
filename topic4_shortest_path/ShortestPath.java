package topic4_shortest_path;

import java.util.List;

import topic1_representation.AdjList;
import topic1_representation.AdjMat;
import topic1_representation.Pair;

public class ShortestPath {
    public static void main(String[] args) {
        List<List<Integer>> edges1 = List.of(
            List.of(0, 1, 4),
            List.of(0, 2, 2),
            List.of(1, 2, 1),
            List.of(2, 3, 3),
            List.of(2, 4, 6),
            List.of(2, 5, 4),
            List.of(3, 4, 5),
            List.of(4, 5, 3)
        );
        int V1 = 6;

        AdjList list = new AdjList(V1);
        List<List<Pair>> adjList = list.constructGraph(edges1, false, true);
        
        Dijkstra dijkstra = new Dijkstra();
        System.out.printf("\n\nDijkstra: ");
        int[] dijkstrasShortestDistance = dijkstra.findDistanceFromSource(adjList, V1);
        for (int i = 0; i < V1; i++) {
            System.out.printf("%2d ", dijkstrasShortestDistance[i]);
        }


        
        List<List<Integer>> edges2 = List.of(
            List.of(3, 2, 6),
            List.of(5, 3, 1),
            List.of(0, 1, 5),
            List.of(1, 5, -3),
            List.of(1, 2, -2),
            List.of(3, 4, -2),
            List.of(2, 4, 3)
        );
        int V2 = 6;

        BellmanFord bellmanFord = new BellmanFord();
        int[] bellmanFordShortestDistance = bellmanFord.findDistanceFromSource(edges2, V2);
        System.out.printf("\n\nBellmanFord: ");
        for (int i = 0; i < V2; i++) {
            System.out.printf("%2d ", bellmanFordShortestDistance[i]);
        }



        List<List<Integer>> edges3 = List.of(
            List.of(3, 2, 6),
            List.of(5, 3, 1),
            List.of(0, 1, 5),
            List.of(1, 5, -3),
            List.of(1, 2, -2),
            List.of(3, 4, -2),
            List.of(2, 4, 3)
        );
        int V3 = 6;

        AdjMat adjMat = new AdjMat(V3);
        List<List<Integer>> mat3 = adjMat.constructList(edges3, true, true);

        FloydWarshall floydWarshall = new FloydWarshall();
        List<List<Integer>> floydWarshallShortestDistance = floydWarshall.findDistanceFromSource(mat3, V3);
        System.out.printf("\n\nFloydWarshall: \n");
        for (int i = 0; i < V3; i++) {
            for (int j = 0; j < V3; j++) {
                int val = floydWarshallShortestDistance.get(i).get(j);
                if (val == Integer.MAX_VALUE) {
                    System.out.printf("%2s ", "I");
                } else {
                    System.out.printf("%2d ", val);
                }
            }
            System.out.printf("\n");
        }

    }
}

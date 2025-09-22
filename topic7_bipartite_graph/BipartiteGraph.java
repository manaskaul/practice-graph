package topic7_bipartite_graph;

import java.util.*;

import topic1_representation.AdjList;

/*
 * Color the nodes of the graph with two colors so that no 2 edges have the same color
 * Linear graphs with no cycles are always bipartite
 * Any graph with even cycle length can be bipartite
 * Any graph with odd cycle length can never be bipartite
 * TC: O(V+E)
 * SC: O(V)
 */
// color options are only -1 or 1
// 0 : no color
// 1 : color 1
// -1 : color 2
public class BipartiteGraph {
    public static void main(String[] args) {
        List<List<Integer>> edges1 = List.of(
            List.of(0, 1),
            List.of(1, 2),
            List.of(1, 3),
            List.of(2, 4),
            List.of(3, 5),
            List.of(4, 6),
            List.of(5, 7),
            List.of(6, 8),
            List.of(7, 8),
            List.of(8, 9)
        );
        int V1 = 10;

        AdjList adjList1 = new AdjList(V1);
        List<List<Integer>> list1 = adjList1.constructList(edges1, false, false);

        List<List<Integer>> edges2 = List.of(
            List.of(1, 2),
            List.of(2, 3),
            List.of(2, 6),
            List.of(3, 4),
            List.of(6, 5),
            List.of(4, 5),
            List.of(4, 7),
            List.of(7, 8)
        );
        int V2 = 8;

        AdjList adjList2 = new AdjList(V1);
        List<List<Integer>> list2 = adjList2.constructList(edges2, false, false);

        System.out.printf("Is Graph Bipartite? (BFS) %B\n", checkBipartiteUsingBfs(list1, V1, 0));

        System.out.printf("Is Graph Bipartite? (BFS) %B\n", checkBipartiteUsingBfs(list2, V2, 1));

        System.out.printf("Is Graph Bipartite? (DFS) %B\n", checkBipartiteUsingDfs(list1, V1, 0));

        System.out.printf("Is Graph Bipartite? (DFS) %B\n", checkBipartiteUsingDfs(list2, V2, 1));
    }

    
    public static boolean checkBipartiteUsingBfs(List<List<Integer>> adjList, int V, int src) {
        Queue<Integer> q = new LinkedList<>();
        int[] color = new int[V+1];
        Arrays.fill(color, 0);

        q.offer(src);
        color[src] = 1;

        while(!q.isEmpty()) {
            int curr = q.poll();
            
            for(int neighbor : adjList.get(curr)) {
                // if neighbor is not visited
                if(color[neighbor] == 0) {
                    q.offer(neighbor);
                    color[neighbor] = -1 * color[curr];
                } 
                // if neighbor is visited
                else {
                    // check neighbor color cannot be same as currColor
                    if(color[neighbor] == color[curr]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static boolean checkBipartiteUsingDfs(List<List<Integer>> adjList, int V, int src) {
        int[] color = new int[V+1];
        Arrays.fill(color, 0);

        return dfsBipartite(adjList, color, src, 1);
    }

    private static boolean dfsBipartite(List<List<Integer>> adjList, int[] color, int currNode, int currColor) {
        color[currNode] = currColor;

        for(int neighbor : adjList.get(currNode)) {
            int neighborColor = -1 * currColor;
            // if neighbor is not visited
            if(color[neighbor] == 0) {
                // only return False if a recursive call fails (i.e. the graph was found to be not bipartite)
                // else check all the nodes
                if(!dfsBipartite(adjList, color, neighbor, neighborColor)) {
                    return false;
                }
            } 
            // if neighbor is visited
            else {
                // check neighbor color cannot be same as currColor
                if(color[neighbor] == color[currNode]) {
                    return false;
                }
            }
        }
        return true;
    }    
}

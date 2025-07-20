package topic2_traversal;

import java.util.*;

import topic0_structure.Graph;
import topic0_structure.Node;
import topic1_representation.*;

/*
 * 
    AdjMat mat = new AdjMat(4);
    List<List<Integer>> matrix = mat.constructGraph(edges, true, true);
    Graph g1 = new Graph();
    List<Node> g1NodeList = g1.buildGraphFromAdjMatrix(matrix);
    printMatGraph(g1NodeList);

    System.out.println();
    
    AdjList lst = new AdjList(4);
    List<List<Tuple>> list = lst.constructGraph(edges, false, false);
    Graph g2 = new Graph();
    Map<Integer, Node> g2NodeMap = g2.buildGraphFromAdjList(list);
    printListGraph(g2NodeMap);
 *
 */
public class GraphTraversal {
    public static void main(String[] args) {
        List<List<Integer>> edges = List.of(
            List.of(0, 1, 0),
            List.of(0, 2, 1),
            List.of(0, 8, 0),
            List.of(1, 5, 1),
            List.of(2, 3, 1),
            List.of(2, 4, 0),
            List.of(2, 7, 0),
            List.of(2, 9, 1),
            List.of(3, 6, 0),
            List.of(3, 7, 0),
            List.of(4, 7, 0),
            List.of(5, 8, 0),
            List.of(6, 9, 0)
        );

        AdjList adjList = new AdjList(10);
        List<List<Pair>> list1 = adjList.constructGraph(edges, false, false);
        List<List<Integer>> list2 = adjList.constructGraph(edges, false, false).stream().map(l -> l.stream().map(e -> e.getNode()).toList()).toList();
        
        Graph graph = new Graph();
        Map<Integer, Node> nodes = graph.buildGraphFromAdjList(list1, false);
        
        BFS bfs = new BFS();
        bfs.traverse(nodes.get(0));
        bfs.traverseWithAdjList(list2, 0);

        DFS dfs1 = new DFS();
        dfs1.as();
    }
}
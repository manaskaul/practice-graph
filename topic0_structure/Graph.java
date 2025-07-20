package topic0_structure;

import java.util.*;

import topic1_representation.Pair;
import topic1_representation.Unit;

public class Graph {
    
    public Map<Integer, Node> buildGraphFromAdjMatrix(List<List<Unit>> adjMat, boolean isDirected) {
        int n = adjMat.size();
        
        Map<Integer, Node> nodes = new HashMap<>();
        for (int i = 0; i < n; i++) {
            nodes.put(i, new Node(i));
        }

        for (int i = 0; i < n; i++) {
            Node from = nodes.get(i);
            for (int j = 0; j < n; j++) {
                int w = adjMat.get(i).get(j).getWeight();
                if (w != 0) {
                    Node to = nodes.get(j);
                    from.getNeighbors().add(new Edge(to, w));
                    if (!isDirected) {
                        to.getNeighbors().add(new Edge(from, w));
                    }
                }
            }
        }
        return nodes;
    }

    public Map<Integer, Node> buildGraphFromAdjList(List<List<Pair>> adjList, boolean isDirected) {
        int n = adjList.size();
        Map<Integer, Node> nodes = new HashMap<>();
        for (int i = 0; i < n; i++) {
            nodes.put(i, new Node(i));
        }

        for (int i = 0; i < n; i++) {
            Node from = nodes.get(i);
            for (Pair p : adjList.get(i)) {
                Node to = nodes.get(p.getNode());
                int  w  = p.getWeight();
                from.getNeighbors().add(new Edge(to, w));
                if (!isDirected) {
                    to.getNeighbors().add(new Edge(from, w));
                }
            }
        }
        return nodes;
    }
}

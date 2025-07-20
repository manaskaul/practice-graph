package topic1_representation;

import java.util.*;

/*
 * construct Adjacency List from list of edges
 * weight 0 means un-weighted edge
 * 
 */
public class AdjList implements GraphInterface<Pair> {
    private List<List<Pair>> graph;
    private List<List<Integer>> list;

    public AdjList(int nodes) {
        this.graph = new ArrayList<>();
        this.list = new ArrayList<>();
        for (int i = 0; i < nodes; i++) {
            List<Pair> graphRow = new ArrayList<>();
            graph.add(graphRow);

            List<Integer> listRow = new ArrayList<>();
            list.add(listRow);
        }
    }

    @Override
    public List<List<Pair>> constructGraph(List<List<Integer>> edges, boolean isDirected, boolean isWeighted) {
        edges.forEach(edge -> {
            int u = edge.get(0);
            int v = edge.get(1);
            int w = isWeighted ? edge.get(2) : 0;

            graph.get(u).add(new Pair(v, w));
            if (!isDirected) {
                graph.get(v).add(new Pair(u, w));
            }
        });
        return graph;
    }

    @Override
    public List<List<Integer>> constructList(List<List<Integer>> edges, boolean isDirected, boolean isWeighted) {
        edges.forEach(edge -> {
            int u = edge.get(0);
            int v = edge.get(1);
            // int w = isWeighted ? edge.get(2) : 0;

            // For weighted graphs, you may want to store pairs or arrays. List<List<int[]>> or List<List<Pair>>
            // But since this method returns List<List<Integer>>, we’ll assume we store neighbor or weight based on context.
            // Here: storing neighbors only

            list.get(u).add(v);

            if (!isDirected) {
                list.get(v).add(u);
            }
        });
        return list;
    }

    @Override
    public void printGraph() {
        System.out.println("\nAdjacency List");
        for (int i = 0; i < graph.size(); i++) {
            System.out.print(i + ": ");
            for (Pair t : graph.get(i)) {
                System.out.print("<" + t.getNode() + ", " + t.getWeight() + "> ");
            }
            System.out.println();
        }
    }
}

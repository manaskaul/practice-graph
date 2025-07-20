package topic1_representation;

import java.util.*;

/*
 * construct Adjacency Matrix from list of edges
 * weight 0 means un-weighted edge
 * 
 */
public class AdjMat implements GraphInterface<Unit> {
    private List<List<Unit>> graph;
    private List<List<Integer>> list;

    public AdjMat(int nodes) {
        this.graph = new ArrayList<>();
        for (int i = 0; i < nodes; i++) {
            List<Unit> graphRow = new ArrayList<>();
            for (int j = 0; j < nodes; j++) {
                graphRow.add(new Unit(0));
            }
            graph.add(graphRow);

            List<Integer> listRow = new ArrayList<>();
            list.add(listRow);
        }
    }

    @Override
    public List<List<Unit>> constructGraph(List<List<Integer>> edges, boolean isDirected, boolean isWeighted) {
        edges.forEach(edge -> {
            int i = edge.get(0);
            int j = edge.get(1);
            int w = isWeighted ? edge.get(2) : 0;

            graph.get(i).set(j, new Unit(w));
            if (!isDirected) {
                graph.get(j).set(i, new Unit(w));
            }
        });
        return graph;
    }

    @Override
    public List<List<Integer>> constructList(List<List<Integer>> edges, boolean isDirected, boolean isWeighted) {
        edges.forEach(edge -> {
            int u = edge.get(0);
            int v = edge.get(1);
            int w = isWeighted ? edge.get(2) : 0;

            list.get(u).set(v, w);

            if (!isDirected) {
                list.get(v).set(u, w);
            }
        });
        return list;
    }

    @Override
    public void printGraph() {
        System.out.println("\nAdjacency Matrix");
        System.out.print("   ");
        for (int j = 0; j < graph.get(0).size(); j++) {
            System.out.printf("%2d ", j);
        }
        System.out.println();

        for (int i = 0; i < graph.size(); i++) {
            System.out.printf("%2d ", i);
            for (int j = 0; j < graph.get(i).size(); j++) {
                System.out.printf("%2d ", graph.get(i).get(j).getWeight());
            }
            System.out.println();
        }
    }
}
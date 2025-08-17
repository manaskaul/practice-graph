package topic1_representation;

import java.util.*;

/*
 * construct Adjacency Matrix from list of edges
 * weight 0 means un-weighted edge
 * 
 */
public class AdjMat implements GraphInterface<Unit> {
    private List<List<Unit>> graph;
    private List<List<Integer>> matrix;

    private final int INF = Integer.MAX_VALUE;

    public AdjMat(int nodes) {
        this.graph = new ArrayList<>();
        this.matrix = new ArrayList<>();

        for (int i = 0; i < nodes; i++) {
            // Generate dummy graph<Unit> of size V x V with INF weights for unreachable nodes
            List<Unit> graphRow = new ArrayList<>();
            for (int j = 0; j < nodes; j++) {
                graphRow.add(new Unit(INF));
            }
            graph.add(graphRow);

            // Generate dummy matrix<Integer> of size V x V with INF weights for unreachable nodes
            List<Integer> matrixRow = new ArrayList<>();
            for (int j = 0; j < nodes; j++) {
                matrixRow.add(INF);
            }
            matrix.add(matrixRow);
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

            matrix.get(u).set(v, w);

            if (!isDirected) {
                matrix.get(v).set(u, w);
            }
        });
        return matrix;
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

    public void printMatrix() {
        System.out.println("\nAdjacency Matrix");
        System.out.print("   ");
        for (int j = 0; j < matrix.get(0).size(); j++) {
            System.out.printf("%2d ", j);
        }
        System.out.println();

        for (int i = 0; i < matrix.size(); i++) {
            System.out.printf("%2d ", i);
            for (int j = 0; j < matrix.get(i).size(); j++) {
                int v = matrix.get(i).get(j);
                if (v == INF) {
                    System.out.printf("%2s ", "I");
                } else {
                    System.out.printf("%2d ", v);
                }
            }
            System.out.println();
        }
    }
}
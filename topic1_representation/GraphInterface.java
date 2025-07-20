package topic1_representation;

import java.util.*;

public interface GraphInterface<T> {
    List<List<T>> constructGraph(List<List<Integer>> edges, boolean isDirected, boolean isWeighted);
    List<List<Integer>> constructList(List<List<Integer>> edges, boolean isDirected, boolean isWeighted);
    void printGraph();
}
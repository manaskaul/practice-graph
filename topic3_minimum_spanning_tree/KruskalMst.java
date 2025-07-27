package topic3_minimum_spanning_tree;

import java.util.*;

public class KruskalMst {

    // TC : O((E log E) + (E * 4 * alpha)) = O(E log E)
    // SC : O(2 * V) = O(V)
    public int findMstWeight(List<List<Integer>> edges, int noOfNodes) {
        int mstWeight = 0;
        
        List<List<Integer>> sortedEdges = new ArrayList<>(edges);

        // Sort edges based on weights
        Collections.sort(sortedEdges, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                return Integer.compare(o1.get(2), o2.get(2));
            };
        });

        // Create Disjoint Set while picking up new smallest edge each time
        DisjointSet ds = new DisjointSet(noOfNodes);
        for (List<Integer> edge : sortedEdges) {
            if (!ds.areNodesConnected(edge.get(0), edge.get(1))) {
                // if not connected, connect the edges and count the weight
                mstWeight += edge.get(2);
                ds.unionBySize(edge.get(0), edge.get(1));
            }
        }

        return mstWeight;
    }
}

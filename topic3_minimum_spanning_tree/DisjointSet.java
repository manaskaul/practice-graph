package topic3_minimum_spanning_tree;

import java.util.*;

public class DisjointSet {
    private List<Integer> parent;
    private List<Integer> rank;
    private List<Integer> size;

    DisjointSet(int noOfNodes) {
        parent = new ArrayList<>();
        rank = new ArrayList<>();
        size = new ArrayList<>();

        for(int i = 0; i <= noOfNodes; i++) {
            parent.add(i);
            rank.add(0);
            size.add(0);
        }
    }

    public int getParent(int node) {
        if (node == parent.get(node)) {
            return node;
        }
        parent.set(node, getParent(parent.get(node)));
        return parent.get(node);
    }

    public void unionByRank(int u, int v) {
        int ulp_u = getParent(u);
        int ulp_v = getParent(v);

        // make sure unnecessary path compression and parent checks are not done
        // and rank array is not corrupted
        if (ulp_u == ulp_v) {
            return;
        }

        if (rank.get(ulp_u) < rank.get(ulp_v)) {
            // u attaches to v
            // no rank change
            parent.set(ulp_u, ulp_v);
        } else if (rank.get(ulp_v) < rank.get(ulp_u)) {
            // v attaches to u
            // no rank change
            parent.set(ulp_v, ulp_u);
        } else {
            // v attaches to u
            // rank of u increases by 1
            parent.set(ulp_v, ulp_u);
            rank.set(ulp_u, rank.get(ulp_u) + 1);
        }
    }

    public void unionBySize(int u, int v) {
        int ulp_u = getParent(u);
        int ulp_v = getParent(v);

        // make sure unnecessary path compression and parent checks are not done
        // and size array is not corrupted
        if (ulp_u == ulp_v) {
            return;
        }

        if (size.get(ulp_u) < size.get(ulp_v)) {
            // u attaches to v
            // size of v increases
            parent.set(ulp_u, ulp_v);
            size.set(ulp_v, size.get(ulp_v) + size.get(ulp_u));
        } else if (size.get(ulp_u) > size.get(ulp_v)) {
            // v attaches to u
            // size of u increases
            parent.set(ulp_v, ulp_u);
            size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
        } else {
            // v attaches to u
            // size of u increases
            parent.set(ulp_v, ulp_u);
            size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
        }
    }

    public boolean areNodesConnected(int u, int v) {
        return getParent(u) == getParent(v);
    }
}

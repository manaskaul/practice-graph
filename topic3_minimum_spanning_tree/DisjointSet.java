package topic3_minimum_spanning_tree;

import java.util.*;

/*
 * DisjointSet also UnionFind used to check the connected components of graph
 * (keep track of elements that are split into disjoint (non-overlapping) groups)
 * 
 * Supports 2 main operation : 
 *      Union(x,y) : Merge the groups containing x and y. Ultimate parent for x & y becomes same
 *      Find(x) : Which group does x belong to? Retruns ultimate parent of x
 * 
 * Path compression (Find optimization): Every time you do a Find, flatten the tree structure → makes future finds faster.
 * Union by rank/size: Always attach the smaller tree under the larger one → keeps trees shallow.
 * 
 * Mainly used for connectivity problems:
 *      Check if two nodes are in the same connected component (like "valid path" problem).
 *      Kruskal’s algorithm for Minimum Spanning Tree (MST).
 *      Detecting cycles in an undirected graph.
 * 
 * TC: O(aplha(n)) = O(1) per operation
 * SC: O(N)
 * 
 * Building DSU for N nodes = O(N)
 * Processing E edges (unions) + Q queries (finds) = O((E + Q) α(n)) = O(E + Q) = O(E + V)
 */
public class DisjointSet {
    private List<Integer> parent;
    private List<Integer> rank; // Union by Rank
    private List<Integer> size; // Union by Size

    DisjointSet(int noOfNodes) {
        parent = new ArrayList<>();
        rank = new ArrayList<>();
        size = new ArrayList<>();

        // Every node is its own parent initially
        // rank and size of each node is 0 initially
        for(int i = 0; i <= noOfNodes; i++) {
            parent.add(i);
            rank.add(0);
            size.add(1);
        }
    }

    // recurrsively sets correct parent for every node
    // performs path compression
    // returns ultimate parent of the queried node
    public int getParent(int node) {
        // if parent of a node is itself we found ultimate parent
        if (node == parent.get(node)) {
            return node;
        }
        // set the parent of queried node as the ultimate parent
        // this also performs path compression
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

        int rank_ulp_u = rank.get(ulp_u);
        int rank_ulp_v = rank.get(ulp_v);

        if (rank_ulp_u < rank_ulp_v) {
            // ulp_u attaches to ulp_v
            // no rank change
            parent.set(ulp_u, ulp_v);
        } else if (rank_ulp_v < rank_ulp_u) {
            // ulp_v attaches to ulp_u
            // no rank change
            parent.set(ulp_v, ulp_u);
        } else {
            // ulp_v attaches to ulp_u
            // rank of ulp_u increases by 1
            parent.set(ulp_v, ulp_u);
            rank.set(ulp_u, rank_ulp_u + 1);
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

        int size_ulp_u = size.get(ulp_u);
        int size_ulp_v = size.get(ulp_v);

        if (size_ulp_u < size_ulp_v) {
            // u attaches to v
            // size of ulp_v increases
            parent.set(ulp_u, ulp_v);
            size.set(ulp_v, size_ulp_u + size_ulp_v);
        } else if (size_ulp_u > size_ulp_v) {
            // v attaches to u
            // size of ulp_u increases
            parent.set(ulp_v, ulp_u);
            size.set(ulp_u, size_ulp_u + size_ulp_v);
        } else {
            // v attaches to u
            // size of ulp_u increases
            parent.set(ulp_v, ulp_u);
            size.set(ulp_u, size_ulp_u + size_ulp_v);
        }
    }

    public boolean areNodesConnected(int u, int v) {
        return getParent(u) == getParent(v);
    }
}

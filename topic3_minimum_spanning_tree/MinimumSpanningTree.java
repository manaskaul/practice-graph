package topic3_minimum_spanning_tree;

public class MinimumSpanningTree {
    public static void main(String[] args) {

        DisjointSet ds1 = new DisjointSet(7);
        ds1.unionByRank(1, 2);
        ds1.unionByRank(1, 3);
        ds1.unionByRank(2, 6);
        ds1.unionByRank(3, 6);
        ds1.unionByRank(2, 7);
        ds1.unionByRank(4, 2);
        
        System.out.println("UBR Nodes 1 & 5 are connected ? " + ds1.areNodesConnected(1, 5));
        System.out.println("UBR Nodes 1 & 3 are connected ? " + ds1.areNodesConnected(1, 3));
        
        DisjointSet ds2 = new DisjointSet(7);
        ds2.unionBySize(1, 2);
        ds2.unionBySize(1, 3);
        ds2.unionBySize(2, 6);
        ds2.unionBySize(3, 6);
        ds2.unionBySize(2, 7);
        ds2.unionBySize(4, 2);

        System.out.println("UBS Nodes 1 & 5 are connected ? " + ds2.areNodesConnected(1, 5));
        System.out.println("UBS Nodes 1 & 3 are connected ? " + ds2.areNodesConnected(1, 3));
    }
}

package topic3_minimum_spanning_tree;

import java.util.*;

import topic1_representation.AdjList;
import topic1_representation.Pair;

public class PrimMst {

    // TC : O(E log E) = O(E log E)
    // SC : O(E + V) = O(V+E)
    // Use PriorityQueue (min-heap) to keep track of lest weighted edge
    // Use Visited array to keep track of nodes already added to mst
    public int findMstWeight(List<List<Integer>> edges, int noOfNodes) {

        int mstWeight = 0;

        // Step 1: Build adjacency list
        List<List<Pair>> adjList = new AdjList(noOfNodes).constructGraph(edges, false, true);

        // Step 2: Min-Heap based on edge weights
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return Integer.compare(o1.getWeight(), o2.getWeight());
            }
        });

        // Step 3: Track visited nodes
        List<Boolean> visited = new ArrayList<>(Collections.nCopies(noOfNodes, false));

        // Step 4: Start with node 0, mark as visited
        for (Pair p : adjList.get(0)) {
            int f = 0;
            int t = p.getNode();
            int w = p.getWeight();
            pq.offer(new Node(new int[]{f,t}, w));
        }
        visited.set(0, true);

        // Pick the top element from pq
        // Skip if the node is already in MST
        // If not, add node to MST
        // Add all adjacent nodes of 'target' into PQ if not visited
        while (!pq.isEmpty()) {
            Node node = pq.poll();

            int from = node.getNodes()[0];
            int to = node.getNodes()[1];
            int weight = node.getWeight();
            
            // if target node alreadyy in mst, skip processing
            if (visited.get(to)) {
                continue;
            }

            visited.set(to, true);
            mstWeight += weight;
            
            for(Pair p : adjList.get(to)) {
                int f = to;
                int t = p.getNode();
                int w = p.getWeight();

                pq.offer(new Node(new int[]{f,t}, w));
            }
        }

        return mstWeight;
    }
}

class Node {
    private int[] nodes; // [0] => from [1] => to
    private int weight;

    Node(int[] nodes, int weight) {
        this.nodes = nodes;
        this.weight = weight;
    }
    
    public int[] getNodes() {
        return this.nodes;
    }
    public void setNodes(int[] nodes) {
        this.nodes = nodes;
    }
    public int getWeight() {
        return this.weight;
    }
    public void setWeight(int weight) {
        this.weight = weight;
    }

}
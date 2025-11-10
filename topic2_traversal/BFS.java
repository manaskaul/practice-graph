package topic2_traversal;

import java.util.*;

import topic0_structure.Edge;
import topic0_structure.Node;

/*
 * Explore nodes and edges of graph
 * TC : O(V+E)
 * Particularly useful for finding shortest path on unweighted graphs
 * Use a queue to track which node to visit next
 * 
 * Applications -
 * 1. Determine the level of each node in the given Tree/Graph
 * 2. 0-1 BFS : Find shortest path in 0-1 weighted graph
 * 3. Finding shortest path from source to dest.
 *      NOTE:   Because in unweighted graphs, BFS guarantees that the first time you reach a node, 
 *              you’ve reached it via the shortest possible path (minimum number of moves). 
 *              So you will never find a shorter path later.
 *              Dijkstra's Algo needed for weighted edges and different costs.
 */
public class BFS {
    public void traverse(Node node) {
        Queue<Node> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        List<Integer> bfsList = new ArrayList<>();
        
        queue.add(node);
        visited.add(node.getValue());
        while (queue.size() > 0) {
            Node n = queue.poll();
            
            bfsList.add(n.getValue());
            
            n.getNeighbors().forEach(neighbor -> {
                if (!visited.contains(neighbor.getTarget().getValue())) {
                    queue.add(neighbor.getTarget());
                    visited.add(neighbor.getTarget().getValue());
                }
            });
        }
        System.out.println("BFS TRAVERSAL: " + Arrays.toString(bfsList.toArray()));
    }

    public void traverseWithAdjList(List<List<Integer>> adjList, int startNode) {
        Queue<Integer> q = new LinkedList<>();
        List<Boolean> visited = new ArrayList<>(Collections.nCopies(adjList.size(), false));

        List<Integer> res = new ArrayList<>();

        q.offer(startNode);
        visited.set(startNode, true);
        res.add(startNode);
        while (!q.isEmpty()) {
            int srcNode = q.poll();
            List<Integer> neighbors = adjList.get(srcNode);
            for (Integer destNode : neighbors) {
                if (!visited.get(destNode)) {
                    q.offer(destNode);
                    visited.set(destNode, true);
                    res.add(destNode);
                }
            }
        }

        System.out.println("BFS TRAVERSAL: " + Arrays.toString(res.toArray()));
    }
    
    public void findShortestPath(Node start, Node end) {
        Queue<Node> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        Map<Node, Node> parentMap = new HashMap<>();

        queue.offer(start);
        visited.add(start.getValue());
        parentMap.putIfAbsent(start, null);
        while(queue.size() > 0) {
            Node n = queue.poll();
            n.getNeighbors().stream().forEach(neighbor -> {
                if (!visited.contains(neighbor.getTarget().getValue())) {
                    queue.add(neighbor.getTarget());
                    visited.add(neighbor.getTarget().getValue());
                    parentMap.putIfAbsent(neighbor.getTarget(), n);
                }
            });
        }

        if (!parentMap.containsKey(end)) {
            System.out.println("Cannot find shortest path.");
            return;
        }

        List<Integer> history = new ArrayList<>();
        history.add(end.getValue());

        Node prev = parentMap.get(end);
        while (prev != null) {
            history.add(prev.getValue());
            prev = parentMap.get(prev);
        }
        Collections.reverse(history);
        System.out.println("SHORTEST PATH: " + Arrays.toString(history.toArray()));
    }

    public void findLevelOfEachNode(Node start) {
        Queue<Node> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        Map<Integer, Integer> nodeLevel = new HashMap<>();

        queue.offer(start);
        visited.add(start.getValue());
        nodeLevel.putIfAbsent(start.getValue(), 0);
        while (queue.size() > 0) {
            Node n = queue.poll();
            n.getNeighbors().stream().forEach(neighbor -> {
                if (!visited.contains(neighbor.getTarget().getValue())) {
                    queue.offer(neighbor.getTarget());
                    visited.add(neighbor.getTarget().getValue());
                    nodeLevel.putIfAbsent(
                        neighbor.getTarget().getValue(), 
                        nodeLevel.getOrDefault(n.getValue(), -1) + 1
                    );
                }
            });
        }

        System.out.println("NODE LEVELS: " + Arrays.toString(nodeLevel.entrySet().toArray()));
    }

    public void findShortestPathInZeroOneGraph(Node start, Node end, int noOfNodes) {
        Deque<Node> dq = new LinkedList<>();
        List<Integer> nodeLevel = new ArrayList<>(Collections.nCopies(noOfNodes, Integer.MAX_VALUE));
        Map<Node, Node> parentMap = new HashMap<>();

        dq.offerFirst(start);
        nodeLevel.set(start.getValue(), 0);
        parentMap.put(start, null);
        
        while (dq.size() > 0) {
            
            Node srcNode = dq.pollFirst();
            int srcNodeLevel = nodeLevel.get(srcNode.getValue());

            srcNode.getNeighbors()
                .stream()
                .forEach((Edge neighbor) -> {
                    Node targetNode = neighbor.getTarget();
                    int targetNodeVal = targetNode.getValue();
                    int targetNodeWeight = neighbor.getWeight();

                    int targetNodeLevel = nodeLevel.get(targetNodeVal);

                    if (srcNodeLevel + targetNodeWeight < targetNodeLevel) {
                        nodeLevel.set(targetNodeVal, srcNodeLevel + targetNodeWeight);
                        if (targetNodeWeight == 0) {
                            dq.offerFirst(targetNode);
                        } else {
                            dq.offerLast(targetNode);
                        }
                        parentMap.put(targetNode, srcNode);
                    }


                });
        }

        if (!parentMap.containsKey(end)) {
            System.out.println("Shortest path not found.");
            return;
        }

        List<Integer> history = new ArrayList<>();
        history.add(end.getValue());
        
        Node prev = parentMap.get(end);
        while (prev != null) {
            history.add(prev.getValue());
            prev = parentMap.get(prev);
        }
        Collections.reverse(history);
        System.out.println("SHORTEST 0-1 BFS PATH: " + Arrays.toString(history.toArray()));
    }

}

package topic2_traversal;

import java.util.*;

import topic0_structure.Node;

/*
 * Explore nodes and edges of graph
 * TC : O(V+E)
 * Particularly useful when agumented in other alogs - count connected components, determine connectivity or find bridges/articulation points
 * Use a stack to track which node to visit next
 */
public class DFS {
    public void traverse(Node node) {
        Stack<Node> stack = new Stack<>();
        Set<Integer> visited = new HashSet<>();
        
        List<Integer> dfsList = new ArrayList<>();

        stack.push(node);
        visited.add(node.getValue());
        while(stack.size() > 0) {
            Node n = stack.pop();
            dfsList.add(n.getValue());
            n.getNeighbors().forEach(neighbor -> {
                if (!visited.contains(neighbor.getTarget().getValue())) {
                    stack.add(neighbor.getTarget());
                    visited.add(neighbor.getTarget().getValue());
                }
            });
        }
        System.out.printf("DFS TRAVERSAL: " + Arrays.toString(dfsList.toArray()));
    }
    
    public void as () {
        Scanner sc = new Scanner(System.in);
        int nodes = sc.nextInt();
        int edges = sc.nextInt();

        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i <= nodes; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 1; i <= edges; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        int head = sc.nextInt();

        sc.close();

        int ans = nodes - findUnreachableNodes(adjList, nodes, head);
        System.out.println(ans);

    }

    public int findUnreachableNodes(List<List<Integer>> adjList, int totalNodes, int head) {
        Stack<Integer> st = new Stack<>();
        List<Boolean> visited = new ArrayList<>(Collections.nCopies(totalNodes + 1, false));

        int connectedNodes = 0;

        st.push(head);
        visited.set(head, true);
        connectedNodes++;
        while (!st.isEmpty()) {
            int srcNode = st.pop();
            List<Integer> neighbors = adjList.get(srcNode);
            for (Integer destNode : neighbors) {
                if (!visited.get(destNode)) {
                    st.push(destNode);
                    visited.set(destNode, true);
                    connectedNodes++;
                }
            }
        }

        return totalNodes - connectedNodes;
    }
}
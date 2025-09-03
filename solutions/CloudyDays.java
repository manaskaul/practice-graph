package solutions;

import java.util.*;

class CloudyDays {
    public static void main(String args[] ) throws Exception {
        List<List<Integer>> adjList = new ArrayList<>();

        Scanner s = new Scanner(System.in);
        
        int V = s.nextInt();
        int E = s.nextInt();
        int fuel = s.nextInt();
        int curr = s.nextInt();

        for (int i=0; i<V; i++) {
            List<Integer> row = new ArrayList<>();
            adjList.add(row);
        }

        for(int i=0; i<E; i++) {
            int from = s.nextInt();
            int to = s.nextInt();
            adjList.get(from).add(to);
            adjList.get(to).add(from);
        }

        s.close();

        // for(int i = 0; i < adjList.size(); i++) {
        //     System.out.printf("%d : ", i);
        //     List<Integer> lst = adjList.get(i);
        //     for(int elem : lst) {
        //         System.out.printf("%d ", elem);
        //     }
        //     System.out.printf("\n");
        // }

        int ans = visitedCities(adjList, V, fuel, curr);
        System.out.printf("%d", ans);   
    }


    private static int visitedCities(List<List<Integer>> adjList, int V, int fuel, int start) {
        int ans = 0;
        
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[V+1];
        for (int i=0; i<=V; i++) {
            visited[i] = false;
        }

        q.offer(start);
        visited[start] = true;
        ans++;

        while(!q.isEmpty() && fuel > 0) {
            int currNode = q.poll();
            List<Integer> neighbors = adjList.get(currNode);

            // if(neighbors.size() > 0 && fuel > 0) {
            //     fuel--;
            //     System.out.printf("currNode = %d remaining fuel = %d\n", currNode, fuel);
            // }

            for(int neighbor : neighbors) {
                if(!visited[neighbor]) {
                    q.offer(neighbor);
                    visited[neighbor] = true;
                    ++ans;
                }
            }
            --fuel;
        }
        
        return ans;
    }
}

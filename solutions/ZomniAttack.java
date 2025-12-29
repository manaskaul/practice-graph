package solutions;

import java.util.*;

/**
 * TC: O(N * M)
 * SC: O(N * M)
 */
public class ZomniAttack {
    public static void main(String args[]) throws Exception {
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        while (T > 0) {
            int N = s.nextInt();
            int M = s.nextInt();

            int[][] adjMat = new int[N][M];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    adjMat[i][j] = s.nextInt();
                }
            }

            killZomni(adjMat, N, M);

            T--;
        }
        s.close();
    }

    private static void killZomni(int[][] adjMat, int N, int M) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited[i][j] = false;
            }
        }

        int totalTroops = 0;
        int maxZomnis = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int currZomnis = 0;

                if (!visited[i][j] && adjMat[i][j] == 1) {
                    q.offer(new int[] { i, j });
                    visited[i][j] = true;
                    totalTroops++;
                }

                while (!q.isEmpty()) {
                    int[] curr = q.poll();
                    int x = curr[0];
                    int y = curr[1];

                    currZomnis++;

                    // check all 8 directions
                    // and add back in q
                    if (x > 0 && !visited[x - 1][y] && adjMat[x - 1][y] == 1) {
                        q.offer(new int[] { x - 1, y });
                        visited[x - 1][y] = true;
                    }
                    if (y > 0 && !visited[x][y - 1] && adjMat[x][y - 1] == 1) {
                        q.offer(new int[] { x, y - 1 });
                        visited[x][y - 1] = true;
                    }
                    if (x < N - 1 && !visited[x + 1][y] && adjMat[x + 1][y] == 1) {
                        q.offer(new int[] { x + 1, y });
                        visited[x + 1][y] = true;
                    }
                    if (y < M - 1 && !visited[x][y + 1] && adjMat[x][y + 1] == 1) {
                        q.offer(new int[] { x, y + 1 });
                        visited[x][y + 1] = true;
                    }
                    if (x > 0 && y > 0 && !visited[x - 1][y - 1] && adjMat[x - 1][y - 1] == 1) {
                        q.offer(new int[] { x - 1, y - 1 });
                        visited[x - 1][y - 1] = true;
                    }
                    if (x > 0 && y < M - 1 && !visited[x - 1][y + 1] && adjMat[x - 1][y + 1] == 1) {
                        q.offer(new int[] { x - 1, y + 1 });
                        visited[x - 1][y + 1] = true;
                    }
                    if (x < N - 1 && y > 0 && !visited[x + 1][y - 1] && adjMat[x + 1][y - 1] == 1) {
                        q.offer(new int[] { x + 1, y - 1 });
                        visited[x + 1][y - 1] = true;
                    }
                    if (x < N - 1 && y < M - 1 && !visited[x + 1][y + 1] && adjMat[x + 1][y + 1] == 1) {
                        q.offer(new int[] { x + 1, y + 1 });
                        visited[x + 1][y + 1] = true;
                    }
                }

                maxZomnis = Math.max(maxZomnis, currZomnis);
            }
        }

        System.out.printf("%d %d\n", totalTroops, maxZomnis);
    }
}

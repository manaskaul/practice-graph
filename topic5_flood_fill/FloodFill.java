package topic5_flood_fill;

/**
 * given matrix with 
 * 0's (valid path to walk)
 * 1's (invalid path to walk)
 * check if there is a path from [src_i, src_j] to [dest_i, dest_j]
 * traversal can only be in 4 directions : up, down, left, right
 * TC: O(V+E)
 * SC: O(V)
 */
public class FloodFill {
    public static void main(String[] args) {
        int M = 4;
        int N = 4;

        int[][] adjMat = new int[][]{
            {1,0,0,0},
            {0,0,1,0},
            {1,1,1,0},
            {0,0,1,0}
        };

        int src_i = 1;
        int src_j = 0;

        int dest_i = 3;
        int dest_j = 3;

        floodFill(adjMat, M, N, src_i, src_j);

        // can reach [src_i, src_j] to [dest_i, dest_j]
        if(adjMat[dest_i][dest_j] == 2) {
            System.out.println("CAN FILL");
        } else {
            System.out.println("CAN NOT FILL");
        }

        for(int i=0; i<M; i++) {
            for(int j=0; j<N; j++) {
                System.out.printf("%d ", adjMat[i][j]);
            }
            System.out.printf("\n");
        }
    }

    // can be done using iterative BFS or recursive DFS
    // done with DFS here
    // filling the whole adjMat here
    // setting [i,j] = 2 if position is part of the flood fill
    private static void floodFill(int[][] adjMat, int M, int N, int i, int j) {
        if(i < 0 || i >= M || j < 0 || j >= N) {
            return;
        }

        adjMat[i][j] = 2;
        
        // top
        if(i > 0 && adjMat[i-1][j] == 0) {
            floodFill(adjMat, M, N, i-1, j);
        }

        // bottom
        if(i < M-1 && adjMat[i+1][j] == 0) {
            floodFill(adjMat, M, N, i+1, j);
        }

        // left
        if(j > 0 && adjMat[i][j-1] == 0) {
            floodFill(adjMat, M, N, i, j-1);
        }

        // right
        if(j < N-1 && adjMat[i][j+1] == 0) {
            floodFill(adjMat, M, N, i, j+1);
        }
    }
}

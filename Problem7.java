/*


7. Write a java program that accepts vertex pairs
associated to the edges of an undirected graph and
the number of times each edge appears. The program
should construct an incidence matrix for the graph.
*/

import java.util.Scanner;

public class Problem7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of vertices: ");
        int n = scanner.nextInt();
        System.out.print("Enter the number of edges: ");
        int m = scanner.nextInt();

        int[][] incMat = new int[n][m];

        System.out.println("Enter edges as pairs of vertices followed by the number of times each edge appears (e.g., '0 1 2'):");
        for (int i = 0; i < m; i++) {
            int u = scanner.nextInt(), v = scanner.nextInt(), count = scanner.nextInt();
            for (int j = 0; j < count; j++) {
                incMat[u][i + j] = incMat[v][i + j] = 1;
            }
            i += count - 1;
        }
        scanner.close();

        System.out.println("\nIncidence matrix:");
        for (int[] row : incMat) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}

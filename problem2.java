/*


2. Write a java program that accepts an adjacency matrix of a graph.
The program should list the edges of this graph and give the number
of times each edge appears.
*/


import java.util.Scanner;

public class problem2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of vertices: ");
        int n = scanner.nextInt();
        int[][] adjMatrix = new int[n][n];

        System.out.println("Enter the adjacency matrix of the graph: ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                adjMatrix[i][j] = scanner.nextInt();
            }
        }

        int[][] edges = new int[n * (n - 1) / 2][2];
        int[] counts = new int[n * (n - 1) / 2];
        int idx = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (adjMatrix[i][j] != 0) {
                    edges[idx][0] = i;
                    edges[idx][1] = j;
                    counts[idx] = adjMatrix[i][j];
                    idx++;
                }
            }
        }

        System.out.println("Edges of the graph:");
        for (int i = 0; i < idx; i++) {
            System.out.println("{" + edges[i][0] + ", " + edges[i][1] + "} or {" + edges[i][1] + ", " +
                               edges[i][0] + "} : " + counts[i] + " time(s)");
        }

        scanner.close();
    }
}

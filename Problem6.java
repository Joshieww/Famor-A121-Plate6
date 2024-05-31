    /*


6. Write a java program that receives the vertex pairs
associated to the edges of a graph, the program should
construct an adjacency matrix for the graph.
(Produce a version that works when loops, multiple edges,
or directed edges are present.)
*/
    
    import java.util.Scanner;

    public class Problem6 {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter the number of vertices: ");
            int n = scanner.nextInt();
            int[][] adjMatrix = new int[n][n];

            System.out.print("Is the graph directed? (y/n): ");
            boolean isDirected = scanner.next().equalsIgnoreCase("y");

            System.out.println("Enter edges as pairs of vertices (e.g., '0 1'). Enter '-1 -1' to stop:");
            while (true) {
                int u = scanner.nextInt(), v = scanner.nextInt();
                if (u == -1 && v == -1) break;
                if (u >= 0 && u < n && v >= 0 && v < n) {
                    adjMatrix[u][v]++;
                    if (!isDirected && u != v) adjMatrix[v][u]++;
                } else {
                    System.out.println("Invalid vertex number. Must be between 0 and " + (n - 1) + ".");
                }
            }
            scanner.close();

            System.out.println("\nAdjacency Matrix:");
            for (int[] row : adjMatrix) {
                for (int val : row) {
                    System.out.print(val + " ");
                }
                System.out.println();
            }
        }
    }

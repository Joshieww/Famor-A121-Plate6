/* * Write a java program that receives a list of edges of a simple graph,
the program should determine whether it is connected and find the number
of connected components if it is not connected.
*/


import java.util.ArrayList;
import java.util.Scanner;

public class Problem1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of vertices in the graph: ");
        int n = scanner.nextInt();

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        System.out.println("Enter the edges of the graph as pairs of vertices, e.g. '0 1'. (Enter '-1 -1' to stop): ");
        int u = scanner.nextInt(), v = scanner.nextInt();
        while (u != -1 && v != -1) {
            if (u >= 0 && u < n && v >= 0 && v < n) {
                adj.get(u).add(v);
                adj.get(v).add(u);
            } else {
                System.out.println("Invalid vertex number. Vertex numbers must be between 0 and " + (n - 1) + ".");
            }
            u = scanner.nextInt();
            v = scanner.nextInt();
        }
        scanner.close();

        int[] result = isConnected(n, adj);
        int count = result[0], isolatedVertices = result[1];
        if (count == 1) {
            System.out.println("The graph is connected.");
        } else {
            System.out.println("The graph has " + count + " connected components and " + isolatedVertices + " isolated vertices.");
        }
    }

    private static void dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {
        visited[node] = true;
        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) dfs(neighbor, adj, visited);
        }
    }

    private static int[] isConnected(int n, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[n];
        int count = 0, isolatedVertices = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, adj, visited);
                count++;
            }
            if (adj.get(i).isEmpty()) isolatedVertices++;
        }
        return new int[]{count, isolatedVertices};
    }
}

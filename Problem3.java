/*


3. Write a java program that will determine if a graph has a cycle or not.
*/

import java.util.*;

public class Problem3 {

    private static final List<List<Integer>> adj = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of vertices: ");
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        System.out.println("Enter edges as pairs of vertices (e.g., '0 1'). Enter '-1 -1' to stop:");
        int u, v;
        while (true) {
            u = scanner.nextInt(); v = scanner.nextInt();
            if (u == -1 || v == -1) break;
            if (u >= 0 && u < n && v >= 0 && v < n) {
                adj.get(u).add(v);
                adj.get(v).add(u);
            } else {
                System.out.println("Invalid vertex number. Must be between 0 and " + (n - 1) + ".");
            }
        }
        scanner.close();

        System.out.println(hasCycle(n) ? "The graph contains a cycle." : "The graph does not contain a cycle.");
    }

    private static boolean hasCycle(int V) {
        boolean[] visited = new boolean[V];
        for (int v = 0; v < V; v++) {
            if (!visited[v] && dfs(v, -1, visited)) return true;
        }
        return false;
    }

    private static boolean dfs(int v, int parent, boolean[] visited) {
        visited[v] = true;
        for (int w : adj.get(v)) {
            if (!visited[w]) {
                if (dfs(w, v, visited)) return true;
            } else if (w != parent) {
                return true;
            }
        }
        return false;
    }
}

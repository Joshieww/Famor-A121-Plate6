/*


5. Write a java program that receives
a list of edges of a simple graph and
determine whether the graph is bipartite.
*/

import java.util.*;

public class Problem5 {
    private static final List<List<Integer>> adj = new ArrayList<>();
    private static int[] color;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of vertices: ");
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        System.out.println("Enter edges as pairs of vertices (e.g., '0 1'). Enter '-1 -1' to stop:");
        while (true) {
            int u = scanner.nextInt(), v = scanner.nextInt();
            if (u == -1 && v == -1) break;
            if (u >= 0 && u < n && v >= 0 && v < n) {
                adj.get(u).add(v);
                adj.get(v).add(u);
            } else {
                System.out.println("Invalid vertex number. Must be between 0 and " + (n - 1) + ".");
            }
        }
        scanner.close();

        color = new int[n];
        Arrays.fill(color, -1);

        System.out.println(isBipartite(n) ? "The graph is bipartite." : "The graph is not bipartite.");
    }

    private static boolean dfs(int u, int c) {
        color[u] = c;
        for (int v : adj.get(u)) {
            if (color[v] == -1) {
                if (!dfs(v, 1 - c)) return false;
            } else if (color[v] == c) {
                return false;
            }
        }
        return true;
    }

    private static boolean isBipartite(int n) {
        for (int i = 0; i < n; i++) {
            if (color[i] == -1 && !dfs(i, 0)) {
                return false;
            }
        }
        return true;
    }
}

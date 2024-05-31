/*


4. Write a java program, given the pair of vertex
associated to the edges of an undirected graph,
it will output the degree of vertex.
*/

import java.util.ArrayList;
import java.util.Scanner;

public class Problem4 {

    private static final ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    private static final ArrayList<String> strAdj = new ArrayList<>();

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
                strAdj.add("{" + u + ", " + v + "}");
            } else {
                System.out.println("Invalid vertex number. Must be between 0 and " + (n - 1) + ".");
            }
        }
        scanner.close();

        int total = 0;
        for (int i = 0; i < n; i++) {
            int size = adj.get(i).size();
            total += size;
            System.out.println("deg(" + i + "): " + size);
        }
        System.out.println("\nTotal Degree of Graph: " + total);
    }
}

package dsa;

public class ShortestPath {

    private int[][] graph;
    private int vertices;

    public ShortestPath(int[][] graph) {
        this.graph = graph;
        this.vertices = graph.length;
    }

    public void findPath(int source, int destination) {

        boolean[] visited = new boolean[vertices];

        int[] parent = new int[vertices];

        int[] queue = new int[vertices];

        for (int i = 0; i < vertices; i++) {
            parent[i] = -1;
        }

        int front = 0;
        int rear = 0;

        queue[rear++] = source;
        visited[source] = true;

        while (front < rear) {

            int current = queue[front++];

            if (current == destination) {
                break;
            }

            for (int i = 0; i < vertices; i++) {

                if (graph[current][i] == 1 &&
                        !visited[i]) {

                    visited[i] = true;
                    parent[i] = current;
                    queue[rear++] = i;
                }
            }
        }

        if (!visited[destination]) {

            System.out.println("No route found.");
            return;
        }

        int[] path = new int[vertices];
        int pathLength = 0;

        int current = destination;

        while (current != -1) {

            path[pathLength++] = current;
            current = parent[current];
        }

        System.out.println();
        System.out.println("========== SHORTEST EMERGENCY ROUTE ==========");

        System.out.print("Route: ");

        for (int i = pathLength - 1; i >= 0; i--) {

            System.out.print("Area " + (path[i] + 1));

            if (i != 0) {
                System.out.print(" -> ");
            }
        }

        System.out.println();
        System.out.println("Number of roads: " + (pathLength - 1));
    }
}
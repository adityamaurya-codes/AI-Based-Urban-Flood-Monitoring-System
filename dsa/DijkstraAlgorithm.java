package dsa;

public class DijkstraAlgorithm {

    private int[][] graph;
    private int vertices;

    public DijkstraAlgorithm(int[][] graph) {
        this.graph = graph;
        this.vertices = graph.length;
    }

    public void findShortestPath(int source, int destination) {

        int[] distance = new int[vertices];
        boolean[] visited = new boolean[vertices];
        int[] parent = new int[vertices];

        // Initialize distances
        for (int i = 0; i < vertices; i++) {

            distance[i] = Integer.MAX_VALUE;
            parent[i] = -1;
        }

        distance[source] = 0;

        // Dijkstra algorithm
        for (int count = 0; count < vertices - 1; count++) {

            int current = findMinimumDistance(distance, visited);

            if (current == -1) {
                break;
            }

            visited[current] = true;

            for (int i = 0; i < vertices; i++) {

                if (graph[current][i] != 0 &&
                        !visited[i] &&
                        distance[current] != Integer.MAX_VALUE) {

                    int newDistance =
                            distance[current] + graph[current][i];

                    if (newDistance < distance[i]) {

                        distance[i] = newDistance;
                        parent[i] = current;
                    }
                }
            }
        }

        if (distance[destination] == Integer.MAX_VALUE) {

            System.out.println("No route found.");
            return;
        }

        // Display result
        System.out.println();
        System.out.println("========== DIJKSTRA EMERGENCY ROUTE ==========");

        System.out.print("Route: ");

        printPath(parent, destination);

        System.out.println();
        System.out.println(
                "Minimum Distance: " + distance[destination] + " km"
        );
    }

    // Find unvisited vertex with minimum distance
    private int findMinimumDistance(
            int[] distance,
            boolean[] visited) {

        int minimum = Integer.MAX_VALUE;
        int minimumVertex = -1;

        for (int i = 0; i < vertices; i++) {

            if (!visited[i] && distance[i] < minimum) {

                minimum = distance[i];
                minimumVertex = i;
            }
        }

        return minimumVertex;
    }

    // Print route using parent array
    private void printPath(int[] parent, int destination) {

        if (destination == -1) {
            return;
        }

        if (parent[destination] != -1) {

            printPath(parent, parent[destination]);

            System.out.print(" -> ");
        }

        System.out.print("Area " + (destination + 1));
    }
}
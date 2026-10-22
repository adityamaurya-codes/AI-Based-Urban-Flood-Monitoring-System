package dsa;

public class FloodBFS {

    private int[][] graph;
    private int vertices;

    public FloodBFS(int[][] graph) {
        this.graph = graph;
        this.vertices = graph.length;
    }

    public void traverse(int startVertex) {

        boolean[] visited = new boolean[vertices];

        int[] queue = new int[vertices];

        int front = 0;
        int rear = 0;

        queue[rear++] = startVertex;
        visited[startVertex] = true;

        System.out.println();
        System.out.println("========== BFS FLOOD AREA TRAVERSAL ==========");

        while (front < rear) {

            int current = queue[front++];

            System.out.println(
                    "Visiting Area: " + (current + 1)
            );

            for (int i = 0; i < vertices; i++) {

                if (graph[current][i] == 1 &&
                        !visited[i]) {

                    queue[rear++] = i;
                    visited[i] = true;
                }
            }
        }
    }
}
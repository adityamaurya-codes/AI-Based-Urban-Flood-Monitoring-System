package dsa;

public class FloodDFS {

    private int[][] graph;
    private int vertices;
    private boolean[] visited;

    public FloodDFS(int[][] graph) {
        this.graph = graph;
        this.vertices = graph.length;
        this.visited = new boolean[vertices];
    }

    public void traverse(int startVertex) {

        System.out.println();
        System.out.println("========== DFS FLOOD AREA TRAVERSAL ==========");

        dfs(startVertex);
    }

    private void dfs(int currentVertex) {

        visited[currentVertex] = true;

        System.out.println(
                "Visiting Area: " + (currentVertex + 1)
        );

        for (int i = 0; i < vertices; i++) {

            if (graph[currentVertex][i] == 1 &&
                    !visited[i]) {

                dfs(i);
            }
        }
    }
}
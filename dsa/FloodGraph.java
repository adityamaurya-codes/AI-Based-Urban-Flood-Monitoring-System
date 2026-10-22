
package dsa;

public class FloodGraph {

    private int vertices;
    private int[][] adjacencyMatrix;

    public FloodGraph(int vertices) {

        this.vertices = vertices;
        adjacencyMatrix = new int[vertices][vertices];
    }

    // Add an undirected road between two areas
    public void addRoad(int source, int destination) {

        adjacencyMatrix[source][destination] = 1;
        adjacencyMatrix[destination][source] = 1;
    }

    // Display the graph
    public void displayGraph() {

        System.out.println();
        System.out.println("========== FLOOD AREA GRAPH ==========");

        for (int i = 0; i < vertices; i++) {

            System.out.print("Area " + (i + 1) + ": ");

            for (int j = 0; j < vertices; j++) {

                if (adjacencyMatrix[i][j] == 1) {
                    System.out.print("Area " + (j + 1) + " ");
                }
            }

            System.out.println();
        }
    }
        public int[][] getGraph() {
        return adjacencyMatrix;
    }
}

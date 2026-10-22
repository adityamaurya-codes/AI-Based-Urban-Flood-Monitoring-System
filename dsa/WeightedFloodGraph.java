package dsa;

public class WeightedFloodGraph {

    private int vertices;
    private int[][] weights;

    public WeightedFloodGraph(int vertices) {

        this.vertices = vertices;
        weights = new int[vertices][vertices];
    }

    // Add a road with distance/cost
    public void addRoad(int source, int destination, int distance) {

        weights[source][destination] = distance;
        weights[destination][source] = distance;
    }

    // Display weighted graph
    public void displayGraph() {

        System.out.println();
        System.out.println("========== WEIGHTED FLOOD ROAD GRAPH ==========");

        for (int i = 0; i < vertices; i++) {

            System.out.print("Area " + (i + 1) + ": ");

            for (int j = 0; j < vertices; j++) {

                if (weights[i][j] != 0) {

                    System.out.print(
                            "Area " + (j + 1)
                            + "(" + weights[i][j] + " km) "
                    );
                }
            }

            System.out.println();
        }
    }

    public int[][] getWeights() {
        return weights;
    }
}
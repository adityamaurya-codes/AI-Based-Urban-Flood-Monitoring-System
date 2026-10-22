import model.FloodArea;
import service.FloodRiskAnalyzer;
import service.FloodAIModel;
import service.FloodPredictionService;

import dsa.FloodAreaSearch;
import dsa.FloodAreaSorter;
import dsa.FloodPriorityQueue;
import dsa.FloodAlertQueue;
import dsa.FloodGraph;
import dsa.FloodBFS;
import dsa.FloodDFS;
import dsa.ShortestPath;
import dsa.WeightedFloodGraph;
import dsa.DijkstraAlgorithm;
import service.FloodResponseService;
import java.util.Scanner;

public class Main {

        public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);

                System.out.println("======================================");
                System.out.println("           FLOODGUARD AI");
                System.out.println("======================================");
                System.out.println("AI-Based Urban Flood Monitoring");
                System.out.println("and Response System");
                System.out.println();

                // ======================================
                // 1. CREATE FLOOD AREAS
                // ======================================

                FloodArea[] areas = new FloodArea[5];

                areas[0] = new FloodArea(
                                1, "Sector 1", 35, 20, "Good");

                areas[1] = new FloodArea(
                                2, "Sector 2", 75, 80, "Average");

                areas[2] = new FloodArea(
                                3, "Sector 3", 120, 160, "Poor");

                areas[3] = new FloodArea(
                                4, "Sector 4", 55, 70, "Average");

                areas[4] = new FloodArea(
                                5, "Sector 5", 25, 30, "Good");

                // ======================================
                // 2. RISK ANALYSIS
                // ======================================

                for (int i = 0; i < areas.length; i++) {

                        FloodRiskAnalyzer.analyzeRisk(areas[i]);

                        areas[i].displayAreaDetails();
                }

                // ======================================
                // 3. SEARCH FLOOD AREA BY ID
                // ======================================

                System.out.println();
                System.out.println("========== SEARCH FLOOD AREA ==========");

                System.out.print("Enter Area ID to search: ");
                int searchId = sc.nextInt();

                FloodArea idResult = FloodAreaSearch.searchById(areas, searchId);

                if (idResult != null) {

                        System.out.println("Area Found!");
                        idResult.displayAreaDetails();

                } else {

                        System.out.println("Area not found.");
                }

                // ======================================
                // 4. SORT AREAS BY RISK
                // ======================================

                System.out.println();
                System.out.println("========== AREAS BY RISK ==========");

                // Make a copy so original areas array is not changed
                FloodArea[] sortedAreas = areas.clone();

                FloodAreaSorter.sortByRiskDescending(sortedAreas);

                for (int i = 0; i < sortedAreas.length; i++) {

                        sortedAreas[i].displayAreaDetails();
                }

                // ======================================
                // 5. EMERGENCY PRIORITY QUEUE
                // ======================================

                System.out.println();
                System.out.println("========== EMERGENCY PRIORITY QUEUE ==========");

                FloodPriorityQueue priorityQueue = new FloodPriorityQueue(areas.length);

                for (int i = 0; i < areas.length; i++) {

                        priorityQueue.insert(areas[i]);
                }

                while (!priorityQueue.isEmpty()) {

                        FloodArea highestRisk = priorityQueue.extractHighestRisk();

                        System.out.println(
                                        "Next Emergency Area: "
                                                        + highestRisk.getAreaName()
                                                        + " | Risk Score: "
                                                        + highestRisk.getRiskScore()
                                                        + " | Risk Level: "
                                                        + highestRisk.getRiskLevel());
                }

                // ======================================
                // 6. FLOOD ALERT QUEUE
                // ======================================

                System.out.println();
                System.out.println("========== FLOOD ALERT QUEUE ==========");

                FloodAlertQueue alertQueue = new FloodAlertQueue(areas.length);

                for (int i = 0; i < areas.length; i++) {

                        if (areas[i].getRiskScore() >= 40) {

                                alertQueue.enqueue(areas[i]);
                        }
                }

                while (!alertQueue.isEmpty()) {

                        FloodArea alertArea = alertQueue.dequeue();

                        System.out.println(
                                        "Processing Alert: "
                                                        + alertArea.getAreaName()
                                                        + " | Risk Level: "
                                                        + alertArea.getRiskLevel());
                }

                // ======================================
                // 7. FLOOD AREA GRAPH
                // ======================================

                System.out.println();

                FloodGraph graph = new FloodGraph(5);

                graph.addRoad(0, 1); // Sector 1 - Sector 2
                graph.addRoad(1, 2); // Sector 2 - Sector 3
                graph.addRoad(2, 3); // Sector 3 - Sector 4
                graph.addRoad(2, 4); // Sector 3 - Sector 5
                graph.addRoad(0, 3); // Sector 1 - Sector 4

                graph.displayGraph();

                // ======================================
                // 8. WEIGHTED FLOOD ROAD GRAPH
                // ======================================

                System.out.println();

                WeightedFloodGraph weightedGraph = new WeightedFloodGraph(5);

                weightedGraph.addRoad(0, 1, 2);
                weightedGraph.addRoad(0, 3, 4);
                weightedGraph.addRoad(1, 2, 3);
                weightedGraph.addRoad(3, 2, 1);
                weightedGraph.addRoad(2, 4, 2);

                weightedGraph.displayGraph();

                // ======================================
                // 9. DIJKSTRA SHORTEST EMERGENCY ROUTE
                // ======================================

                System.out.println();

                DijkstraAlgorithm dijkstra = new DijkstraAlgorithm(
                                weightedGraph.getWeights());

                dijkstra.findShortestPath(0, 2);

                // ======================================
                // 10. AI FLOOD PREDICTION
                // ======================================

                System.out.println();

                FloodArea predictionArea = FloodAreaSearch.searchById(areas, 3);

                if (predictionArea != null) {

                        FloodPredictionService.predictFloodRisk(
                                        predictionArea,
                                        90,
                                        130);

                        // AI risk level
                        int aiScore = FloodAIModel.predictRisk(predictionArea);

                        String aiLevel = FloodAIModel.predictLevel(aiScore);

                        // AI-based emergency response
                        FloodResponseService.generateResponse(
                                        predictionArea,
                                        aiLevel);

                } else {

                        System.out.println(
                                        "Prediction area not found.");
                }

                // ======================================
                // 11. BFS FLOOD AREA TRAVERSAL
                // ======================================

                System.out.println();

                FloodBFS bfs = new FloodBFS(graph.getGraph());

                bfs.traverse(2);

                // ======================================
                // 12. DFS FLOOD AREA TRAVERSAL
                // ======================================

                System.out.println();

                FloodDFS dfs = new FloodDFS(graph.getGraph());

                dfs.traverse(2);

                // ======================================
                // 13. SHORTEST PATH USING BFS
                // ======================================

                System.out.println();

                ShortestPath shortestPath = new ShortestPath(graph.getGraph());

                shortestPath.findPath(0, 2);

                // ======================================
                // 14. SEARCH AREA BY NAME
                // ======================================

                FloodArea result = FloodAreaSearch.searchByName(
                                areas, "Sector 3");

                if (result != null) {

                        System.out.println("Area Found!");

                        result.displayAreaDetails();

                } else {

                        System.out.println("Area not found.");
                }

                // ======================================
                // SYSTEM COMPLETE
                // ======================================

                System.out.println();
                System.out.println("System started successfully!");
                System.out.println("======================================");
        }
}
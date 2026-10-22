package dsa;

import model.FloodArea;

public class FloodAreaSorter {

    public static void sortByRiskDescending(FloodArea[] areas) {

        // Bubble Sort
        for (int i = 0; i < areas.length - 1; i++) {

            for (int j = 0; j < areas.length - 1 - i; j++) {

                if (areas[j].getRiskScore() < areas[j + 1].getRiskScore()) {

                    // Swap two FloodArea objects
                    FloodArea temp = areas[j];
                    areas[j] = areas[j + 1];
                    areas[j + 1] = temp;
                }
            }
        }
    }
}
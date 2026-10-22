package service;

import model.FloodArea;

public class FloodAIModel {

    public static int predictRisk(FloodArea area) {

        int score = 0;

        // Rainfall factor
        if (area.getRainfall() >= 100) {
            score += 40;
        } else if (area.getRainfall() >= 70) {
            score += 30;
        } else if (area.getRainfall() >= 40) {
            score += 20;
        } else {
            score += 10;
        }

        // Water level factor
        if (area.getWaterLevel() >= 150) {
            score += 40;
        } else if (area.getWaterLevel() >= 80) {
            score += 30;
        } else if (area.getWaterLevel() >= 50) {
            score += 20;
        } else {
            score += 10;
        }

        // Drainage factor
        if (area.getDrainageCondition().equalsIgnoreCase("Poor")) {
            score += 20;
        } else if (area.getDrainageCondition().equalsIgnoreCase("Average")) {
            score += 10;
        } else {
            score += 5;
        }

        return score;
    }

    public static String predictLevel(int score) {

        if (score >= 80) {
            return "CRITICAL";
        } else if (score >= 60) {
            return "HIGH";
        } else if (score >= 40) {
            return "MODERATE";
        } else {
            return "LOW";
        }
    }
}
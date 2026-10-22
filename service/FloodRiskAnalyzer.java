package service;

import model.FloodArea;

public class FloodRiskAnalyzer {

    public static void analyzeRisk(FloodArea area) {

        int score = 0;

        // Rainfall analysis
        if (area.getRainfall() >= 100) {
            score += 40;
        } else if (area.getRainfall() >= 70) {
            score += 30;
        } else if (area.getRainfall() >= 40) {
            score += 20;
        } else {
            score += 10;
        }

        // Water level analysis
        if (area.getWaterLevel() >= 150) {
            score += 40;
        } else if (area.getWaterLevel() >= 100) {
            score += 30;
        } else if (area.getWaterLevel() >= 50) {
            score += 20;
        } else {
            score += 10;
        }

        // Drainage analysis
        if (area.getDrainageCondition().equalsIgnoreCase("Poor")) {
            score += 20;
        } else if (area.getDrainageCondition().equalsIgnoreCase("Average")) {
            score += 10;
        }

        // Decide risk level
        String riskLevel;

        if (score >= 80) {
            riskLevel = "CRITICAL";
        } else if (score >= 60) {
            riskLevel = "HIGH";
        } else if (score >= 40) {
            riskLevel = "MODERATE";
        } else {
            riskLevel = "LOW";
        }

        area.setRiskScore(score);
        area.setRiskLevel(riskLevel);
    }
}
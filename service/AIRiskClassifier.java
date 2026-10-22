package service;

import model.FloodArea;

public class AIRiskClassifier {

    public static void classify(FloodArea area) {

        double rainfall = area.getRainfall();
        double waterLevel = area.getWaterLevel();
        double riskScore = area.getRiskScore();

        // AI-style weighted classification
        double rainfallScore = Math.min(100, rainfall * 0.5);
        double waterLevelScore = Math.min(100, waterLevel * 0.4);
        double riskComponent = riskScore * 0.3;

        double aiScore =
                (rainfallScore * 0.35)
                + (waterLevelScore * 0.35)
                + (riskComponent * 0.30);

        String prediction;

        if (aiScore >= 80) {
            prediction = "CRITICAL";
        } else if (aiScore >= 60) {
            prediction = "HIGH";
        } else if (aiScore >= 40) {
            prediction = "MODERATE";
        } else {
            prediction = "LOW";
        }

        System.out.println(
                "Area: " + area.getAreaName()
                + " | AI Score: " + Math.round(aiScore)
                + " | Predicted Risk: " + prediction
        );
    }
}

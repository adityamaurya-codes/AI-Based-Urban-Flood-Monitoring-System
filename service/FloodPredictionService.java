package service;

import model.FloodArea;

public class FloodPredictionService {

    public static void predictFloodRisk(
            FloodArea area,
            double previousRainfall,
            double previousWaterLevel) {

        double currentRainfall = area.getRainfall();
        double currentWaterLevel = area.getWaterLevel();
        double currentRiskScore = area.getRiskScore();

        // Calculate environmental changes
        double rainfallChange =
                currentRainfall - previousRainfall;

        double waterLevelChange =
                currentWaterLevel - previousWaterLevel;

        // Convert changes into prediction factors
        double rainfallFactor =
                Math.max(0, Math.min(100, rainfallChange * 2));

        double waterLevelFactor =
                Math.max(0, Math.min(100, waterLevelChange * 2));

        /*
         * AI-style weighted prediction
         *
         * Current flood condition = 50%
         * Water-level trend       = 30%
         * Rainfall trend          = 20%
         */
        double aiPredictionScore =
                (currentRiskScore * 0.50)
                + (waterLevelFactor * 0.30)
                + (rainfallFactor * 0.20);

        int finalScore =
                (int) Math.round(aiPredictionScore);

        System.out.println();
        System.out.println("========== AI FLOOD PREDICTION ==========");

        System.out.println(
                "Area: " + area.getAreaName()
        );

        System.out.println(
                "Current Risk Score: "
                + currentRiskScore
        );

        System.out.println(
                "Rainfall Change: "
                + rainfallChange + " mm"
        );

        System.out.println(
                "Water Level Change: "
                + waterLevelChange + " cm"
        );

        System.out.println(
                "AI Prediction Score: "
                + finalScore
        );

        // AI prediction classification
        if (finalScore >= 80) {

            System.out.println(
                    "AI PREDICTION: CRITICAL FLOOD RISK AHEAD!"
            );

        } else if (finalScore >= 60) {

            System.out.println(
                    "AI PREDICTION: HIGH FLOOD RISK AHEAD!"
            );

        } else if (finalScore >= 40) {

            System.out.println(
                    "AI PREDICTION: MODERATE FLOOD RISK."
            );

        } else {

            System.out.println(
                    "AI PREDICTION: LOW FLOOD RISK."
            );
        }
    }
}
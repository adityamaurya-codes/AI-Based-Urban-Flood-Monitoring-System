package model;

public class FloodArea {

    private int areaId;
    private String areaName;
    private double rainfall;
    private double waterLevel;
    private String drainageCondition;
    private int riskScore;
    private String riskLevel;

    public FloodArea(int areaId, String areaName, double rainfall,
                     double waterLevel, String drainageCondition) {

        this.areaId = areaId;
        this.areaName = areaName;
        this.rainfall = rainfall;
        this.waterLevel = waterLevel;
        this.drainageCondition = drainageCondition;
        this.riskScore = 0;
        this.riskLevel = "NOT ANALYZED";
    }

    public int getAreaId() {
        return areaId;
    }

    public String getAreaName() {
        return areaName;
    }

    public double getRainfall() {
        return rainfall;
    }

    public double getWaterLevel() {
        return waterLevel;
    }

    public String getDrainageCondition() {
        return drainageCondition;
    }

    public int getRiskScore() {
        return riskScore;
    }

    public String getRiskLevel() {
        return riskLevel;
    }

    public void setRiskScore(int riskScore) {
        this.riskScore = riskScore;
    }

    public void setRiskLevel(String riskLevel) {
        this.riskLevel = riskLevel;
    }

    public void displayAreaDetails() {

        System.out.println("--------------------------------------");
        System.out.println("Area ID: " + areaId);
        System.out.println("Area Name: " + areaName);
        System.out.println("Rainfall: " + rainfall + " mm");
        System.out.println("Water Level: " + waterLevel + " cm");
        System.out.println("Drainage: " + drainageCondition);
        System.out.println("Risk Score: " + riskScore);
        System.out.println("Risk Level: " + riskLevel);
        System.out.println("--------------------------------------");
    }
}

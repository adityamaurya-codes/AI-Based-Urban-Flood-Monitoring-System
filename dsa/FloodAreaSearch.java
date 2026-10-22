package dsa;

import model.FloodArea;

public class FloodAreaSearch {

    public static FloodArea searchByName(FloodArea[] areas, String targetName) {

        for (int i = 0; i < areas.length; i++) {

            if (areas[i].getAreaName().equalsIgnoreCase(targetName)) {
                return areas[i];
            }
        }

        return null;
    }

    public static FloodArea searchById(FloodArea[] areas, int targetId) {

        for (int i = 0; i < areas.length; i++) {

            if (areas[i].getAreaId() == targetId) {
                return areas[i];
            }
        }

        return null;
    }
}
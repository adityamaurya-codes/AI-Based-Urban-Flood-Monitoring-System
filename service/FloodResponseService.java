package service;

import model.FloodArea;

public class FloodResponseService {

    public static void generateResponse(FloodArea area, String aiLevel) {

        System.out.println();
        System.out.println("========== AI RESPONSE SYSTEM ==========");

        System.out.println(
                "Area: " + area.getAreaName()
        );

        System.out.println(
                "Risk Level: " + aiLevel
        );

        if (aiLevel.equals("CRITICAL")) {

            System.out.println(
                    "ACTION: Immediate evacuation required."
            );
            System.out.println(
                    "ACTION: Emergency response team should be deployed."
            );

        } else if (aiLevel.equals("HIGH")) {

            System.out.println(
                    "ACTION: Issue flood warning to residents."
            );
            System.out.println(
                    "ACTION: Prepare emergency response team."
            );

        } else if (aiLevel.equals("MODERATE")) {

            System.out.println(
                    "ACTION: Continue close monitoring."
            );

        } else {

            System.out.println(
                    "ACTION: Normal monitoring required."
            );
        }
    }
}

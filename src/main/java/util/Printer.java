package util;

import model.Deal;

import java.util.Set;

import static util.Constants.MAX_PRINTED_FLUTES_COUNT;

public class Printer {

    public static void printAnswer(Deal firstTaskResult, int schuursCount) {
        System.out.println("Schuurs: " + schuursCount);
        System.out.println("Maximum profit is: " + firstTaskResult.getMaxProfit());
        System.out.print("Number of flutes to buy:");
        Set<Integer> flutesBuyCountTarget = firstTaskResult.getSortedFlutesBuyCountTarget();
        int iterationCount = 1;
        for (int target : flutesBuyCountTarget) {
            if (iterationCount == MAX_PRINTED_FLUTES_COUNT) {
                break;
            }
            System.out.print(" " + target);
            iterationCount++;
        }
        System.out.println();
    }

}

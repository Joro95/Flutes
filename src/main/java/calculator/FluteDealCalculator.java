package calculator;

import model.Deal;
import model.Schuur;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FluteDealCalculator {

    private FluteDealCalculator() {
        //Static class
    }

    public static Deal getBestDeal(List<Schuur> schuurs) {
        List<Deal> deals = new ArrayList<>();
        for (Schuur schuur : schuurs) {
            deals.add(schuur.getBestDeal());
        }
        return mergeDeals(deals);
    }

    private static Deal mergeDeals(List<Deal> deals) {
        Deal result = new Deal();
        for (Deal deal : deals) {
            result = mergeDeals(result, deal);
        }
        return result;
    }

    private static Deal mergeDeals(Deal first, Deal second) {
        int maxProfit = first.getMaxProfit() + second.getMaxProfit();
        Set<Integer> flutesBuyCountTarget = new HashSet<>();
        if (first.getFlutesBuyCountTarget().isEmpty()) {
            flutesBuyCountTarget.addAll(second.getFlutesBuyCountTarget());
        }
        for (int firstDealTarget : first.getFlutesBuyCountTarget()) {
            for (int secondDealTarget : second.getFlutesBuyCountTarget()) {
                flutesBuyCountTarget.add(firstDealTarget + secondDealTarget);
            }
        }
        return new Deal(maxProfit, flutesBuyCountTarget);
    }
}

package model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static util.Constants.FLUTE_SELL_PRICE;

public final class Schuur {

    private final List<Integer> flutePrices;

    public Schuur(List<Integer> flutePrices) {
        for (int price : flutePrices) {
            if (price <= 0) {
                throw new IllegalArgumentException("Flute price should be a positive number");
            }
        }
        this.flutePrices = new ArrayList<>(flutePrices);
    }

    public Deal getBestDeal() {
        Set<Integer> numberOfFlutesToBuy = new HashSet<>();
        int maxProfit = 0;
        int flutesCost = 0;
        for (int i = 1; i <= this.flutePrices.size(); i++) {
            flutesCost += this.flutePrices.get(i - 1);
            int profit = (i * FLUTE_SELL_PRICE) - flutesCost;
            if (profit > maxProfit) {
                maxProfit = profit;
                numberOfFlutesToBuy = new HashSet<>();
            }
            if (profit >= maxProfit) {
                numberOfFlutesToBuy.add(i);
            }
        }
        return new Deal(maxProfit, numberOfFlutesToBuy);
    }
}

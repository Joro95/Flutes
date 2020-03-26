package model;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public final class Deal {

    private final int maxProfit;
    private final Set<Integer> flutesBuyCountTarget;

    public Deal() {
        this.maxProfit = 0;
        this.flutesBuyCountTarget = new HashSet<>();
    }

    public Deal(int maxProfit, Set<Integer> flutesBuyCountTarget) {
        if (maxProfit < 0) {
            throw new IllegalArgumentException("Profit can't be a negative number");
        }
        for (int target : flutesBuyCountTarget) {
            if (target <= 0) {
                throw new IllegalArgumentException("Flute buy count target should be a positive number");
            }
        }
        this.maxProfit = maxProfit;
        this.flutesBuyCountTarget = new HashSet<>(flutesBuyCountTarget);
    }

    public Set<Integer> getSortedFlutesBuyCountTarget() {
        return new TreeSet<>(flutesBuyCountTarget);
    }

    public Set<Integer> getFlutesBuyCountTarget() {
        return new HashSet<>(flutesBuyCountTarget);
    }

    public int getMaxProfit() {
        return maxProfit;
    }
}

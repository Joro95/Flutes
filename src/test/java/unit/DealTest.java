package unit;

import calculator.FluteDealCalculator;
import model.Deal;
import model.Schuur;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class DealTest {

    @Test
    public void getBestDealWithTwoShuursTest() {
        //Arrange
        Schuur schuur1 = new Schuur(Arrays.asList(7, 3, 11, 9, 10));
        Schuur schuur2 = new Schuur(Arrays.asList(1, 2, 3, 4, 10, 16, 10, 4, 16));
        List<Schuur> schuurs = Arrays.asList(schuur1, schuur2);
        Set<Integer> expectedFlutesBuyCountTarget = Set.of(6, 7, 8, 9, 10, 12, 13);

        //Act
        Deal result = FluteDealCalculator.getBestDeal(schuurs);

        //Assert
        assertEquals(40, result.getMaxProfit());
        assertEquals(expectedFlutesBuyCountTarget, result.getFlutesBuyCountTarget());
    }

    @Test
    public void getBestDealWithThreeSchuursTest() {
        //Arrange
        Schuur schuur1 = new Schuur(Arrays.asList(7, 3, 11, 9, 10));
        Schuur schuur2 = new Schuur(Arrays.asList(1, 2, 3, 4, 10, 16, 10, 4, 16));
        Schuur schuur3 = new Schuur(Arrays.asList(6, 12));
        List<Schuur> schuurs = Arrays.asList(schuur1, schuur2, schuur3);
        Set<Integer> expectedFlutesBuyCountTarget = Set.of(7, 8, 9, 10, 11, 13, 14);

        //Act
        Deal result = FluteDealCalculator.getBestDeal(schuurs);

        //Assert
        assertEquals(44, result.getMaxProfit());
        assertEquals(expectedFlutesBuyCountTarget, result.getFlutesBuyCountTarget());
    }

    @Test(expected = IllegalArgumentException.class)
    public void mergeDealsInvalidMaxProfitTest() {
        new Deal(-4, Set.of(2, 3));
    }

    @Test(expected = IllegalArgumentException.class)
    public void mergeDealsInvalidBuyCountTargetTest() {
        new Deal(4, Set.of(-2, 3));
    }
}

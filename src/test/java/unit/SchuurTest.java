package unit;

import model.Deal;
import model.Schuur;
import org.junit.Test;

import java.util.Arrays;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class SchuurTest {

    @Test
    public void getBestDealTest() {
        //Arrange
        Schuur schuur = new Schuur(Arrays.asList(3, 7, 16, 4));
        Set<Integer> expectedFlutesBuyCountTarget = Set.of(2, 4);

        //Act
        Deal result = schuur.getBestDeal();

        //Assert
        assertEquals(10, result.getMaxProfit());
        assertEquals(expectedFlutesBuyCountTarget, result.getFlutesBuyCountTarget());
    }


    @Test(expected = IllegalArgumentException.class)
    public void getBestDealExceptionTest() {
        new Schuur(Arrays.asList(3, 7, -2, 4));
    }
}

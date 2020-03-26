import calculator.FluteDealCalculator;
import model.Deal;
import model.Schuur;
import util.Printer;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ExampleApplication {

    public static void main(String[] args) {
        //First input from document
        Schuur schuur = new Schuur(Arrays.asList(12, 3, 10, 7, 16, 5));
        List<Schuur> firstTask = Collections.singletonList(schuur);
        Deal firstTaskResult = FluteDealCalculator.getBestDeal(firstTask);
        Printer.printAnswer(firstTaskResult, firstTask.size());
        System.out.println();
        //Second input from document
        Schuur schuur1 = new Schuur(Arrays.asList(7, 3, 11, 9, 10));
        Schuur schuur2 = new Schuur(Arrays.asList(1, 2, 3, 4, 10, 16, 10, 4, 16));
        List<Schuur> secondTask = Arrays.asList(schuur1, schuur2);
        Deal secondTaskResult = FluteDealCalculator.getBestDeal(secondTask);
        Printer.printAnswer(secondTaskResult, secondTask.size());
    }

}

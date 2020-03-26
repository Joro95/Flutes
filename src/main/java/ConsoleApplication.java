import calculator.FluteDealCalculator;
import model.Deal;
import model.Schuur;
import org.apache.commons.lang3.math.NumberUtils;
import util.InputStatus;
import util.InputUtils;
import util.Printer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleApplication {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Integer schuurCount = getUserSchuurCount(sc);
        List<Schuur> schuurs = getUserSchuurs(schuurCount, sc);
        Deal bestDeal = FluteDealCalculator.getBestDeal(schuurs);
        Printer.printAnswer(bestDeal, schuurCount);
    }

    private static Integer getUserSchuurCount(Scanner sc) {
        Integer schuurCount = null;
        while (schuurCount == null) {
            System.out.println("Enter valid number of schuurs:");
            String schuurCountInput = sc.nextLine().trim();
            if (NumberUtils.isParsable(schuurCountInput)) {
                schuurCount = Integer.valueOf(schuurCountInput);
            } else {
                System.out.print("Invalid input! ");
            }
        }
        return schuurCount;
    }

    /*
     * It can be done by reading all lines until the user inputs zero as requested in the task,
     * but since we already know the number of schuurs may as well ask the user for the right amount of schuurs
     * and not leave it to the user to input the ending zero
     */
    private static List<Schuur> getUserSchuurs(Integer schuurCount, Scanner sc) {
        List<Schuur> schuurs = new ArrayList<>();
        for (int i = 1; i <= schuurCount; i++) {
            List<Integer> flutePrices = null;
            while (flutePrices == null) {
                System.out.println("Schuur " + i + ". " +
                        "Enter number of boxes followed by price for each box(leave one space between each number):");
                String input = sc.nextLine().trim();
                InputStatus inputStatus = InputUtils.verifyInput(input);
                if (inputStatus.isValid()) {
                    flutePrices = new ArrayList<>();
                    String[] flutePricesInput = input.split(" ");
                    //Start from 1, as the number at index 0 is the count of the flutes.
                    for (int j = 1; j < flutePricesInput.length; j++) {
                        Integer flutePrice = Integer.valueOf(flutePricesInput[j]);
                        flutePrices.add(flutePrice);
                    }
                } else {
                    System.out.println(inputStatus.getErrorMessage());
                }
            }
            Schuur schuur = new Schuur(flutePrices);
            schuurs.add(schuur);
        }
        return schuurs;
    }

}

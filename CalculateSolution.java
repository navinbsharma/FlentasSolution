import java.util.Arrays;
import java.util.Scanner;


public class CalculateSolution {
    public static void main(String[] args) {
        Scanner scannerObj = new Scanner(System.in);
        System.out.println("Enter no of test Cases : ");
        int testCases = scannerObj.nextInt();

        for (int i = 0; i < testCases; i++) {
            System.out.println("Testcase "+(i+1));
            System.out.println("Enter no of person : ");
            int noOfPerson = scannerObj.nextInt();
            int priceArray[] = new int[noOfPerson];
            for (int j = 0; j < noOfPerson; j++) {
                System.out.println("Enter price for " + (j + 1) + "th person ");
                priceArray[j] = scannerObj.nextInt();
            }
            int amount = calaculatePrice(priceArray, noOfPerson);
            System.out.println("Amount for "+ (i+1 ) +" TestCase : " + amount);
            System.out.println();
            System.out.println("*****************");

        }
        scannerObj.close();
    }

    public static int calaculatePrice(int[] priceArray, int noOfPerson) {
        int totalPrice = 0;
        Arrays.sort(priceArray);

        if (noOfPerson == 2) {
            totalPrice = priceArray[1];
        } else {
            for (int i = noOfPerson - 1; i > 1; i -= 2) {
                // if (i == 2) {
                //     totalPrice += priceArray[2] + priceArray[0];
                // } else {

                    // Both the ways as discussed above
                    long price_first = priceArray[i] + priceArray[0] + 2 * priceArray[1];
                    long price_second = priceArray[i] + priceArray[i - 1] + 2 * priceArray[0];
                    totalPrice += Math.min(price_first, price_second);
                //}
            }

            // Calculate the minimum price
            // of the two cheapest person
            if (noOfPerson == 1) {
                totalPrice += priceArray[0];
            } else {
                totalPrice += priceArray[1];
            }
        }

        return totalPrice;
    }

}
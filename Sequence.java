import java.text.DecimalFormat;
import java.util.Scanner;

public class Assignment8 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int count = 0;
        double[] ar = new double[100];
        double value;

        while (true) {
            System.out.print("Enter number(0 to end): ");
            value = scan.nextDouble();
            scan.nextLine();
            if (value == 0)
                break;
            ar[count] = value;
            count++;
        }
        count = count + 1;

        /*Displaying output*/
        DecimalFormat df = new DecimalFormat("0.##");
        System.out.println("Max element: " + df.format(findMax(ar, count)));
        System.out.println("Negative count: " + countNegative(ar, count));
        System.out.println("Sum of positive: " + df.format(computeSumPositive(ar, count)));

        scan.close();
    }

    //finding max number
    public static double findMax(double[] ar, int count) {
        if (count == 1)
            return ar[0];
        return Math.max(ar[count - 1], findMax(ar, count - 1));
    }

    //continue negative numbers
    public static int countNegative(double[] ar, int count) {
        if (count == 0) {
            return 0;
        }
        int c = countNegative(ar, count - 1);
        if (ar[count - 1] < 0) {
            c++;
        }
        return c;
    }

    //finding the sum of positive numbers
    public static double computeSumPositive(double[] ar, int count) {
        double sum = 0;
        if (count > 0) {
            double val = (ar[count - 1] > 0) ? ar[count - 1] : 0;
            sum = val + computeSumPositive(ar, count - 1);
            return sum;
        } else
            return sum;
    }
}
import java.util.Scanner;

public class IT24104011Lab5Q3 {
    // Constants
    public static final int ROOM_CHARGE_PER_DAY = 48000;
    public static final int NO_DISCOUNT = 0;
    public static final int DISCOUNT_3_TO_4_DAYS = 10;
    public static final int DISCOUNT_5_OR_MORE_DAYS = 20;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input start date and end date
        System.out.print("Enter the start date of the reservation (1-31): ");
        int startDate = scanner.nextInt();
        System.out.print("Enter the end date of the reservation (1-31): ");
        int endDate = scanner.nextInt();

        // Validation
        if (startDate < 1 || startDate > 31 || endDate < 1 || endDate > 31) {
            System.out.println("Error: Start date and end date must be between 1 and 31.");
            return;
        }
        if (startDate >= endDate) {
            System.out.println("Error: Start date must be less than end date.");
            return;
        }

        // Calculate number of days reserved
        int numberOfDaysReserved = endDate - startDate;

        // Determine discount rate
        int discountRate;
        if (numberOfDaysReserved < 3) {
            discountRate = NO_DISCOUNT;
        } else if (numberOfDaysReserved <= 4) {
            discountRate = DISCOUNT_3_TO_4_DAYS;
        } else {
            discountRate = DISCOUNT_5_OR_MORE_DAYS;
        }

        // Calculate total amount to be paid
        double totalAmount = numberOfDaysReserved * ROOM_CHARGE_PER_DAY;
        double discountAmount = totalAmount * discountRate / 100;
        double finalAmount = totalAmount - discountAmount;

        // Output results
        System.out.println("Number of days reserved: " + numberOfDaysReserved);
        System.out.println("Total amount before discount: Rs " + totalAmount);
        System.out.println("Discount rate: " + discountRate + "%");
        System.out.println("Total amount after discount: Rs " + finalAmount);

        scanner.close();
    }
}

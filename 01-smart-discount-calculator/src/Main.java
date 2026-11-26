import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter customer type (REGULAR / STUDENT / PREMIUM): ");
        String customerType = input.nextLine();

        System.out.print("Enter purchase amount: ");
        double purchaseAmount = input.nextDouble();

        System.out.print("Are you a member? (true / false): ");
        boolean isMember = input.nextBoolean();

        if (purchaseAmount <= 0) {
            System.out.println("Invalid purchase amount!");
            input.close();
            return;
        }

        double baseDiscount = calculateBaseDiscount(customerType);

        if (baseDiscount == -1) {
            System.out.println("Invalid customer type!");
            input.close();
            return;
        }

        double discountRate = calculateDiscountRate(
                baseDiscount, purchaseAmount, isMember);

        double discountAmount = purchaseAmount * discountRate;

        double finalAmount = purchaseAmount - discountAmount;

        System.out.println("---- SMART DISCOUNT CALCULATOR---- ");

        System.out.println("Customer Type: " + customerType);
        System.out.printf("Purchase Amount: LKR %.2f%n", purchaseAmount);
        System.out.printf("Discount: %.0f%%%n", discountRate * 100);
        System.out.printf("Discount Amount: LKR %.2f%n", discountAmount);
        System.out.printf("Final Amount: LKR %.2f%n", finalAmount);

        input.close();
    }

    static double calculateBaseDiscount(String customerType) {

        if (customerType.equalsIgnoreCase("REGULAR")) {
            return 0.0;
        }
        else if (customerType.equalsIgnoreCase("STUDENT")) {
            return 0.05;
        }
        else if (customerType.equalsIgnoreCase("PREMIUM")) {
            return 0.10;
        }

        return -1;
    }

    static double calculateDiscountRate(double baseDiscount, double purchaseAmount, boolean isMember) {

        double discountRate = baseDiscount;

        if (purchaseAmount >= 10000) {
            discountRate += 0.05;
        }

        if (isMember) {
            discountRate += 0.02;
        }

        if (discountRate > 0.20) {
            discountRate = 0.20;
        }


        return discountRate;
    }

    static double calculateDiscountAmount(double purchaseAmount, double discountRate) {

        return purchaseAmount * discountRate;
    }

    static double calculateFinalAmount(double purchaseAmount, double discountAmount) {

        return purchaseAmount - discountAmount;
    }
}



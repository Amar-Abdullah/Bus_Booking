import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Sort {
    private static Scanner scanner = new Scanner(System.in);

    public static void sort() {
        boolean exit = false;
        while (!exit) {
            // CommonCode.printla("\nMain Menu");
            CommonClass.Notified("\nSort");
            CommonClass.Notified("=======================");
            CommonClass.Notified("1. Bubble Sort");
            CommonClass.Notified("2. Insertion Sort");
            CommonClass.Notified("3. Exit");
            CommonClass.Notified("Enter Your Choice: ");

            int choice = getIntInput();

            switch (choice) {
                case 1:
                    BubbleSortforCustomer();
                    break;
                case 2:
                    InsertionSortforCustomer();
                    break;
                case 3:
                    CommonClass.Notified("Exiting..........");
                    MainFunctions.Login();
                    break;
                default:
                    CommonClass.Notified("Invalid Choice. Please enter a number between 1 and 3");
            }
        }
    }

    private static List<Customer> getCustomersList() {
        List<Customer> CustomerList = new ArrayList<>();
        for (Customer customer : DB.customers) {
            CustomerList.add(customer);
        }
        return CustomerList;
    }

    public static void InsertionSortforCustomer() {
        List<Customer> CustomerList = getCustomersList();
        InsertionSort.insertionSorting(CustomerList);
        for (Customer customer : CustomerList) {
            System.out.println(customer);
        }
    }

    public static void BubbleSortforCustomer() {
        List<Customer> CustomerList = getCustomersList();
        BubbleSort.bubbleSorting(CustomerList);
        for (Customer customer : CustomerList) {
            System.out.println(customer);
        }
    }

    public static int getIntInput() {
        int input = -1;
        while (input == -1) {
            try {
                input = scanner.nextInt();
                scanner.nextLine(); // Consume newline character left by nextInt
            } catch (InputMismatchException e) {
                CommonClass.Notified("Invalid input. Please Enter a valid integer.");
                scanner.nextLine(); // Consume the invalid input
            }
        }
        return input;
    }
}

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * MainFunctions
 */
public class MainFunctions {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        DB.Customer_Data();
        DB.Buse_Data();
        Login();

    }

    public static void Login() {
        boolean exit = false;
        while (!exit) {
            CommonClass.Notified("\nWelcome to Bus Booking.com");
            CommonClass.Notified("Select Your Role");
            CommonClass.Notified("1. Admin");
            CommonClass.Notified("2. Customer");
            CommonClass.Notified("3. Exit");
            CommonClass.Notified("Enter Your Choice: ");

            int choice = getIntInput();

            switch (choice) {
                case 1:
                    AbstractLogin adminLogin = new AdminLogin();
                    adminLogin.startLogin(); // Handle admin login
                    break;

                case 2:
                    AbstractLogin customerLogin = new CustomerLogin();
                    customerLogin.startLogin(); // Handle customer login
                    break;

                case 3:
                    exit = true;
                    CommonClass.Notified("Exiting..........");
                    break;

                default:
                    CommonClass.Notified("Invalid Choice. Please enter a number between 1 and 3");
            }
        }
    }

    public static void Admin() {
        boolean exit = false;
        while (!exit) {
            // CommonCode.printla("\nMain Menu");
            CommonClass.Notified("\nMain Menu");
            CommonClass.Notified("=======================");
            CommonClass.Notified("1. Bus Managment");
            CommonClass.Notified("2. View Customer Details");
            CommonClass.Notified("3. Recently Add Customer");
            CommonClass.Notified("4. Sort Customer Details");
            CommonClass.Notified("5. Exit");
            CommonClass.Notified("Enter Your Choice: ");

            int choice = getIntInput();

            switch (choice) {
                case 1:
                    Bus.BusMenu();
                    break;
                case 2:
                    Customer.viewAllCustomers();
                    break;
                case 3:
                    List<Customer> customers = DB.customers;
                    CommonClass.Notified("\nHome> Customer> Recently Added Customer");
                    CommonClass.Notified("\n=======================================");
                    Stack stack = new Stack(customers.size());
                    for (Customer customer : customers) {
                        stack.stackPush(customer);
                    }
                    stack.stackDisplay();
                case 4:
                    Sort.sort();
                    break;
                case 5:
                    CommonClass.Notified("Exiting..........");
                    MainFunctions.Login();
                    break;
                default:
                    CommonClass.Notified("Invalid Choice. Please enter a number between 1 and 3");
            }
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

/*
 * public static void CustomerMenu() {
 * boolean exit = false;
 * while (!exit) {
 * CommonClass.Notified("\nHome> Customer");
 * CommonClass.Notified("===================");
 * CommonClass.Notified("1. Insert Customer");
 * CommonClass.Notified("2. Update Customer");
 * CommonClass.Notified("3. Delete Customer");
 * CommonClass.Notified("4. View All Customer");
 * CommonClass.Notified("5. Exit");
 * CommonClass.Notified_1("Enter Your Choice: ");
 * 
 * int choice = scanner.nextInt();
 * scanner.nextLine(); // Consume newline left-over
 * Customer customerDetails = new Customer();
 * 
 * switch (choice) {
 * case 1:
 * customerDetails.insertCustomer();
 * break;
 * case 2:
 * customerDetails.updateCustomer();
 * break;
 * case 3:
 * customerDetails.deleteCustomer();
 * break;
 * 
 * case 4:
 * List<Customer> customers = DB.customers;
 * CommonClass.Notified("\nHome> Customer> Recently Added Customer");
 * CommonClass.Notified("\n=======================================");
 * Stack stack = new Stack(customers.size());
 * 
 * for (Customer customer : customers) {
 * stack.stackPush(customer);
 * }
 * stack.stackDisplay();
 * break;
 * case 5:
 * CommonClass.Notified("\nAll Customers:");
 * Customer.viewAllCustomers();
 * break;
 * case 6:
 * CommonClass.Notified("Exiting....");
 * MainFunctions.Login();
 * 
 * break;
 * default:
 * CommonClass.Notified("Invalid choice. Please enter a number between 1 to 5."
 * );
 * 
 * }
 * }
 * 
 * }
 */
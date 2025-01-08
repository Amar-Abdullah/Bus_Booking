import java.util.Scanner;

public class Customer {
    private String Customer_ID, Customer_Name, Customer_MobileNumber, Customer_EmailID, Customer_City, Customer_Address,
            Customer_NIC, Customer_username, Customer_password;
    private Integer Customer_Age;

    private static Scanner scanner = new Scanner(System.in);
    public static String lo_Username;
    public static String lo_password;

    public Customer() {
    }

    public Customer(String Customer_ID, String Customer_Name, String Customer_EmailID, String Customer_City,
            String Customer_Address, String Customer_NIC, Integer Customer_Age, String Customer_MobileNumber,
            String Customer_username, String Customer_password) {
        this.Customer_ID = Customer_ID;
        this.Customer_Name = Customer_Name;
        this.Customer_EmailID = Customer_EmailID;
        this.Customer_City = Customer_City;
        this.Customer_Address = Customer_Address;
        this.Customer_NIC = Customer_NIC;
        this.Customer_Age = Customer_Age;
        this.Customer_MobileNumber = Customer_MobileNumber;
        this.Customer_username = Customer_username;
        this.Customer_password = Customer_password;

    }

    // Getter and Setter methods...

    public String getCustomer_ID() {
        return Customer_ID;
    }

    public void setCustomer_ID(String customer_ID) {
        Customer_ID = customer_ID;
    }

    public String getCustomer_Name() {
        return Customer_Name;
    }

    public void setCustomer_Name(String customer_Name) {
        Customer_Name = customer_Name;
    }

    public String getCustomer_EmailID() {
        return Customer_EmailID;
    }

    public void setCustomer_EmailID(String customer_EmailID) {
        Customer_EmailID = customer_EmailID;
    }

    public String getCustomer_City() {
        return Customer_City;
    }

    public void setCustomer_City(String customer_City) {
        Customer_City = customer_City;
    }

    public String getCustomer_Address() {
        return Customer_Address;
    }

    public void setCustomer_Address(String customer_Address) {
        Customer_Address = customer_Address;
    }

    public String getCustomer_NIC() {
        return Customer_NIC;
    }

    public void setCustomer_NIC(String customer_NIC) {
        Customer_NIC = customer_NIC;
    }

    public Integer getCustomer_Age() {
        return Customer_Age;
    }

    public void setCustomer_Age(Integer customer_Age) {
        Customer_Age = customer_Age;
    }

    public String getCustomer_MobileNumber() {
        return Customer_MobileNumber;
    }

    public void setCustomer_MobileNumber(String customer_MobileNumber) {
        Customer_MobileNumber = customer_MobileNumber;
    }

    public String getCustomer_username() {
        return Customer_username;
    }

    public void setCustomer_username(String customer_username) {
        Customer_username = customer_username;
    }

    public String getCustomer_password() {
        return Customer_password;
    }

    public void setCustomer_password(String customer_password) {
        Customer_password = customer_password;
    }

    public static void CustomerMenu() {
        boolean exit = false;
        while (!exit) {
            try {
                CommonClass.Notified("\nHome> Customer");
                CommonClass.Notified("===================");
                CommonClass.Notified("1. Add Personal Info");
                CommonClass.Notified("2. Update Account");
                CommonClass.Notified("3. Delete Account");
                CommonClass.Notified("4. View Buses");
                CommonClass.Notified("5. Search Buses by Name");
                CommonClass.Notified("6. Reserve Seat");
                CommonClass.Notified("7. Cancle Seat");
                CommonClass.Notified("8. Exit");
                CommonClass.Notified_1("Enter Your Choice: ");

                int choice = Integer.parseInt(scanner.nextLine());
                Customer customerDetails = new Customer();

                switch (choice) {
                    case 1:
                        customerDetails.insertCustomer();
                        break;
                    case 2:
                        customerDetails.updateCustomer();
                        break;
                    case 3:
                        customerDetails.deleteCustomer();
                        break;
                    case 4:
                        Bus.viewAllBuses();
                        break;
                    case 5:
                        Bus.searchBusesByRouteNameAndTime();
                        break;
                    case 6:
                        CommonClass.Notified("Please enter the bus Number to proceed with the reservation: ");
                        String busNumberToReserve = scanner.nextLine();
                        Bus busToReserve = Bus.searchBusByNumber(busNumberToReserve);
                        if (busToReserve != null) {
                            busToReserve.reserveBus();
                        } else {
                            CommonClass.Notified("The specified bus was not found for reservation.");
                        }
                        break;
                    case 7:
                        CommonClass.Notified("Cancel Reservation: ");
                        CommonClass.Notified("Enter the bus number : ");
                        String busNumberToCancel = scanner.nextLine();
                        Bus busToCancel = Bus.searchBusByNumber(busNumberToCancel);
                        if (busToCancel != null) {
                            busToCancel.cancelReservation();
                            break;
                        } else {
                            CommonClass.Notified("The specified bus was not found for reservation.");
                        }
                        break;
                    case 8:
                        CommonClass.Notified("Exiting....");
                        MainFunctions.Login();
                        exit = true;
                        break;
                    default:
                        CommonClass.Notified("Invalid choice. Please enter a number between 1 to 5.");
                }
            } catch (NumberFormatException e) {
                CommonClass.Notified("Invalid input. Please enter a valid number.");
            } catch (Exception e) {
                CommonClass.Notified("An error occurred: " + e.getMessage());
            }
        }
    }

    public void insertCustomer() {
        try {
            CommonClass.Notified_1("Enter Customer ID: ");
            this.Customer_ID = scanner.nextLine();

            CommonClass.Notified_1("Enter Customer Name: ");
            this.Customer_Name = scanner.nextLine();

            CommonClass.Notified_1("Enter Customer Mobile: ");
            this.Customer_MobileNumber = scanner.nextLine();

            CommonClass.Notified_1("Enter Customer Email: ");
            this.Customer_EmailID = scanner.nextLine();

            CommonClass.Notified_1("Enter Customer City: ");
            this.Customer_City = scanner.nextLine();

            CommonClass.Notified_1("Enter Customer Age: ");
            this.Customer_Age = Integer.parseInt(scanner.nextLine());

            CommonClass.Notified_1("Enter Customer NIC: ");
            this.Customer_NIC = scanner.nextLine();

            CommonClass.Notified_1("Enter Customer Address: ");
            this.Customer_Address = scanner.nextLine();

            DB.customers.add(this);
            CommonClass.Notified("Customer inserted successfully");
        } catch (NumberFormatException e) {
            CommonClass.Notified("Invalid input for age. Please enter a valid number.");
        } catch (Exception e) {
            CommonClass.Notified("An error occurred: " + e.getMessage());
        }
    }

    public void updateCustomer() {
        try {
            CommonClass.Notified_1("Find Customer By NIC: ");
            String findCustomerNIC = scanner.nextLine();
            Customer customer = searchCustomerByNIC(findCustomerNIC);

            if (customer != null) {
                CommonClass.Notified_1("Enter Customer Name:");
                customer.setCustomer_Name(scanner.nextLine());

                CommonClass.Notified_1("Enter Customer Mobile Number:");
                customer.setCustomer_MobileNumber(scanner.nextLine());

                CommonClass.Notified_1("Enter Customer Email:");
                customer.setCustomer_EmailID(scanner.nextLine());

                CommonClass.Notified_1("Enter Customer City:");
                customer.setCustomer_City(scanner.nextLine());

                CommonClass.Notified_1("Enter Customer Age:");
                customer.setCustomer_Age(Integer.parseInt(scanner.nextLine()));

                CommonClass.Notified_1("Enter Customer NIC:");
                customer.setCustomer_NIC(scanner.nextLine());

                CommonClass.Notified_1("Enter Customer Address:");
                customer.setCustomer_Address(scanner.nextLine());

                CommonClass.Notified("Customer updated successfully");
            } else {
                CommonClass.Notified("Customer not found.");
            }
        } catch (NumberFormatException e) {
            CommonClass.Notified("Invalid input for age. Please enter a valid number.");
        } catch (Exception e) {
            CommonClass.Notified("An error occurred: " + e.getMessage());
        }
    }

    public void deleteCustomer() {
        try {
            CommonClass.Notified_1("Find Customer By NIC: ");
            String findCustomerNIC = scanner.nextLine();
            Customer customer = searchCustomerByNIC(findCustomerNIC);

            if (customer != null) {
                DB.customers.remove(customer);
                CommonClass.Notified("Customer deleted successfully");
            } else {
                CommonClass.Notified("Customer not found for deletion.");
            }
        } catch (Exception e) {
            CommonClass.Notified("An error occurred: " + e.getMessage());
        }
    }

    public static Customer searchCustomerByNIC(String Customer_NIC) {
        for (Customer Customer : DB.customers) {
            if (Customer.getCustomer_NIC().equalsIgnoreCase(Customer_NIC)) {
                return Customer;
            }
        }
        return null;
    }

    public static void viewAllCustomers() {
        try {
            for (Customer Customer : DB.customers) {
                System.out.println(Customer);
            }
        } catch (Exception e) {
            CommonClass.Notified("An error occurred while displaying customers: " + e.getMessage());
        }
    }

    @Override
    public String toString() {
        return String.format(
                "-------------------------------------------\n" +
                        " %-10s  %-30s \n" +
                        "-------------------------------------------\n" +
                        " %-10s  %-30s \n" +
                        " %-10s  %-30s \n" +
                        " %-10s  %-30s \n" +
                        " %-10s  %-30s \n" +
                        " %-10s  %-30s \n" +
                        " %-10s  %-30s \n" +
                        " %-10s  %-30s \n" +
                        "-------------------------------------------\n",
                "Field", "Value",
                "ID", Customer_ID,
                "Name", Customer_Name,
                "NIC", Customer_NIC,
                "Mobile", Customer_MobileNumber,
                "Age", Customer_Age,
                "Email", Customer_EmailID,
                "Address", Customer_Address,
                "City", Customer_City);
    }

}

import java.util.Scanner;

public class Login {
    public static void AdminMain() {
        String Username = "Amar01";
        String Password = "6446";

        try (Scanner scanner = new Scanner(System.in)) {
            boolean authenticated = false;

            while (!authenticated) {
                CommonClass.Notified("Enter Username : ");
                String username = scanner.next();

                CommonClass.Notified("Enter Password : ");
                String password = scanner.next();

                if (username.equals(Username) && password.equals(Password)) {
                    CommonClass.Notified("Access Granted! Welcome!");
                    MainFunctions.Admin();
                    authenticated = true;
                } else if (username.equals(Username)) {
                    CommonClass.Notified("Invalid Password!");
                } else if (password.equals(Password)) {
                    CommonClass.Notified("Invalid Username!");
                } else {
                    CommonClass.Notified("Invalid Username & Password!");
                }
            }
        } catch (Exception e) {
            CommonClass.Notified("An error occurred: " + e.getMessage());
        }
    }

    public static void loginCustomer() {
        try (Scanner scanner = new Scanner(System.in)) {
            boolean loginSuccessful = false;

            while (!loginSuccessful) {
                CommonClass.Notified_1("Enter Username: ");
                String Customer_username = scanner.next();

                CommonClass.Notified_1("Enter Password: ");
                String Customer_password = scanner.next();

                for (Customer customer : DB.customers) {
                    if (customer.getCustomer_username().equals(Customer_username)
                            && customer.getCustomer_password().equals(Customer_password)) {
                        CommonClass.Notified("Login successful");
                        Customer.lo_Username = Customer_username;
                        Customer.lo_password = Customer_password;
                        Customer.CustomerMenu();
                        loginSuccessful = true;
                        break;
                    }
                }

                if (!loginSuccessful) {
                    CommonClass.Notified("Invalid Username or Password!");
                }
            }
        } catch (Exception e) {
            CommonClass.Notified("An error occurred: " + e.getMessage());
        }
    }
}
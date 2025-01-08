import java.util.Scanner;

public class CustomerLogin extends AbstractLogin {
    @Override
    protected boolean authenticate(String username, String password) {
        for (Customer customer : DB.customers) {
            if (customer.getCustomer_username().equals(username)
                    && customer.getCustomer_password().equals(password)) {
                Customer.lo_Username = username;
                Customer.lo_password = password;
                return true;
            }
        }
        return false;
    }

    @Override
    protected void handleLogin() {
        Scanner scanner = new Scanner(System.in);

        boolean loginSuccessful = false;

        while (!loginSuccessful) {
            CommonClass.Notified_1("Enter Username: ");
            String username = scanner.next();

            CommonClass.Notified_1("Enter Password: ");
            String password = scanner.next();

            if (authenticate(username, password)) {
                CommonClass.Notified("Login successful");
                Customer.CustomerMenu(); // Redirect to Customer menu
                loginSuccessful = true;
            } else {
                CommonClass.Notified("Invalid Username or Password!");
            }
        }
    }
}

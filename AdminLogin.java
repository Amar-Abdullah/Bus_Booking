import java.util.Scanner;

public class AdminLogin extends AbstractLogin {
    private static final String ADMIN_USERNAME = "Amar01";
    private static final String ADMIN_PASSWORD = "6446";

    @Override
    protected boolean authenticate(String username, String password) {
        return ADMIN_USERNAME.equals(username) && ADMIN_PASSWORD.equals(password);
    }

    @Override
    protected void handleLogin() {
        try (Scanner scanner = new Scanner(System.in)) {
            boolean authenticated = false;

            while (!authenticated) {
                CommonClass.Notified("Enter Username: ");
                String username = scanner.next();

                CommonClass.Notified("Enter Password: ");
                String password = scanner.next();

                if (authenticate(username, password)) {
                    CommonClass.Notified("Access Granted! Welcome!");
                    MainFunctions.Admin();
                    authenticated = true;
                } else if (ADMIN_USERNAME.equals(username)) {
                    CommonClass.Notified("Invalid Password!");
                } else if (ADMIN_PASSWORD.equals(password)) {
                    CommonClass.Notified("Invalid Username!");
                } else {
                    CommonClass.Notified("Invalid Username & Password!");
                }
            }
        } catch (Exception e) {
            CommonClass.Notified("An error occurred: " + e.getMessage());
        }
    }
}

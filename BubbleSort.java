import java.util.List;

public class BubbleSort {
    public static void bubbleSorting(List<Customer> customers) {
        int n = customers.size(); // n = get the customer counts
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (customers.get(j).getCustomer_Age() > customers.get(j + 1).getCustomer_Age()) {
                    // swap customers[j] with customers[j + 1]
                    Customer temp = customers.get(j);
                    customers.set(j, customers.get(j + 1));
                    customers.set(j + 1, temp);
                }
            }
        }
    }
}

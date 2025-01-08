import java.util.List;

public class InsertionSort {
    public static void insertionSorting(List<Customer> customers) {
        int n = customers.size(); // n = get the customer counts
        for (int i = 1; i < n; i++) {

            Customer key = customers.get(i);
            int j = i - 1;
            while (j >= 0 && customers.get(j).getCustomer_Age() > key.getCustomer_Age()) {

                customers.set(j + 1, customers.get(j));
                j--;
            }
            customers.set(j + 1, key);
        }

    }
}

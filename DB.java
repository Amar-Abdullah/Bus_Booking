import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class DB {
        public static List<Customer> customers = new ArrayList<Customer>();
        public static List<Bus> Buses = new ArrayList<Bus>();
        public static List<Reservation> reservations = new ArrayList<Reservation>();

        public static void Customer_Data() {
                DB.customers.add(new Customer("C01", "Amar", "amaramhar6451@gmail.com", "Eravur",
                                "286/1, Vithanaiyar Road", "200118302402", 23, "0750449412", "Amar", "6446"));

                DB.customers.add(new Customer("C02", "Amhar", "amarabdullah5148@gmail.com", "Eravur",
                                "286/1, Vithanaiyar Road",
                                "200218302402", 22, "0707188990", "Amhar", "6446"));
                DB.customers.add(new Customer("C03", "Asjath", "asjathahamed123@gmail.com", "Ottamavedi",
                                "Market Road",
                                "200118375401", 21, "0768244589", "Asjath", "6446"));

        }

        public static void Buse_Data() {
                DB.Buses.add(
                                new Bus("B01", "Zeena", "NC-5685", "Kalmunai", "Colombo", "350Km", 2800.00, 35,
                                                LocalTime.of(10, 30)));
                DB.Buses.add(new Bus("B02", "Al-Razith", "AB-2565", "Batticaloa", "Colombo", "300Km", 2000.00, 35,
                                LocalTime.of(10, 30)));
                ;
        }

}
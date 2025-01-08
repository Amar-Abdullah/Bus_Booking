import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;

public class Bus {
    private String Bus_ID, Bus_Name, Bus_Number, Starting_Point, Ending_Point, Distance;
    private double Fare;
    private int Total_Seat;
    private LocalTime Start_Date_Time;
    private List<Reservation> reservations;
    private Queue waitingList;

    private static int busid = 0;

    private static Scanner scanner = new Scanner(System.in);

    public Bus() {
        this.reservations = new ArrayList<>();
        this.waitingList = new Queue();
    }

    public Bus(String Bus_ID, String Bus_Name, String Bus_Number, String Starting_Point, String Ending_Point,
            String Distance, double Fare, int Total_Seat, LocalTime Start_Date_Time) {
        this.Bus_ID = Bus_ID;
        this.Bus_Name = Bus_Name;
        this.Bus_Number = Bus_Number;
        this.Starting_Point = Starting_Point;
        this.Ending_Point = Ending_Point;
        this.Distance = Distance;
        this.Fare = Fare;
        this.Total_Seat = Total_Seat;
        this.Start_Date_Time = Start_Date_Time;
        this.reservations = new ArrayList<>();
        this.waitingList = new Queue();
    }

    public String getBus_ID() {
        return Bus_ID;
    }

    public void setBus_ID(String bus_ID) {
        Bus_ID = bus_ID;
    }

    public String getBus_Name() {
        return Bus_Name;
    }

    public void setBus_Name(String bus_Name) {
        Bus_Name = bus_Name;
    }

    public String getBus_Number() {
        return Bus_Number;
    }

    public void setBus_Number(String bus_Number) {
        Bus_Number = bus_Number;
    }

    public String getStarting_Point() {
        return Starting_Point;
    }

    public void setStarting_Point(String starting_Point) {
        Starting_Point = starting_Point;
    }

    public String getEnding_Point() {
        return Ending_Point;
    }

    public void setEnding_Point(String ending_Point) {
        Ending_Point = ending_Point;
    }

    public String getDistance() {
        return Distance;
    }

    public void setDistance(String distance) {
        Distance = distance;
    }

    public double getFare() {
        return Fare;
    }

    public void setFare(double fare) {
        Fare = fare;
    }

    public int getTotal_Seat() {
        return Total_Seat;
    }

    public void setTotal_Seat(int total_Seat) {
        Total_Seat = total_Seat;
    }

    public LocalTime getStart_Date_Time() {
        return Start_Date_Time;
    }

    public void setStart_Date_Time(LocalTime start_Date_Time) {
        Start_Date_Time = start_Date_Time;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    public Queue getWaitingList() {
        return waitingList;
    }

    public void setWaitingList(Queue waitingList) {
        this.waitingList = waitingList;
    }

    public static void BusMenu() {
        Bus bus = new Bus();

        boolean exit = false;
        while (!exit) {
            CommonClass.Notified("\nBus Menu> Bus Management");
            CommonClass.Notified("==================");
            CommonClass.Notified("1. Insert Bus Info");
            CommonClass.Notified("2. Update Bus Details");
            CommonClass.Notified("3. Remove Bus");
            CommonClass.Notified("4. View All Buses");
            CommonClass.Notified("5. Search Buses by Route, Name and Time");
            CommonClass.Notified("6. View Bus Reserve Details");
            CommonClass.Notified("7. Back Bus Menu");
            CommonClass.Notified("8. Exit");
            CommonClass.Notified("Enter your choice: ");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        bus.insertBus();
                        break;
                    case 2:
                        bus.updateBus();
                        break;
                    case 3:
                        bus.deleteBus();
                        break;
                    case 4:
                        viewAllBuses();
                        break;
                    case 5:
                        searchBusesByRouteNameAndTime();
                        break;
                    case 6:
                        viewAllReservBuses();
                        break;
                    case 7:
                        MainFunctions.Admin();
                        break;
                    case 8:
                        CommonClass.Notified("Exiting...");
                        exit = true;
                        break;
                    default:
                        CommonClass.Notified("Invalid selection. Please enter a number from 1 to 9.");
                }
            } catch (InputMismatchException e) {
                CommonClass.Notified("Invalid input. Please enter a valid integer value.");
                scanner.nextLine(); // clear the invalid input from the scanner
            } catch (DateTimeParseException e) {
                CommonClass.Notified("Time format is incorrect. Please use HH:mm format.");
                scanner.nextLine(); // clear the invalid input from the scanner
            } catch (NumberFormatException e) {
                CommonClass.Notified("Invalid number format. Please enter a valid number.");
            } catch (Exception e) {
                CommonClass.Notified("An unexpected error occurred: " + e.getMessage());
            }
        }
    }

    public void insertBus() {
        try {
            this.Bus_ID = "B0" + (++busid);

            CommonClass.Notified_1("Enter Bus Number: ");
            this.Bus_Number = scanner.nextLine();

            CommonClass.Notified_1("Enter Bus Name: ");
            this.Bus_Name = scanner.nextLine();

            CommonClass.Notified_1("Enter Total Seats: ");
            this.Total_Seat = Integer.parseInt(scanner.nextLine());

            CommonClass.Notified_1("Enter Starting Point: ");
            this.Starting_Point = scanner.nextLine();

            CommonClass.Notified_1("Enter Ending Point: ");
            this.Ending_Point = scanner.nextLine();

            CommonClass.Notified_1("Enter Starting Time (HH:mm): ");
            String startTimeStr = scanner.nextLine();
            String[] Time = startTimeStr.split(":");
            this.Start_Date_Time = LocalTime.of(Integer.parseInt(Time[0]), Integer.parseInt(Time[1]));
            CommonClass.Notified_1("Enter Fare: ");
            this.Fare = Double.parseDouble(scanner.nextLine());
            DB.Buses.add(this);
            CommonClass.Notified("Bus inserted successfully");
        } catch (NumberFormatException e) {
            CommonClass.Notified("Invalid number format. Please enter a valid number.");
        } catch (DateTimeParseException e) {
            CommonClass.Notified("Time format is incorrect. Please use HH:mm format.");
        } catch (Exception e) {
            CommonClass.Notified("An unexpected error occurred: " + e.getMessage());
        }
    }

    public void updateBus() {
        try {
            CommonClass.Notified_1("Enter Bus Number to update: ");
            String findBusNumber = scanner.nextLine();
            Bus bus = searchBusByNumber(findBusNumber);
            Bus newBus = new Bus();

            if (bus != null) {
                CommonClass.Notified_1("Enter Bus Number: ");
                newBus.setBus_Number(scanner.nextLine());

                CommonClass.Notified_1("Enter Bus Name: ");
                newBus.setBus_Name(scanner.nextLine());

                CommonClass.Notified_1("Enter Total Seats: ");
                newBus.setTotal_Seat(Integer.parseInt(scanner.nextLine()));

                CommonClass.Notified_1("Enter Starting Point: ");
                newBus.setStarting_Point(scanner.nextLine());

                CommonClass.Notified_1("Enter Ending Point: ");
                newBus.setEnding_Point(scanner.nextLine());

                CommonClass.Notified_1("Enter Starting Time (HH:mm): ");
                String startTimeStr = scanner.nextLine();
                String[] Time = startTimeStr.split(":");
                this.Start_Date_Time = LocalTime.of(Integer.parseInt(Time[0]), Integer.parseInt(Time[1]));

                CommonClass.Notified_1("Enter Fare: ");
                newBus.setFare(Double.parseDouble(scanner.nextLine()));

                int index = DB.Buses.indexOf(bus);
                DB.Buses.set(index, newBus);
                CommonClass.Notified("Bus updated successfully");
            } else {
                CommonClass.Notified("Bus not found.");
            }
        } catch (NumberFormatException e) {
            CommonClass.Notified("Invalid number format. Please enter a valid number.");
        } catch (DateTimeParseException e) {
            CommonClass.Notified("Invalid time format. Please enter time in HH:mm format.");
        } catch (Exception e) {
            CommonClass.Notified("An unexpected error occurred: " + e.getMessage());
        }
    }

    public void deleteBus() {
        try {
            CommonClass.Notified_1("Enter Bus Number to delete: ");
            String findBusNumber = scanner.nextLine();
            Bus bus = searchBusByNumber(findBusNumber);

            if (bus != null) {
                DB.Buses.remove(bus);
                CommonClass.Notified("Bus deleted successfully");
            } else {
                CommonClass.Notified("Bus not found for delete.");
            }
        } catch (Exception e) {
            CommonClass.Notified("An unexpected error occurred: " + e.getMessage());
        }
    }

    public static void viewAllBuses() {
        if (DB.Buses.isEmpty()) {
            CommonClass.Notified("No buses available.");
            return;
        }

        for (Bus bus : DB.Buses) {
            CommonClass.Notified(bus.toString());
        }
    }

    public static void searchBusesByRouteNameAndTime() {
        try {
            CommonClass.Notified_1("Enter Starting Point: ");
            String startingPoint = scanner.nextLine();
            CommonClass.Notified_1("Enter Ending Point: ");
            String endingPoint = scanner.nextLine();
            CommonClass.Notified_1("Enter Start Time (HH:mm): ");
            String startTimeStr = scanner.nextLine();
            String[] Time = startTimeStr.split(":");
            LocalTime Start_Date_Time = LocalTime.of(Integer.parseInt(Time[0]), Integer.parseInt(Time[1]));

            List<Bus> foundBuses = new ArrayList<>();

            for (Bus bus : DB.Buses) {
                if (bus.getStarting_Point().equalsIgnoreCase(startingPoint) &&
                        bus.getEnding_Point().equalsIgnoreCase(endingPoint) &&
                        bus.getStart_Date_Time().equals(Start_Date_Time)) {
                    foundBuses.add(bus);
                }
            }

            if (foundBuses.isEmpty()) {
                CommonClass.Notified("No buses found with the given criteria.");
            } else {
                for (Bus bus : foundBuses) {
                    CommonClass.Notified(bus.toString());
                }
            }
        } catch (DateTimeParseException e) {
            CommonClass.Notified("Invalid time format. Please enter time in HH:mm format.");
        } catch (Exception e) {
            CommonClass.Notified("An unexpected error occurred: " + e.getMessage());
        }
    }

    public static Bus searchBusByNumber(String busNumber) {
        for (Bus bus : DB.Buses) {
            if (bus.getBus_Number().equalsIgnoreCase(busNumber)) {
                return bus;
            }
        }
        return null;
    }

    public static Customer SearchCustomer(String customerName) {
        for (Customer customer : DB.customers) {
            if (customer.getCustomer_Name().equalsIgnoreCase(customerName)) {
                return customer;
            }
        }
        return null;
    }

    public void reserveBus() {
        try {
            CommonClass.Notified_1("Enter Passenger Name: ");
            String customerName = scanner.nextLine();

            Customer customer = SearchCustomer(customerName);
            CommonClass.Notified_1("Enter Seat Number: ");
            int seatNumber = Integer.parseInt(scanner.nextLine());

            if (seatNumber < 1 || seatNumber > Total_Seat) {
                CommonClass
                        .Notified("Invalid seat number. Please enter a seat number between 1 and " + Total_Seat);
                return;
            }

            for (Reservation res : reservations) {
                if (res.getSeatNumber() == seatNumber) {
                    CommonClass
                            .Notified("This seat is already reserved. Adding to waiting list " + customerName
                                    + " for Seat Number " + seatNumber);
                    notifyWaitingList();
                    return;
                }
            }

            LocalTime now = LocalTime.now();
            Reservation reservation = new Reservation(customer, getStarting_Point(), getEnding_Point(), now,
                    seatNumber, Bus_Number, Bus_Name);

            reservations.add(reservation);
            CommonClass.Notified("Bus reserved successfully for " + customerName);
        } catch (NumberFormatException e) {
            CommonClass.Notified("Invalid number format. Please enter a valid number.");
        } catch (Exception e) {
            CommonClass.Notified("An unexpected error occurred: " + e.getMessage());
        }
    }

    public void cancelReservation() {
        boolean reservationFound = false;

        CommonClass.Notified_1("Enter Passenger Name to cancel reservation: ");
        String customerName = scanner.nextLine();

        CommonClass.Notified_1("Enter Seat Number to cancel reservation: ");
        int seatNumber = Integer.parseInt(scanner.nextLine());

        Reservation cancelledReservation = null;
        for (Reservation reservation : reservations) {
            if (reservation.getCustomer().getCustomer_Name().equalsIgnoreCase(customerName)
                    && reservation.getSeatNumber() == seatNumber) {
                cancelledReservation = reservation;
                break;
            }
        }

        if (cancelledReservation != null) {
            reservations.remove(cancelledReservation);

            CommonClass.Notified("Reservation cancelled for " + customerName + " on seat " + seatNumber);

            promoteFromWaitingList();
            reservationFound = true;

        }

        if (!reservationFound) {
            CommonClass.Notified("Reservation not found for the given passenger name and seat number.");
        }
    }

    private void notifyWaitingList() {
        if (!waitingList.isEmpty()) {
            List<Reservation> notifiedEntries = new ArrayList<>();
            QNode current = waitingList.getFront();

            while (current != null) {
                Reservation waitingEntry = current.reservation;
                int requestedSeat = waitingEntry.getSeatNumber();
                boolean seatAvailable = reservations.stream()
                        .noneMatch(reservation -> reservation.getSeatNumber() == requestedSeat);

                if (seatAvailable) {
                    reservations.add(waitingEntry);
                    notifiedEntries.add(waitingEntry);
                    CommonClass.Notified("Notified " + waitingEntry.getCustomer().getCustomer_Name()
                            + " from waiting list for your seat "
                            + requestedSeat);

                    current = current.next;
                    waitingList.dequeue(); // Remove from waiting list

                } else {
                    current = current.next;
                }
            }
        }
    }

    private void promoteFromWaitingList() {
        if (!waitingList.isEmpty()) {
            Reservation nextReservation = waitingList.dequeue();
            reservations.add(nextReservation);
            CommonClass.Notified("Promoted " + nextReservation.getCustomer().getCustomer_Name() + " from waiting list");
        }
    }

    public static void viewAllReservBuses() {
        CommonClass.Notified(String.format(
                "%-15s%-20s%-20s%-15s%-15s%-15s%-25s%-15s",
                "Passenger ID", "Passenger Name", "Reservation Time", "Seat Number",
                "Starting Point", "Ending Point", "Email ID", "Mobile Number"));
        CommonClass.Notified(
                "----------------------------------------------------------------------------------------------------------------------------"
                        +
                        "---------------------------------------------------------------------");

        for (Bus bus : DB.Buses) {

            for (Reservation reservation : bus.getReservations()) {
                CommonClass.Notified(reservation.getCustomer().getCustomer_ID());
                CommonClass.Notified(reservation.getCustomer().getCustomer_Name());
                System.out.println(reservation.getReservationDate());
                System.out.println(reservation.getSeatNumber());
                reservation.getStarting_point();
                reservation.getEnding_Point();
                reservation.getCustomer().getCustomer_EmailID();
                reservation.getCustomer().getCustomer_MobileNumber();
            }
        }

    }

    @Override
    public String toString() {
        return String.format(
                "+------------------------+--------------------------+\n" +
                        "| %-22s | %-24s |\n" +
                        "+------------------------+--------------------------+\n" +
                        "| %-22s | %-24s |\n" +
                        "+------------------------+--------------------------+\n" +
                        "| %-22s | %-24s |\n" +
                        "+------------------------+--------------------------+\n" +
                        "| %-22s | %-24s |\n" +
                        "+------------------------+--------------------------+\n" +
                        "| %-22s | %-24s |\n" +
                        "+------------------------+--------------------------+\n" +
                        "| %-22s | %-24s |\n" +
                        "+------------------------+--------------------------+\n" +
                        "| %-22s | %-24s |\n" +
                        "+------------------------+--------------------------+\n" +
                        "| %-22s | %-24s |\n" +
                        "+------------------------+--------------------------+\n" +
                        "| %-22s | %-24s |\n" +
                        "+------------------------+--------------------------+\n",
                "Field", "Value",
                "Bus ID", Bus_ID,
                "Bus Name", Bus_Name,
                "Bus Number", Bus_Number,
                "Starting Point", Starting_Point,
                "Ending Point", Ending_Point,
                "Distance", Distance,
                "Fare", Fare,
                "Total Seat", Total_Seat,
                "Start Date & Time", Start_Date_Time);
    }
}

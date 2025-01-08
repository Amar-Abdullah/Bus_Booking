import java.time.LocalTime;

/**
 * Reservation
 */
public class Reservation {
    private LocalTime ReservationDate; // get time format data type
    private String starting_point; // get string data type
    private String ending_Point; // get string data type
    private int SeatNumber; // get intiger format data type
    private String Bus_Number; // get intiger format data type
    private String Bus_Name; // get string data type

    private Customer customer;

    public Reservation(Customer customer, String starting_point, String ending_Point, LocalTime ReservationDate,
            int SeatNumber, String Bus_Number, String Bus_Name) {
        this.customer = customer;
        this.ReservationDate = ReservationDate;
        this.starting_point = starting_point;
        this.ending_Point = ending_Point;
        this.SeatNumber = SeatNumber;
        this.Bus_Number = Bus_Number;
        this.Bus_Name = Bus_Name;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public LocalTime getReservationDate() {
        return ReservationDate;
    }

    public void setReservationDate(LocalTime reservationDate) {
        this.ReservationDate = reservationDate;
    }

    public String getStarting_point() {
        return starting_point;
    }

    public void setStarting_point(String starting_point) {
        this.starting_point = starting_point;
    }

    public String getEnding_Point() {
        return ending_Point;
    }

    public void setEnding_Point(String ending_Point) {
        this.ending_Point = ending_Point;
    }

    public int getSeatNumber() {
        return SeatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.SeatNumber = seatNumber;
    }

    public String getBus_Number() {
        return Bus_Number;
    }

    public void setBus_Number(String bus_Number) {
        Bus_Number = bus_Number;
    }

    public String getBus_Name() {
        return Bus_Name;
    }

    public void setBus_Name(String bus_Name) {
        Bus_Name = bus_Name;
    }

    @Override
    public String toString() {
        return "ReservationEntry{" + "Customer Name: " + customer.getCustomer_Name() + " Reservation Date: "
                + ReservationDate
                + "starting point: " + starting_point + "Ending Point: "
                + ending_Point + "Seat Number: " + SeatNumber + "Bus Number: " + Bus_Number + "Bus Name: " + Bus_Name
                + '}';
    }
}
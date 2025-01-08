public class QNode {
    public Reservation reservation;
    public QNode next;

    public QNode(Reservation reservation) {
        this.reservation = reservation;
        this.next = null;
    }
}

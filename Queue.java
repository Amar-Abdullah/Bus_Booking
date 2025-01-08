public class Queue {
    private QNode front, rear;

    public Queue() {
        this.front = this.rear = null;
    }

    public void enqueue(Reservation reservation) {
        QNode newNode = new QNode(reservation);
        if (rear == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        CommonClass.Notified(
                "Added to waiting list: " + reservation.getCustomer().getCustomer_Name() + reservation.getSeatNumber());
    }

    // Method to remove a reservation from the waiting list
    public Reservation dequeue() {
        if (isEmpty()) {
            CommonClass.Notified("Waiting list is Empty");
            return null;
        }
        Reservation removedReservation = front.reservation;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        CommonClass.Notified("Remove from waiting list: " + removedReservation.getCustomer().getCustomer_Name()
                + removedReservation.getSeatNumber());
        return removedReservation;
    }

    // method to display the waiting list

    public void display() {
        if (isEmpty()) {
            CommonClass.Notified("Waiting List is Empty");
            return;
        }
        CommonClass.Notified_1("Waiting List: ");
        QNode current = front;
        while (current != null) {
            CommonClass.Notified_1(
                    current.reservation.getCustomer().getCustomer_Name() + current.reservation.getSeatNumber());
            current = current.next;
        }
        CommonClass.Notified(null);
    }

    // method to check if waiting list is empty

    public boolean isEmpty() {
        return front == null;
    }

    // method to get the front of the waiting list

    public QNode getFront() {
        return front;
    }
}